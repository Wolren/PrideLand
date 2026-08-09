package net.wolren.land.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.entity.ModEntities;

/**
 * Wall sign block with the mod's registered sign block entity type - see
 * RainbowSignBlock for why the override is required.
 */
public class RainbowWallSignBlock extends WallSignBlock {
    public RainbowWallSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SignBlockEntity(ModEntities.RAINBOW_SIGN_BLOCK_ENTITY, pos, state);
    }
}
