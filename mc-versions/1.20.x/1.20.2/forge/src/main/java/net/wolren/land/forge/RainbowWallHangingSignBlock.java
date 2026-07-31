package net.wolren.land.forge;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class RainbowWallHangingSignBlock extends WallHangingSignBlock {
    public RainbowWallHangingSignBlock(Settings settings, WoodType woodType) {
        super(settings, woodType);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RainbowHangingSignBlockEntity(pos, state);
    }
}
