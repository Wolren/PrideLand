package net.wolren.land.item;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye",new Item(keyedSettings("rainbow_dye")));
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",new Item(keyedSettings("rainbow_sword").maxCount(1).fireproof()));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",new Item(keyedSettings("rainbow_pickaxe").maxCount(1).fireproof()));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",new Item(keyedSettings("rainbow_axe").maxCount(1).fireproof()));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",new Item(keyedSettings("rainbow_shovel").maxCount(1).fireproof()));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",new Item(keyedSettings("rainbow_hoe").maxCount(1).fireproof()));
    public static final Item RAINBOW_HELMET = registerItem("rainbow_helmet",new Item(keyedSettings("rainbow_helmet").maxCount(1).fireproof()));
    public static final Item RAINBOW_CHESTPLATE = registerItem("rainbow_chestplate",new Item(keyedSettings("rainbow_chestplate").maxCount(1).fireproof()));
    public static final Item RAINBOW_LEGGINGS = registerItem("rainbow_leggings",new Item(keyedSettings("rainbow_leggings").maxCount(1).fireproof()));
    public static final Item RAINBOW_BOOTS = registerItem("rainbow_boots",new Item(keyedSettings("rainbow_boots").maxCount(1).fireproof()));

    public static final Item RAINBOW_ELYTRA = registerItem("rainbow_elytra",new CustomElytraItem(keyedSettings("rainbow_elytra").maxCount(1).fireproof()));
    public static final Item AGENDER_ELYTRA = registerItem("agender_elytra",new CustomElytraItem(keyedSettings("agender_elytra").maxCount(1).fireproof()));
    public static final Item AROMANTIC_ELYTRA = registerItem("aromantic_elytra",new CustomElytraItem(keyedSettings("aromantic_elytra").maxCount(1).fireproof()));
    public static final Item ASEXUAL_ELYTRA = registerItem("asexual_elytra",new CustomElytraItem(keyedSettings("asexual_elytra").maxCount(1).fireproof()));
    public static final Item BISEXUAL_ELYTRA = registerItem("bisexual_elytra",new CustomElytraItem(keyedSettings("bisexual_elytra").maxCount(1).fireproof()));
    public static final Item DEMIBOY_ELYTRA = registerItem("demiboy_elytra",new CustomElytraItem(keyedSettings("demiboy_elytra").maxCount(1).fireproof()));
    public static final Item DEMIGIRL_ELYTRA = registerItem("demigirl_elytra",new CustomElytraItem(keyedSettings("demigirl_elytra").maxCount(1).fireproof()));
    public static final Item DEMISEXUAL_ELYTRA = registerItem("demisexual_elytra",new CustomElytraItem(keyedSettings("demisexual_elytra").maxCount(1).fireproof()));
    public static final Item GENDERFLUID_ELYTRA = registerItem("genderfluid_elytra",new CustomElytraItem(keyedSettings("genderfluid_elytra").maxCount(1).fireproof()));
    public static final Item GENDERQUEER_ELYTRA = registerItem("genderqueer_elytra",new CustomElytraItem(keyedSettings("genderqueer_elytra").maxCount(1).fireproof()));
    public static final Item LESBIAN_ELYTRA = registerItem("lesbian_elytra",new CustomElytraItem(keyedSettings("lesbian_elytra").maxCount(1).fireproof()));
    public static final Item NONBINARY_ELYTRA = registerItem("nonbinary_elytra",new CustomElytraItem(keyedSettings("nonbinary_elytra").maxCount(1).fireproof()));
    public static final Item PANSEXUAL_ELYTRA = registerItem("pansexual_elytra",new CustomElytraItem(keyedSettings("pansexual_elytra").maxCount(1).fireproof()));
    public static final Item POLYSEXUAL_ELYTRA = registerItem("polysexual_elytra",new CustomElytraItem(keyedSettings("polysexual_elytra").maxCount(1).fireproof()));
    public static final Item PROGRESS_PRIDE_ELYTRA = registerItem("progress_pride_elytra",new CustomElytraItem(keyedSettings("progress_pride_elytra").maxCount(1).fireproof()));
    public static final Item TRANS_ELYTRA = registerItem("trans_elytra",new CustomElytraItem(keyedSettings("trans_elytra").maxCount(1).fireproof()));
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

    public static void registerModItems() {
        LandCommon.LOGGER.info("Registering Items for " + LandCommon.MOD_ID);
    }
}