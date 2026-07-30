package net.wolren.land.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CustomElytraItem extends Item {
    public CustomElytraItem(Properties settings) {
        super(settings.durability(432).rarity(Rarity.EPIC));
    }
}
