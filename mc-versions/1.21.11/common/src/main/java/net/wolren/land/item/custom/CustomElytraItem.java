package net.wolren.land.item.custom;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;

/**
 * Elytra item. The EQUIPPABLE component (with the per-elytra equipment asset
 * model key) is added by ModItems.registerElytra - the plain Item.Settings
 * chain here must NOT set .equippable() or it would overwrite that component.
 */
public class CustomElytraItem extends Item {
    public CustomElytraItem(Settings settings) {
        super(settings.maxDamage(432).rarity(Rarity.EPIC)
                .component(DataComponentTypes.GLIDER, Unit.INSTANCE));
    }
}
