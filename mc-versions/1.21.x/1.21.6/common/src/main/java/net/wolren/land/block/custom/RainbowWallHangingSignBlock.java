package net.wolren.land.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallHangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.entity.custom.block.RainbowHangingSignBlockEntity;

/**
 * Wall hanging sign block with the mod's registered hanging sign block
 * entity type - see RainbowHangingSignBlock for why the override is required.
 */
public class RainbowWallHangingSignBlock extends WallHangingSignBlock {
    public RainbowWallHangingSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RainbowHangingSignBlockEntity(ModEntities.RAINBOW_HANGING_SIGN_BLOCK_ENTITY, pos, state);
    }
}
