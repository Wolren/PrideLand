package net.wolren.land.block.custom.directional;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.Direction;

public class DirectionalGlassBlock extends TintedGlassBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public DirectionalGlassBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        Direction playerFacing = itemPlacementContext.getHorizontalPlayerFacing().getOpposite();
        return getDefaultState().with(FACING, playerFacing);
    }
}