package net.wolren.land.forge;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;

public class RainbowSignBlockEntity extends SignBlockEntity {
    public RainbowSignBlockEntity(BlockEntityType<? extends SignBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public RainbowSignBlockEntity(BlockPos pos, BlockState state) {
        this(LandForge.RAINBOW_SIGN_BE, pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return LandForge.RAINBOW_SIGN_BE;
    }
}
