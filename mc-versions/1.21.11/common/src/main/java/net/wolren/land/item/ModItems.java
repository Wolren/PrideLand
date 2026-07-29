package net.wolren.land.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.item.material.RainbowArmorMaterial;
import net.wolren.land.item.material.RainbowToolMaterials;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", new Item(new Item.Settings()));
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",
            new SwordItem(RainbowToolMaterials.RAINBOW,
                    new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(RainbowToolMaterials.RAINBOW, 3, -2.4f))));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",
            new PickaxeItem(RainbowToolMaterials.RAINBOW,
                    new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(RainbowToolMaterials.RAINBOW, 1, -2.8f))));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",
            new AxeItem(RainbowToolMaterials.RAINBOW,
                    new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(RainbowToolMaterials.RAINBOW, 5, -3.0f))));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",
            new ShovelItem(RainbowToolMaterials.RAINBOW,
                    new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(RainbowToolMaterials.RAINBOW, 1.5f, -3.0f))));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",
            new HoeItem(RainbowToolMaterials.RAINBOW,
                    new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(RainbowToolMaterials.RAINBOW, 0, -3f))));

    public static final Item RAINBOW_HELMET = registerItem("rainbow_helmet",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item RAINBOW_CHESTPLATE = registerItem("rainbow_chestplate",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item RAINBOW_LEGGINGS = registerItem("rainbow_leggings",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item RAINBOW_BOOTS = registerItem("rainbow_boots",
            new ArmorItem(RainbowArmorMaterial.RAINBOW, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static final Item RAINBOW_ELYTRA = registerItem("rainbow_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item AGENDER_ELYTRA = registerItem("agender_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item AROMANTIC_ELYTRA = registerItem("aromantic_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item ASEXUAL_ELYTRA = registerItem("asexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item BISEXUAL_ELYTRA = registerItem("bisexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item DEMIBOY_ELYTRA = registerItem("demiboy_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item DEMIGIRL_ELYTRA = registerItem("demigirl_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item DEMISEXUAL_ELYTRA = registerItem("demisexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item GENDERFLUID_ELYTRA = registerItem("genderfluid_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item GENDERQUEER_ELYTRA = registerItem("genderqueer_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item LESBIAN_ELYTRA = registerItem("lesbian_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item NONBINARY_ELYTRA = registerItem("nonbinary_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item PANSEXUAL_ELYTRA = registerItem("pansexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item POLYSEXUAL_ELYTRA = registerItem("polysexual_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item PROGRESS_PRIDE_ELYTRA = registerItem("progress_pride_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item TRANS_ELYTRA = registerItem("trans_elytra",
            new CustomElytraItem(new Item.Settings().maxCount(1).fireproof()));
    public static final Item RAINBOW_SHEEP_SPAWN_EGG = registerItem("rainbow_sheep_spawn_egg",
            new RainbowSpawnEggItem(new Item.Settings()));

    public static Item RAINBOW_SIGN = null;
    public static Item RAINBOW_HANGING_SIGN = null;
    public static Item RAINBOW_BOAT = null;
    public static Item RAINBOW_CHEST_BOAT = null;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LandCommon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Items for " + LandCommon.MOD_ID);
    }
}