package net.wolren.land.item.material;

import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKeys;
import net.wolren.land.LandCommon;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class RainbowArmorMaterial {
    public static final ArmorMaterial RAINBOW = new ArmorMaterial(
            37,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            19,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            3.0f,
            0.1f,
            TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "ingots/netherite")),
            RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(LandCommon.MOD_ID, "rainbow"))
    );
}