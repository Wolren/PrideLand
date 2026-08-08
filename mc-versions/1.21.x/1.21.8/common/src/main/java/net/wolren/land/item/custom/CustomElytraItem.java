package net.wolren.land.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Unit;
import net.minecraft.util.Rarity;

public class CustomElytraItem extends Item {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432).rarity(Rarity.EPIC)
                .component(DataComponentTypes.GLIDER, Unit.INSTANCE));
    }
}
