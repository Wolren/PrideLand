package net.wolren.land.block.custom.directional;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ConcretePowderBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class DirectionalRainbowConcretePowderBlock extends ConcretePowderBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public DirectionalRainbowConcretePowderBlock(Block hardened, Properties settings) {
        super(hardened, settings);
        this.registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<? extends DirectionalRainbowConcretePowderBlock> codec() {
        return simpleCodec(DirectionalRainbowConcretePowderBlock::new);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        BlockState blockState = super.getStateForPlacement(ctx);
        return blockState != null ? blockState.setValue(FACING, ctx.getHorizontalDirection().getOpposite()) : null;
    }
}
