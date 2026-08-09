package net.wolren.land.item;

import net.minecraft.item.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.item.material.RainbowArmorMaterial;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye",new Item(keyedSettings("rainbow_dye")));
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",
            new Item.Settings().maxCount(1).fireproof().sword(ToolMaterial.NETHERITE, 3.0F, -2.4F));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",
            new Item.Settings().maxCount(1).fireproof().pickaxe(ToolMaterial.NETHERITE, 1.0F, -2.8F));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",
            new AxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, keyedSettings("rainbow_axe").maxCount(1).fireproof()));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",
            new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3.0F, keyedSettings("rainbow_shovel").maxCount(1).fireproof()));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",
            new HoeItem(ToolMaterial.NETHERITE, -4.0F, 0.0F, keyedSettings("rainbow_hoe").maxCount(1).fireproof()));
    public static final Item RAINBOW_HELMET = registerItem("rainbow_helmet",
            new Item.Settings().maxCount(1).fireproof()
                    .armor(RainbowArmorMaterial.RAINBOW, EquipmentType.HELMET));
    public static final Item RAINBOW_CHESTPLATE = registerItem("rainbow_chestplate",
            new Item.Settings().maxCount(1).fireproof()
                    .armor(RainbowArmorMaterial.RAINBOW, EquipmentType.CHESTPLATE));
    public static final Item RAINBOW_LEGGINGS = registerItem("rainbow_leggings",
            new Item.Settings().maxCount(1).fireproof()
                    .armor(RainbowArmorMaterial.RAINBOW, EquipmentType.LEGGINGS));
    public static final Item RAINBOW_BOOTS = registerItem("rainbow_boots",
            new Item.Settings().maxCount(1).fireproof()
                    .armor(RainbowArmorMaterial.RAINBOW, EquipmentType.BOOTS));

    public static final Item RAINBOW_ELYTRA = registerElytra("rainbow_elytra");
    public static final Item AGENDER_ELYTRA = registerElytra("agender_elytra");
    public static final Item AROMANTIC_ELYTRA = registerElytra("aromantic_elytra");
    public static final Item ASEXUAL_ELYTRA = registerElytra("asexual_elytra");
    public static final Item BISEXUAL_ELYTRA = registerElytra("bisexual_elytra");
    public static final Item DEMIBOY_ELYTRA = registerElytra("demiboy_elytra");
    public static final Item DEMIGIRL_ELYTRA = registerElytra("demigirl_elytra");
    public static final Item DEMISEXUAL_ELYTRA = registerElytra("demisexual_elytra");
    public static final Item GENDERFLUID_ELYTRA = registerElytra("genderfluid_elytra");
    public static final Item GENDERQUEER_ELYTRA = registerElytra("genderqueer_elytra");
    public static final Item LESBIAN_ELYTRA = registerElytra("lesbian_elytra");
    public static final Item NONBINARY_ELYTRA = registerElytra("nonbinary_elytra");
    public static final Item PANSEXUAL_ELYTRA = registerElytra("pansexual_elytra");
    public static final Item POLYSEXUAL_ELYTRA = registerElytra("polysexual_elytra");
    public static final Item PROGRESS_PRIDE_ELYTRA = registerElytra("progress_pride_elytra");
    public static final Item TRANS_ELYTRA = registerElytra("trans_elytra");
    public static Item RAINBOW_SHEEP_SPAWN_EGG = registerItem("rainbow_sheep_spawn_egg",new RainbowSpawnEggItem(keyedSettings("rainbow_sheep_spawn_egg")));

    public static Item RAINBOW_SIGN = null;
    public static Item RAINBOW_HANGING_SIGN = null;
    public static Item RAINBOW_BOAT = null;
    public static Item RAINBOW_CHEST_BOAT = null;


    private static Item.Settings keyedSettings(String name) {
        Identifier id = Identifier.of(LandCommon.MOD_ID, name);
        return new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
    }

    private static Item registerItem(String name, Item.Settings settings) {
        Identifier id = Identifier.of(LandCommon.MOD_ID, name);
        settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id));
        return Registry.register(Registries.ITEM, id, new Item(settings));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LandCommon.MOD_ID, name), item);
    }


    private static Item registerElytra(String name) {
        Identifier id = Identifier.of(LandCommon.MOD_ID, name);
        Item.Settings settings = new Item.Settings().maxCount(1).fireproof()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, id))
                .component(DataComponentTypes.EQUIPPABLE,
                        EquippableComponent.builder(EquipmentSlot.CHEST)
                                .equipSound(SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA)
                                .model(RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, id))
                                .damageOnHurt(false)
                                .build());
        return Registry.register(Registries.ITEM, id, new CustomElytraItem(settings));
    }

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Items for " + LandCommon.MOD_ID);
    }
}