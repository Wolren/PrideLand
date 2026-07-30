package net.wolren.land.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.custom.CustomElytraItem;
import net.wolren.land.item.custom.RainbowSpawnEggItem;

import java.util.function.Function;

public class ModItems {
    // Dye
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye",
            properties -> new Item(properties));

    // Tools (simple items for now)
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",
            properties -> new Item(properties.stacksTo(1).fireResistant()));

    // Armor (simple items for now)
    public static final Item RAINBOW_HELMET = registerItem("rainbow_helmet",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_CHESTPLATE = registerItem("rainbow_chestplate",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_LEGGINGS = registerItem("rainbow_leggings",
            properties -> new Item(properties.stacksTo(1).fireResistant()));
    public static final Item RAINBOW_BOOTS = registerItem("rainbow_boots",
            properties -> new Item(properties.stacksTo(1).fireResistant()));

    // Elytras
    public static final Item RAINBOW_ELYTRA = registerItem("rainbow_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item AGENDER_ELYTRA = registerItem("agender_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item AROMANTIC_ELYTRA = registerItem("aromantic_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item ASEXUAL_ELYTRA = registerItem("asexual_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item BISEXUAL_ELYTRA = registerItem("bisexual_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item DEMIBOY_ELYTRA = registerItem("demiboy_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item DEMIGIRL_ELYTRA = registerItem("demigirl_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item DEMISEXUAL_ELYTRA = registerItem("demisexual_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item GENDERFLUID_ELYTRA = registerItem("genderfluid_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item GENDERQUEER_ELYTRA = registerItem("genderqueer_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item LESBIAN_ELYTRA = registerItem("lesbian_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item NONBINARY_ELYTRA = registerItem("nonbinary_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item PANSEXUAL_ELYTRA = registerItem("pansexual_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item POLYSEXUAL_ELYTRA = registerItem("polysexual_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item PROGRESS_PRIDE_ELYTRA = registerItem("progress_pride_elytra",
            properties -> new CustomElytraItem(properties));
    public static final Item TRANS_ELYTRA = registerItem("trans_elytra",
            properties -> new CustomElytraItem(properties));

    // Spawn Egg
    public static Item RAINBOW_SHEEP_SPAWN_EGG = registerItem("rainbow_sheep_spawn_egg",
            properties -> new RainbowSpawnEggItem(properties));

    // Signs - set by platform modules
    public static Item RAINBOW_SIGN = null;
    public static Item RAINBOW_HANGING_SIGN = null;
    public static Item RAINBOW_BOAT = null;
    public static Item RAINBOW_CHEST_BOAT = null;

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PrideLand.LOGGER.info("Registering Items for " + PrideLand.MOD_ID);
    }
}
