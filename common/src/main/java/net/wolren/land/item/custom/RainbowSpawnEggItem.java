package net.wolren.land.item.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.nbt.CompoundTag;
import net.wolren.land.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class RainbowSpawnEggItem extends SpawnEggItem {
    public RainbowSpawnEggItem(EntityType<? extends Mob> type, int primaryColor, int secondaryColor, Item.Properties settings) {
        super(type, primaryColor, secondaryColor, settings);
    }

    @Override
    public EntityType<?> getType(@Nullable CompoundTag nbt) {
        return ModEntities.RAINBOW_SHEEP;
    }
}
