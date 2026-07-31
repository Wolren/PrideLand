package net.wolren.land.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CustomElytraItem extends Item {
    public CustomElytraItem(Properties settings) {
        super(settings.durability(432).rarity(Rarity.EPIC)
                .component(DataComponents.GLIDER, Unit.INSTANCE)
                .equippable(EquipmentSlot.CHEST));
    }
}
