package net.wolren.land.item.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.wolren.land.entity.ModEntities;

public class RainbowSpawnEggItem extends SpawnEggItem {
    public RainbowSpawnEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public EntityType<?> getType(ItemStack stack) {
        return ModEntities.RAINBOW_SHEEP.get();
    }
}
