package net.wolren.land.item;

import net.minecraft.item.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.custom.CustomElytraItem;
import net.minecraft.item.SpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", new Item(keyedSettings("rainbow_dye")));



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



    public static final ArmorItem RAINBOW_HELMET = (ArmorItem) registerItem("rainbow_helmet",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, EquipmentType.HELMET, keyedSettings("rainbow_helmet").maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_CHESTPLATE = (ArmorItem) registerItem("rainbow_chestplate",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, EquipmentType.CHESTPLATE, keyedSettings("rainbow_chestplate").maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_LEGGINGS = (ArmorItem) registerItem("rainbow_leggings",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, EquipmentType.LEGGINGS, keyedSettings("rainbow_leggings").maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_BOOTS = (ArmorItem) registerItem("rainbow_boots",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, EquipmentType.BOOTS, keyedSettings("rainbow_boots").maxCount(1).fireproof()));



    // Sign items — set by platform-specific modules (Terraform API on Fabric, vanilla on Forge)
    public static SignItem RAINBOW_SIGN = null;
    public static HangingSignItem RAINBOW_HANGING_SIGN = null;



    // TODO: Re-add boat items when Terraform API is available on Architectury (Fabric-only API currently)
    public static Item RAINBOW_BOAT = null;
    public static Item RAINBOW_CHEST_BOAT = null;



    public static final AxeItem RAINBOW_AXE = (AxeItem) registerItem("rainbow_axe",
            new AxeItem(ToolMaterial.NETHERITE, 5.0F, -3.0F, keyedSettings("rainbow_axe").maxCount(1).fireproof()));
    public static final HoeItem RAINBOW_HOE = (HoeItem) registerItem("rainbow_hoe",
            new HoeItem(ToolMaterial.NETHERITE, -1.0F, -1.0F, keyedSettings("rainbow_hoe").maxCount(1).fireproof()));
    public static final PickaxeItem RAINBOW_PICKAXE = (PickaxeItem) registerItem("rainbow_pickaxe",
            new PickaxeItem(ToolMaterial.NETHERITE, 1.0F, -2.8F, keyedSettings("rainbow_pickaxe").maxCount(1).fireproof()));
    public static final ShovelItem RAINBOW_SHOVEL = (ShovelItem) registerItem("rainbow_shovel",
            new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -3.0F, keyedSettings("rainbow_shovel").maxCount(1).fireproof()));
    public static final SwordItem RAINBOW_SWORD = (SwordItem) registerItem("rainbow_sword",
            new SwordItem(ToolMaterial.NETHERITE, 3.0F, -2.4F, keyedSettings("rainbow_sword").maxCount(1).fireproof()));



    public static SpawnEggItem RAINBOW_SHEEP_SPAWN_EGG = null;



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
                                .model(id)
                                .damageOnHurt(false)
                                .build());
        return Registry.register(Registries.ITEM, id, new CustomElytraItem(settings));
    }

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Mod Items for " + LandCommon.LOGGER);
    }
}
