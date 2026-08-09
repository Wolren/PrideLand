package net.wolren.land.entity.custom.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;

/**
 * Hanging sign block entity bound to the mod's registered hanging sign
 * BlockEntityType. Vanilla HangingSignBlockEntity has no constructor that
 * accepts a custom type - its (BlockPos, BlockState) ctor hardcodes
 * BlockEntityType.HANGING_SIGN, so a subclass of SignBlockEntity with the
 * hanging-sign constants is required.
 */
public class RainbowHangingSignBlockEntity extends SignBlockEntity {
    private static final int MAX_TEXT_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;

    public RainbowHangingSignBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public int getTextLineHeight() {
        return TEXT_LINE_HEIGHT;
    }

    @Override
    public int getMaxTextWidth() {
        return MAX_TEXT_WIDTH;
    }

    @Override
    public SoundEvent getInteractionFailSound() {
        return SoundEvents.BLOCK_HANGING_SIGN_WAXED_INTERACT_FAIL;
    }
}
