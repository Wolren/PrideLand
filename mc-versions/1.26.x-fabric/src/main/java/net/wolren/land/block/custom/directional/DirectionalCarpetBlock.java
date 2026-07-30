package net.wolren.land.block.custom.directional;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class DirectionalCarpetBlock extends CarpetBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public DirectionalCarpetBlock(Properties settings) {
        super(settings);
        registerDefaultState(getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public MapCodec<? extends DirectionalCarpetBlock> codec() {
        return simpleCodec(DirectionalCarpetBlock::new);
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
