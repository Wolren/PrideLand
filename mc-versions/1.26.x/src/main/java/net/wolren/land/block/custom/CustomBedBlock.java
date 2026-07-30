package net.wolren.land.block.custom;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Custom bed block for PrideLand.
 */
public class CustomBedBlock extends BedBlock {

    public CustomBedBlock(DyeColor dyeColor, Properties properties) {
        super(dyeColor, properties);
    }
}
