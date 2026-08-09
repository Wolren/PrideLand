package net.wolren.land.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.HangingSignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.entity.custom.block.RainbowHangingSignBlockEntity;

/**
 * Hanging sign block with the mod's registered hanging sign block entity
 * type. Vanilla HangingSignBlock.createBlockEntity hardcodes
 * BlockEntityType.HANGING_SIGN whose supported-block set contains only
 * vanilla hanging signs - placing this block with that type throws
 * IllegalStateException from validateSupports.
 */
public class RainbowHangingSignBlock extends HangingSignBlock {
    public RainbowHangingSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RainbowHangingSignBlockEntity(ModEntities.RAINBOW_HANGING_SIGN_BLOCK_ENTITY, pos, state);
    }
}
