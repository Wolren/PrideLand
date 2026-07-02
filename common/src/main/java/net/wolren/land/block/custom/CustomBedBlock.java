package net.wolren.land.block.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.BedBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.CollisionGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class CustomBedBlock extends BedBlock {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;
    protected static final VoxelShape TOP_SHAPE = Shapes.box(0.0, 3.0, 0.0, 16.0, 9.0, 16.0);
    protected static final VoxelShape LEG_1_SHAPE = Shapes.box(0.0, 0.0, 0.0, 3.0, 3.0, 3.0);
    protected static final VoxelShape LEG_2_SHAPE = Shapes.box(0.0, 0.0, 13.0, 3.0, 3.0, 16.0);
    protected static final VoxelShape LEG_3_SHAPE = Shapes.box(13.0, 0.0, 0.0, 16.0, 3.0, 3.0);
    protected static final VoxelShape LEG_4_SHAPE = Shapes.box(13.0, 0.0, 13.0, 16.0, 3.0, 16.0);
    protected static final VoxelShape NORTH_SHAPE = Shapes.or(TOP_SHAPE, LEG_1_SHAPE, LEG_3_SHAPE);
    protected static final VoxelShape SOUTH_SHAPE = Shapes.or(TOP_SHAPE, LEG_2_SHAPE, LEG_4_SHAPE);
    protected static final VoxelShape WEST_SHAPE = Shapes.or(TOP_SHAPE, LEG_1_SHAPE, LEG_2_SHAPE);
    protected static final VoxelShape EAST_SHAPE = Shapes.or(TOP_SHAPE, LEG_3_SHAPE, LEG_4_SHAPE);

    public CustomBedBlock(BlockBehaviour.Properties settings) {
        super(DyeColor.WHITE, settings);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, BedPart.FOOT).setValue(OCCUPIED, false));
    }

    @Nullable
    public static Direction getDirection(BlockGetter world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.getBlock() instanceof BedBlock ? blockState.getValue(FACING) : null;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) {
            return InteractionResult.CONSUME;
        } else {
            if (state.getValue(PART) != BedPart.HEAD) {
                pos = pos.relative(state.getValue(FACING));
                state = world.getBlockState(pos);
                if (!state.is(this)) {
                    return InteractionResult.CONSUME;
                }
            }

            if (!isBedWorking(world)) {
                world.removeBlock(pos, false);
                BlockPos blockPos = pos.relative(state.getValue(FACING).getOpposite());
                if (world.getBlockState(blockPos).is(this)) {
                    world.removeBlock(blockPos, false);
                }

                Vec3 vec3d = pos.getCenter();
                world.explode(null, world.damageSources().badRespawnPointExplosion(vec3d), null, vec3d, 5.0F, true, Level.ExplosionInteraction.BLOCK);
                return InteractionResult.SUCCESS;
            } else if (state.getValue(OCCUPIED)) {
                if (!this.wakeVillager(world, pos)) {
                    player.displayClientMessage(Component.translatable("block.minecraft.bed.occupied"), true);
                }

                return InteractionResult.SUCCESS;
            } else {
                player.startSleepInBed(pos).ifLeft(reason -> {
                    if (reason.getMessage() != null) {
                        player.displayClientMessage(reason.getMessage(), true);
                    }
                });
                return InteractionResult.SUCCESS;
            }
        }
    }


    public static boolean isBedWorking(Level world) {
        return world.dimensionType().bedWorks();
    }

    private boolean wakeVillager(Level world, BlockPos pos) {
        List<Villager> list = world.getEntitiesOfClass(Villager.class, new AABB(pos), LivingEntity::isSleeping);
        if (list.isEmpty()) {
            return false;
        } else {
            list.get(0).stopSleeping();
            return true;
        }
    }

    @Override
    public void fallOn(Level world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        super.fallOn(world, state, pos, entity, fallDistance * 0.5F);
    }

    @Override
    public void updateEntityAfterFallOn(BlockGetter world, Entity entity) {
        if (entity.isSuppressingBounce()) {
            super.updateEntityAfterFallOn(world, entity);
        } else {
            this.bounceEntity(entity);
        }
    }

    private void bounceEntity(Entity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        if (vec3.y < 0.0) {
            double d = entity instanceof LivingEntity ? 1.0 : 0.8;
            entity.setDeltaMovement(vec3.x, -vec3.y * 0.66F * d, vec3.z);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == getDirectionTowardsOtherPart(state.getValue(PART), state.getValue(FACING))) {
            return neighborState.is(this) && neighborState.getValue(PART) != state.getValue(PART)
                    ? state.setValue(OCCUPIED, neighborState.getValue(OCCUPIED))
                    : Blocks.AIR.defaultBlockState();
        } else {
            return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    private static Direction getDirectionTowardsOtherPart(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    @Override
    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        if (!world.isClientSide && player.isCreative()) {
            BedPart bedPart = state.getValue(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.relative(getDirectionTowardsOtherPart(bedPart, state.getValue(FACING)));
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.is(this) && blockState.getValue(PART) == BedPart.HEAD) {
                    world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
                    world.globalLevelEvent(2001, blockPos, Block.getId(blockState));
                }
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getHorizontalDirection();
        BlockPos blockPos = ctx.getClickedPos();
        BlockPos blockPos2 = blockPos.relative(direction);
        Level world = ctx.getLevel();
        return world.getBlockState(blockPos2).canBeReplaced(ctx) && world.getWorldBorder().isWithinBounds(blockPos2)
                ?                 this.defaultBlockState()      .setValue(FACING, direction)
                : null;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction direction = getOppositePartDirection(state).getOpposite();
        switch(direction) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return EAST_SHAPE;
        }
    }

    public static Direction getOppositePartDirection(BlockState state) {
        Direction direction = state.getValue(FACING);
        return state.getValue(PART) == BedPart.HEAD ? direction.getOpposite() : direction;
    }

    public static DoubleBlockCombiner.BlockType getBedPart(BlockState state) {
        BedPart bedPart = state.getValue(PART);
        return bedPart == BedPart.HEAD ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    private static boolean isBedBelow(BlockGetter world, BlockPos pos) {
        return world.getBlockState(pos.below()).getBlock() instanceof BedBlock;
    }

    public static Optional<Vec3> findWakeUpPosition(EntityType<?> type, CollisionGetter world, BlockPos pos, Direction bedDirection, float spawnAngle) {
        Direction direction = bedDirection.getClockWise();
        Direction direction2 = Math.abs(direction.toYRot() - spawnAngle) < 1.0E-5F ? direction.getOpposite() : direction;
        if (isBedBelow(world, pos)) {
            return findWakeUpPosition(type, world, pos, bedDirection, direction2);
        } else {
            int[][] is = getAroundAndOnBedOffsets(bedDirection, direction2);
            Optional<Vec3> optional = findWakeUpPosition(type, world, pos, is, true);
            return optional.isPresent() ? optional : findWakeUpPosition(type, world, pos, is, false);
        }
    }

    private static Optional<Vec3> findWakeUpPosition(EntityType<?> type, CollisionGetter world, BlockPos pos, Direction bedDirection, Direction respawnDirection) {
        int[][] is = getAroundBedOffsets(bedDirection, respawnDirection);
        Optional<Vec3> optional = findWakeUpPosition(type, world, pos, is, true);
        if (optional.isPresent()) {
            return optional;
        } else {
            BlockPos blockPos = pos.below();
            Optional<Vec3> optional2 = findWakeUpPosition(type, world, blockPos, is, true);
            if (optional2.isPresent()) {
                return optional2;
            } else {
                int[][] js = getOnBedOffsets(bedDirection);
                Optional<Vec3> optional3 = findWakeUpPosition(type, world, pos, js, true);
                if (optional3.isPresent()) {
                    return optional3;
                } else {
                    Optional<Vec3> optional4 = findWakeUpPosition(type, world, pos, is, false);
                    if (optional4.isPresent()) {
                        return optional4;
                    } else {
                        Optional<Vec3> optional5 = findWakeUpPosition(type, world, blockPos, is, false);
                        return optional5.isPresent() ? optional5 : findWakeUpPosition(type, world, pos, js, false);
                    }
                }
            }
        }
    }

    private static Optional<Vec3> findWakeUpPosition(EntityType<?> type, CollisionGetter world, BlockPos pos, int[][] possibleOffsets, boolean ignoreInvalidPos) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

        for(int[] is : possibleOffsets) {
            mutable.set(pos.getX() + is[0], pos.getY(), pos.getZ() + is[1]);
            Vec3 vec3d = DismountHelper.findSafeDismountLocation(type, world, mutable, ignoreInvalidPos);
            if (vec3d != null) {
                return Optional.of(vec3d);
            }
        }

        return Optional.empty();
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART, OCCUPIED);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CustomBedBlockEntity(pos, state);
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.setPlacedBy(world, pos, state, placer, itemStack);
        if (!world.isClientSide) {
            BlockPos blockPos = pos.relative(state.getValue(FACING));
            world.setBlock(blockPos, state.setValue(PART, BedPart.HEAD), 3);
            world.updateNeighbourForOutputSignal(pos, Blocks.AIR);
        }
    }

    @Override
    public long getSeed(BlockState state, BlockPos pos) {
        BlockPos blockPos = pos.relative(state.getValue(FACING), state.getValue(PART) == BedPart.HEAD ? 0 : 1);
        return Mth.getSeed(blockPos.getX(), pos.getY(), blockPos.getZ());
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter world, BlockPos pos, PathComputationType type) {
        return false;
    }

    private static int[][] getAroundAndOnBedOffsets(Direction bedDirection, Direction respawnDirection) {
        return ArrayUtils.addAll(getAroundBedOffsets(bedDirection, respawnDirection), getOnBedOffsets(bedDirection));
    }

    private static int[][] getAroundBedOffsets(Direction bedDirection, Direction respawnDirection) {
        return new int[][]{
                {respawnDirection.getStepX(), respawnDirection.getStepZ()},
                {respawnDirection.getStepX() - bedDirection.getStepX(), respawnDirection.getStepZ() - bedDirection.getStepZ()},
                {respawnDirection.getStepX() - bedDirection.getStepX() * 2, respawnDirection.getStepZ() - bedDirection.getStepZ() * 2},
                {-bedDirection.getStepX() * 2, -bedDirection.getStepZ() * 2},
                {-respawnDirection.getStepX() - bedDirection.getStepX() * 2, -respawnDirection.getStepZ() - bedDirection.getStepZ() * 2},
                {-respawnDirection.getStepX() - bedDirection.getStepX(), -respawnDirection.getStepZ() - bedDirection.getStepZ()},
                {-respawnDirection.getStepX(), -respawnDirection.getStepZ()},
                {-respawnDirection.getStepX() + bedDirection.getStepX(), -respawnDirection.getStepZ() + bedDirection.getStepZ()},
                {bedDirection.getStepX(), bedDirection.getStepZ()},
                {respawnDirection.getStepX() + bedDirection.getStepX(), respawnDirection.getStepZ() + bedDirection.getStepZ()}
        };
    }

    private static int[][] getOnBedOffsets(Direction bedDirection) {
        return new int[][]{{0, 0}, {-bedDirection.getStepX(), -bedDirection.getStepZ()}};
    }
}