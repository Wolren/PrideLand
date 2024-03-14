package net.wolren.land.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.base.MonoColorSheep;

public class RainbowSheepEntity extends MonoColorSheep {
    public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, World world) {
        super(type, world, new ItemStack(ModBlocks.RAINBOW_WOOL));
    }
}
