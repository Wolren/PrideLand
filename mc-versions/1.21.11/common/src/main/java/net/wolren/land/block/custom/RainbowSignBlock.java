package net.wolren.land.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.SignBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.entity.ModEntities;

/**
 * Sign block whose block entity uses the mod's registered sign block entity
 * type instead of the vanilla minecraft:sign type (vanilla's createBlockEntity
 * hardcodes BlockEntityType.SIGN, whose supported-block set contains only
 * vanilla sign blocks - placing this block with that type throws
 * IllegalStateException from validateSupports).
 */
public class RainbowSignBlock extends SignBlock {
    public RainbowSignBlock(WoodType woodType, Settings settings) {
        super(woodType, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SignBlockEntity(ModEntities.RAINBOW_SIGN_BLOCK_ENTITY, pos, state);
    }
}
