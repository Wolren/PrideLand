package net.wolren.land.block.custom.directional;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.Direction;

public class DirectionalCarpetBlock extends CarpetBlock {
    public static final EnumProperty<net.minecraft.util.math.Direction> FACING = HorizontalFacingBlock.FACING;

    public DirectionalCarpetBlock(AbstractBlock.Settings settings) {
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

