package net.wolren.land.item.material;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.EquipmentAssetKeys;
import net.minecraft.world.item.equipment.EquipmentType;

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
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f,
            0.1f,
            TagKey.create(Registries.ITEM, Identifier.withDefaultNamespace("ingots/netherite")),
            EquipmentAssetKeys.NETHERITE
    );
}
