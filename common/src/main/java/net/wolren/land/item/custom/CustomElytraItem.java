package net.wolren.land.item.custom;

import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CustomElytraItem extends ElytraItem {
    public CustomElytraItem(Item.Properties settings) {
        super(settings.defaultDurability(432).rarity(Rarity.EPIC));
    }

    @Override
    public boolean canBeDepleted() {
        return true;
    }
}
