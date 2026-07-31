package net.wolren.land.forge;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class RainbowHangingSignBlockEntity extends HangingSignBlockEntity {
    public RainbowHangingSignBlockEntity(BlockEntityType<? extends HangingSignBlockEntity> type, BlockPos pos, BlockState state) {
        super(pos, state);
    }

    public RainbowHangingSignBlockEntity(BlockPos pos, BlockState state) {
        this(LandForge.RAINBOW_HANGING_SIGN_BE, pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return LandForge.RAINBOW_HANGING_SIGN_BE;
    }
}
