package net.wolren.land.item.material;

import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.wolren.land.PrideLand;

import java.util.Map;

public class RainbowArmorMaterial {
    private static ResourceKey<? extends Registry<net.minecraft.world.item.equipment.EquipmentAsset>> ROOT_ID =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static ResourceKey<net.minecraft.world.item.equipment.EquipmentAsset> RAINBOW_KEY = ResourceKey.create(ROOT_ID,
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow"));

    public static final ArmorMaterial RAINBOW = new ArmorMaterial(
            19,
            makeDefense(3, 6, 8, 3, 11),
            19,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0F,
            0.1F,
            Ingredient.of(Items.NETHERITE_INGOT),
            RAINBOW_KEY
    );

    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}
