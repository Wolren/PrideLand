package net.wolren.land.item.material;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.Map;

public class RainbowArmorMaterial {
    public static final ArmorMaterial RAINBOW = new ArmorMaterial(
        37,
        createDefenseMap(3, 8, 6, 3),
        19,
        SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
        3.0f,
        0.1f,
        TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "ingots/netherite")),
        EquipmentAssetKeys.NETHERITE
    );

    private static Map<EquipmentType, Integer> createDefenseMap(int helmet, int chestplate, int leggings, int boots) {
        Map<EquipmentType, Integer> map = new EnumMap<>(EquipmentType.class);
        map.put(EquipmentType.HELMET, helmet);
        map.put(EquipmentType.CHESTPLATE, chestplate);
        map.put(EquipmentType.LEGGINGS, leggings);
        map.put(EquipmentType.BOOTS, boots);
        return map;
    }

    private RainbowArmorMaterial() {}
}
