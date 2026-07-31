package net.wolren.land.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;

public class RainbowDoorBlock extends DoorBlock {

    public RainbowDoorBlock(BlockSetType blockSetType, Properties settings) {
        super(blockSetType, settings);
    }

    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
        if (isDirectlyBroken(state, world, pos)) {
            super.playerDestroy(world, player, pos, state, blockEntity, stack);
        }
    }

    private static boolean isDirectlyBroken(BlockState state, Level world, BlockPos pos) {
        if (!state.hasProperty(HALF)) return true;

        DoubleBlockHalf half = state.getValue(HALF);
        BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        BlockState otherState = world.getBlockState(otherPos);

        return otherState.is(state.getBlock())
                && otherState.hasProperty(HALF)
                && otherState.getValue(HALF) != half;
    }
}
