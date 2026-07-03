package net.wolren.land.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.NbtCompound;
import net.wolren.land.entity.ModEntities;
import org.jetbrains.annotations.Nullable;

public class RainbowSpawnEggItem extends SpawnEggItem {
    public RainbowSpawnEggItem(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(type, primaryColor, secondaryColor, settings);
    }

    @Override
    public EntityType<?> getEntityType(@Nullable NbtCompound nbt) {
        return ModEntities.RAINBOW_SHEEP;
    }
}
