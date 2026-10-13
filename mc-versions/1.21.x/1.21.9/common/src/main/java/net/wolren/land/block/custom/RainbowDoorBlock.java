package net.wolren.land.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Custom door block that handles the double-tall drop issue on Forge.
 * <p>
 * Forge removes the {@code state.onBreak()} call from {@code ServerPlayerGameMode.destroyBlock()},
 * which means {@link DoorBlock#onBreak} is never called. In vanilla, {@code onBreak()} handles
 * breaking the other half of the door, but without it both halves independently trigger
 * {@code dropStacks()}, resulting in 2 door items instead of 1.
 * <p>
 * This override prevents the orphaned half from dropping items by checking if its counterpart
 * still exists. Only the half that was directly broken by the player drops items.
 */
public class RainbowDoorBlock extends DoorBlock {

    public RainbowDoorBlock(BlockSetType blockSetType, Settings settings) {
        super(blockSetType, settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
        if (isDirectlyBroken(state, world, pos)) {
            super.afterBreak(world, player, pos, state, blockEntity, stack);
        }
    }

    /**
     * Determines whether this half of the door is being broken directly by the player.
     * A half is "directly broken" when the other half of the door is still intact.
     * It is an "orphan" when the other half has already been removed.
     */
    private static boolean isDirectlyBroken(BlockState state, World world, BlockPos pos) {
        if (!state.contains(HALF)) return true;

        DoubleBlockHalf half = state.get(HALF);
        BlockPos otherPos = half == DoubleBlockHalf.LOWER ? pos.up() : pos.down();
        BlockState otherState = world.getBlockState(otherPos);

        return otherState.isOf(state.getBlock())
                && otherState.contains(HALF)
                && otherState.get(HALF) != half;
    }
}
