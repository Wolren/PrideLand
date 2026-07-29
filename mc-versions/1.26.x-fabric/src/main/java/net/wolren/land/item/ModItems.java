package net.wolren.land.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.wolren.land.PrideLand;

import java.util.function.Function;

public class ModItems {
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", Item::new);
    public static final Item RAINBOW_SWORD = registerItem("rainbow_sword",
            properties -> new Item(properties.stacksTo(1).fireproof()));
    public static final Item RAINBOW_PICKAXE = registerItem("rainbow_pickaxe",
            properties -> new Item(properties.stacksTo(1).fireproof()));
    public static final Item RAINBOW_AXE = registerItem("rainbow_axe",
            properties -> new Item(properties.stacksTo(1).fireproof()));
    public static final Item RAINBOW_SHOVEL = registerItem("rainbow_shovel",
            properties -> new Item(properties.stacksTo(1).fireproof()));
    public static final Item RAINBOW_HOE = registerItem("rainbow_hoe",
            properties -> new Item(properties.stacksTo(1).fireproof()));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))));
    }

    public static void registerModItems() {
        PrideLand.LOGGER.info("Registering Mod Items for " + PrideLand.MOD_ID);
    }
}
