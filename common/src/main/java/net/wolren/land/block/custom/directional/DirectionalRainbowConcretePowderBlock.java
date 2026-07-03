package net.wolren.land.block.custom.directional;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ConcretePowderBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class DirectionalRainbowConcretePowderBlock extends ConcretePowderBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public DirectionalRainbowConcretePowderBlock(Block hardened, Settings settings) {
        super(hardened, settings);
        this.setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = super.getPlacementState(ctx);
        return blockState.with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}


