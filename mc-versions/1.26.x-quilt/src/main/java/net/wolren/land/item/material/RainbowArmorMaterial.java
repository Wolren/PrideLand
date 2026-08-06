package net.wolren.land.item.material;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.wolren.land.PrideLand;

import java.util.EnumMap;
import java.util.Map;

public class RainbowArmorMaterial {
    public static final ArmorMaterial RAINBOW = new ArmorMaterial(
            37,
            createProtectionMap(3, 8, 6, 3),
            19,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f,
            0.1f,
            TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("minecraft", "ingots/netherite")),
            ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow"))
    );

    private static Map<ArmorType, Integer> createProtectionMap(int helmet, int chestplate, int leggings, int boots) {
        Map<ArmorType, Integer> map = new EnumMap<>(ArmorType.class);
        map.put(ArmorType.HELMET, helmet);
        map.put(ArmorType.CHESTPLATE, chestplate);
        map.put(ArmorType.LEGGINGS, leggings);
        map.put(ArmorType.BOOTS, boots);
        return map;
    }
}
