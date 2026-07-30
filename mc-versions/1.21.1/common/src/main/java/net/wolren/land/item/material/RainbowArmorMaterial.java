package net.wolren.land.item.material;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;

import java.util.EnumMap;
import java.util.Map;

public class RainbowArmorMaterial {
    public static final RegistryEntry<ArmorMaterial> RAINBOW = register();

    private static RegistryEntry<ArmorMaterial> register() {
        Map<ArmorItem.Type, Integer> protection = new EnumMap<>(ArmorItem.Type.class);
        protection.put(ArmorItem.Type.HELMET, 3);
        protection.put(ArmorItem.Type.CHESTPLATE, 8);
        protection.put(ArmorItem.Type.LEGGINGS, 6);
        protection.put(ArmorItem.Type.BOOTS, 3);

        ArmorMaterial material = new ArmorMaterial(37, protection, 19,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                () -> Ingredient.ofItems(Items.NETHERITE_INGOT),
                3.0F, 0.1F, false);

        return Registry.register(Registries.ARMOR_MATERIAL,
                Identifier.of(LandCommon.MOD_ID, "rainbow"), material);
    }
}
