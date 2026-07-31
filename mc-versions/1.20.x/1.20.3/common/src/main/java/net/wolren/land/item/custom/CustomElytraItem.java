package net.wolren.land.item.custom;

import net.minecraft.item.ElytraItem;
import net.minecraft.util.Rarity;

public class CustomElytraItem extends ElytraItem {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}
