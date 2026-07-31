package net.wolren.land.block.custom.directional;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class DirectionalGlassBlock extends Block {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    public DirectionalGlassBlock(Properties settings) {
        super(settings);
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<DirectionalGlassBlock> codec() {
        return simpleCodec(DirectionalGlassBlock::new);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction playerFacing = ctx.getHorizontalDirection().getOpposite();
        return defaultBlockState().setValue(FACING, playerFacing);
    }
}
