package net.wolren.land.item;

import net.minecraft.item.*;
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



    public static final CustomElytraItem RAINBOW_ELYTRA = (CustomElytraItem) registerItem("rainbow_elytra",
            new CustomElytraItem(keyedSettings("rainbow_elytra").maxCount(1)));
    public static final CustomElytraItem AGENDER_ELYTRA = (CustomElytraItem) registerItem("agender_elytra",
            new CustomElytraItem(keyedSettings("agender_elytra").maxCount(1)));
    public static final CustomElytraItem AROMANTIC_ELYTRA = (CustomElytraItem) registerItem("aromantic_elytra",
            new CustomElytraItem(keyedSettings("aromantic_elytra").maxCount(1)));
    public static final CustomElytraItem ASEXUAL_ELYTRA = (CustomElytraItem) registerItem("asexual_elytra",
            new CustomElytraItem(keyedSettings("asexual_elytra").maxCount(1)));
    public static final CustomElytraItem BISEXUAL_ELYTRA = (CustomElytraItem) registerItem("bisexual_elytra",
            new CustomElytraItem(keyedSettings("bisexual_elytra").maxCount(1)));
    public static final CustomElytraItem DEMIBOY_ELYTRA = (CustomElytraItem) registerItem("demiboy_elytra",
            new CustomElytraItem(keyedSettings("demiboy_elytra").maxCount(1)));
    public static final CustomElytraItem DEMIGIRL_ELYTRA = (CustomElytraItem) registerItem("demigirl_elytra",
            new CustomElytraItem(keyedSettings("demigirl_elytra").maxCount(1)));
    public static final CustomElytraItem DEMISEXUAL_ELYTRA = (CustomElytraItem) registerItem("demisexual_elytra",
            new CustomElytraItem(keyedSettings("demisexual_elytra").maxCount(1)));
    public static final CustomElytraItem GENDERFLUID_ELYTRA = (CustomElytraItem) registerItem("genderfluid_elytra",
            new CustomElytraItem(keyedSettings("genderfluid_elytra").maxCount(1)));
    public static final CustomElytraItem GENDERQUEER_ELYTRA = (CustomElytraItem) registerItem("genderqueer_elytra",
            new CustomElytraItem(keyedSettings("genderqueer_elytra").maxCount(1)));
    public static final CustomElytraItem LESBIAN_ELYTRA = (CustomElytraItem) registerItem("lesbian_elytra",
            new CustomElytraItem(keyedSettings("lesbian_elytra").maxCount(1)));
    public static final CustomElytraItem NONBINARY_ELYTRA = (CustomElytraItem) registerItem("nonbinary_elytra",
            new CustomElytraItem(keyedSettings("nonbinary_elytra").maxCount(1)));
    public static final CustomElytraItem PANSEXUAL_ELYTRA = (CustomElytraItem) registerItem("pansexual_elytra",
            new CustomElytraItem(keyedSettings("pansexual_elytra").maxCount(1)));
    public static final CustomElytraItem POLYSEXUAL_ELYTRA = (CustomElytraItem) registerItem("polysexual_elytra",
            new CustomElytraItem(keyedSettings("polysexual_elytra").maxCount(1)));
    public static final CustomElytraItem PROGRESS_PRIDE_ELYTRA = (CustomElytraItem) registerItem("progress_pride_elytra",
            new CustomElytraItem(keyedSettings("progress_pride_elytra").maxCount(1)));
    public static final CustomElytraItem TRANS_ELYTRA = (CustomElytraItem) registerItem("trans_elytra",
            new CustomElytraItem(keyedSettings("trans_elytra").maxCount(1)));



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



    // Boat items — set by the loaders via the Terraform API
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

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Mod Items for " + LandCommon.LOGGER);
    }
}
