package net.wolren.land.forge;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RainbowWallSignBlock extends WallSignBlock {
    public RainbowWallSignBlock(Settings settings, WoodType woodType) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RainbowSignBlockEntity(LandForge.RAINBOW_SIGN_BE, pos, state);
    }
}
