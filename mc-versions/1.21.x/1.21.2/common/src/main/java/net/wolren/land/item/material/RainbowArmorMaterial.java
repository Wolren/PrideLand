package net.wolren.land.item.material;

import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.Map;

public class RainbowArmorMaterial {
    public static final ArmorMaterial RAINBOW = create();

    private static ArmorMaterial create() {
        Map<EquipmentType, Integer> protection = new EnumMap<>(EquipmentType.class);
        protection.put(EquipmentType.HELMET, 3);
        protection.put(EquipmentType.CHESTPLATE, 8);
        protection.put(EquipmentType.LEGGINGS, 6);
        protection.put(EquipmentType.BOOTS, 3);

        return new ArmorMaterial(40, protection, 19,
                SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
                3.0F, 0.1F,
                TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "repairs_netherite_armor")),
                Identifier.of("pride_land", "rainbow"));
    }
}
