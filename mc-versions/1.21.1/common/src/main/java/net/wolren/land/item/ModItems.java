package net.wolren.land.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.custom.CustomElytraItem;
import net.minecraft.item.SpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", new Item(new Item.Settings()));



    public static final CustomElytraItem RAINBOW_ELYTRA = (CustomElytraItem) registerItem("rainbow_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem AGENDER_ELYTRA = (CustomElytraItem) registerItem("agender_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem AROMANTIC_ELYTRA = (CustomElytraItem) registerItem("aromantic_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem ASEXUAL_ELYTRA = (CustomElytraItem) registerItem("asexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem BISEXUAL_ELYTRA = (CustomElytraItem) registerItem("bisexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem DEMIBOY_ELYTRA = (CustomElytraItem) registerItem("demiboy_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem DEMIGIRL_ELYTRA = (CustomElytraItem) registerItem("demigirl_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem DEMISEXUAL_ELYTRA = (CustomElytraItem) registerItem("demisexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem GENDERFLUID_ELYTRA = (CustomElytraItem) registerItem("genderfluid_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem GENDERQUEER_ELYTRA = (CustomElytraItem) registerItem("genderqueer_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem LESBIAN_ELYTRA = (CustomElytraItem) registerItem("lesbian_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem NONBINARY_ELYTRA = (CustomElytraItem) registerItem("nonbinary_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem PANSEXUAL_ELYTRA = (CustomElytraItem) registerItem("pansexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem POLYSEXUAL_ELYTRA = (CustomElytraItem) registerItem("polysexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem PROGRESS_PRIDE_ELYTRA = (CustomElytraItem) registerItem("progress_pride_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));
    public static final CustomElytraItem TRANS_ELYTRA = (CustomElytraItem) registerItem("trans_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1)));



    public static final ArmorItem RAINBOW_HELMET = (ArmorItem) registerItem("rainbow_helmet",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_CHESTPLATE = (ArmorItem) registerItem("rainbow_chestplate",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_LEGGINGS = (ArmorItem) registerItem("rainbow_leggings",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).fireproof()));
    public static final ArmorItem RAINBOW_BOOTS = (ArmorItem) registerItem("rainbow_boots",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).fireproof()));



    // Sign items — set by platform-specific modules (Terraform API on Fabric, vanilla on Forge)
    public static SignItem RAINBOW_SIGN = null;
    public static HangingSignItem RAINBOW_HANGING_SIGN = null;



    // TODO: Re-add boat items when Terraform API is available on Architectury (Fabric-only API currently)
    public static final Item RAINBOW_BOAT = null;
    public static final Item RAINBOW_CHEST_BOAT = null;



    public static final AxeItem RAINBOW_AXE = (AxeItem) registerItem("rainbow_axe",
            new AxeItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).fireproof()));
    public static final HoeItem RAINBOW_HOE = (HoeItem) registerItem("rainbow_hoe",
            new HoeItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).fireproof()));
    public static final PickaxeItem RAINBOW_PICKAXE = (PickaxeItem) registerItem("rainbow_pickaxe",
            new PickaxeItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).fireproof()));
    public static final ShovelItem RAINBOW_SHOVEL = (ShovelItem) registerItem("rainbow_shovel",
            new ShovelItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).fireproof()));
    public static final SwordItem RAINBOW_SWORD = (SwordItem) registerItem("rainbow_sword",
            new SwordItem(ToolMaterials.NETHERITE, new Item.Settings().maxCount(1).fireproof()));



    public static SpawnEggItem RAINBOW_SHEEP_SPAWN_EGG = null;



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LandCommon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Mod Items for " + LandCommon.LOGGER);
    }
}
