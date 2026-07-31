package net.wolren.land.item.material;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class RainbowArmorMaterial {
    public static final RegistryEntry<ArmorMaterial> RAINBOW = RegistryEntry.of(create());

    private static ArmorMaterial create() {
        Map<ArmorItem.Type, Integer> protection = new EnumMap<>(ArmorItem.Type.class);
        protection.put(ArmorItem.Type.HELMET, 3);
        protection.put(ArmorItem.Type.CHESTPLATE, 8);
        protection.put(ArmorItem.Type.LEGGINGS, 6);
        protection.put(ArmorItem.Type.BOOTS, 3);

        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of("pride_land", "rainbow"))
        );

        return new ArmorMaterial(protection, 19,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                () -> Ingredient.ofItems(Items.NETHERITE_INGOT),
                layers,
                3.0F, 0.1F);
    }
}
