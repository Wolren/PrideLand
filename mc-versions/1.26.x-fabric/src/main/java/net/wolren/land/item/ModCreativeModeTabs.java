package net.wolren.land.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeTabBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;

public class ModCreativeModeTabs {
    public static final CreativeModeTab PRIDE_LAND_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "pride_land"),
            FabricCreativeTabBuilder.builder().icon(() -> new ItemStack(ModBlocks.RAINBOW_WOOL))
                    .title(Component.translatable("creativetab.pride_land"))
                    .displayItems((parameters, output) -> {
                        addItemsToGroup(output);
                    }).build());

    public static void addItemsToGroup(CreativeModeTab.Output entries) {
        // Crafting
        entries.accept(ModBlocks.RAINBOW_CRAFTING);

        // Wools
        entries.accept(ModBlocks.RAINBOW_WOOL);
        entries.accept(ModBlocks.TRANS_WOOL);
        entries.accept(ModBlocks.NONBINARY_WOOL);
        entries.accept(ModBlocks.BISEXUAL_WOOL);
        entries.accept(ModBlocks.PANSEXUAL_WOOL);
        entries.accept(ModBlocks.AROMANTIC_WOOL);
        entries.accept(ModBlocks.DEMISEXUAL_WOOL);
        entries.accept(ModBlocks.AGENDER_WOOL);
        entries.accept(ModBlocks.PROGRESS_PRIDE_WOOL);
        entries.accept(ModBlocks.ASEXUAL_WOOL);
        entries.accept(ModBlocks.GENDERFLUID_WOOL);
        entries.accept(ModBlocks.LESBIAN_WOOL);
        entries.accept(ModBlocks.DEMIBOY_WOOL);
        entries.accept(ModBlocks.DEMIGIRL_WOOL);
        entries.accept(ModBlocks.GENDERQUEER_WOOL);
        entries.accept(ModBlocks.POLYSEXUAL_WOOL);

        // Carpets
        entries.accept(ModBlocks.RAINBOW_CARPET);
        entries.accept(ModBlocks.TRANS_CARPET);
        entries.accept(ModBlocks.NONBINARY_CARPET);
        entries.accept(ModBlocks.BISEXUAL_CARPET);
        entries.accept(ModBlocks.PANSEXUAL_CARPET);
        entries.accept(ModBlocks.AROMANTIC_CARPET);
        entries.accept(ModBlocks.DEMISEXUAL_CARPET);
        entries.accept(ModBlocks.AGENDER_CARPET);
        entries.accept(ModBlocks.PROGRESS_PRIDE_CARPET);
        entries.accept(ModBlocks.ASEXUAL_CARPET);
        entries.accept(ModBlocks.GENDERFLUID_CARPET);
        entries.accept(ModBlocks.LESBIAN_CARPET);
        entries.accept(ModBlocks.DEMIBOY_CARPET);
        entries.accept(ModBlocks.DEMIGIRL_CARPET);
        entries.accept(ModBlocks.GENDERQUEER_CARPET);
        entries.accept(ModBlocks.POLYSEXUAL_CARPET);

        // Beds
        entries.accept(ModBlocks.RAINBOW_BED);
        entries.accept(ModBlocks.TRANS_BED);
        entries.accept(ModBlocks.NONBINARY_BED);
        entries.accept(ModBlocks.BISEXUAL_BED);
        entries.accept(ModBlocks.PANSEXUAL_BED);
        entries.accept(ModBlocks.AROMANTIC_BED);
        entries.accept(ModBlocks.DEMISEXUAL_BED);
        entries.accept(ModBlocks.AGENDER_BED);
        entries.accept(ModBlocks.PROGRESS_PRIDE_BED);
        entries.accept(ModBlocks.ASEXUAL_BED);
        entries.accept(ModBlocks.GENDERFLUID_BED);
        entries.accept(ModBlocks.LESBIAN_BED);
        entries.accept(ModBlocks.DEMIBOY_BED);
        entries.accept(ModBlocks.DEMIGIRL_BED);
        entries.accept(ModBlocks.GENDERQUEER_BED);
        entries.accept(ModBlocks.POLYSEXUAL_BED);

        // Glass
        entries.accept(ModBlocks.RAINBOW_STAINED_GLASS);
        entries.accept(ModBlocks.TRANS_STAINED_GLASS);
        entries.accept(ModBlocks.NONBINARY_STAINED_GLASS);
        entries.accept(ModBlocks.BISEXUAL_STAINED_GLASS);
        entries.accept(ModBlocks.PANSEXUAL_STAINED_GLASS);
        entries.accept(ModBlocks.AROMANTIC_STAINED_GLASS);
        entries.accept(ModBlocks.DEMISEXUAL_STAINED_GLASS);
        entries.accept(ModBlocks.AGENDER_STAINED_GLASS);
        entries.accept(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS);
        entries.accept(ModBlocks.ASEXUAL_STAINED_GLASS);
        entries.accept(ModBlocks.GENDERFLUID_STAINED_GLASS);
        entries.accept(ModBlocks.LESBIAN_STAINED_GLASS);
        entries.accept(ModBlocks.DEMIBOY_STAINED_GLASS);
        entries.accept(ModBlocks.DEMIGIRL_STAINED_GLASS);
        entries.accept(ModBlocks.GENDERQUEER_STAINED_GLASS);
        entries.accept(ModBlocks.POLYSEXUAL_STAINED_GLASS);

        // Glass Panes
        entries.accept(ModBlocks.RAINBOW_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.TRANS_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.NONBINARY_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.BISEXUAL_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.AROMANTIC_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.AGENDER_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.ASEXUAL_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.LESBIAN_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.DEMIBOY_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE);
        entries.accept(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE);

        // Wood family
        entries.accept(ModBlocks.RAINBOW_PLANKS);
        entries.accept(ModBlocks.RAINBOW_STAIRS);
        entries.accept(ModBlocks.RAINBOW_SLAB);
        entries.accept(ModBlocks.RAINBOW_FENCE);
        entries.accept(ModBlocks.RAINBOW_FENCE_GATE);
        entries.accept(ModBlocks.RAINBOW_BUTTON);
        entries.accept(ModBlocks.RAINBOW_PRESSURE_PLATE);
        entries.accept(ModBlocks.RAINBOW_DOOR);
        entries.accept(ModBlocks.RAINBOW_TRAPDOOR);

        // Signs (if registered)
        if (ModItems.RAINBOW_SIGN != null) entries.accept(ModItems.RAINBOW_SIGN);
        if (ModItems.RAINBOW_HANGING_SIGN != null) entries.accept(ModItems.RAINBOW_HANGING_SIGN);

        // Concrete & Terracotta
        entries.accept(ModBlocks.RAINBOW_CONCRETE_POWDER);
        entries.accept(ModBlocks.RAINBOW_CONCRETE);
        entries.accept(ModBlocks.RAINBOW_TERRACOTTA);

        // Bricks
        entries.accept(ModBlocks.RAINBOW_BRICKS);
        entries.accept(ModBlocks.RAINBOW_BRICK_STAIRS);
        entries.accept(ModBlocks.RAINBOW_BRICK_SLAB);
        entries.accept(ModBlocks.RAINBOW_BRICK_WALL);

        // Candle
        entries.accept(ModBlocks.RAINBOW_CANDLE);

        // Tools
        entries.accept(ModItems.RAINBOW_SWORD);
        entries.accept(ModItems.RAINBOW_SHOVEL);
        entries.accept(ModItems.RAINBOW_PICKAXE);
        entries.accept(ModItems.RAINBOW_AXE);
        entries.accept(ModItems.RAINBOW_HOE);

        // Dye
        entries.accept(ModItems.RAINBOW_DYE);

        // Armor
        entries.accept(ModItems.RAINBOW_HELMET);
        entries.accept(ModItems.RAINBOW_CHESTPLATE);
        entries.accept(ModItems.RAINBOW_LEGGINGS);
        entries.accept(ModItems.RAINBOW_BOOTS);

        // Elytras
        entries.accept(ModItems.RAINBOW_ELYTRA);
        entries.accept(ModItems.AGENDER_ELYTRA);
        entries.accept(ModItems.AROMANTIC_ELYTRA);
        entries.accept(ModItems.ASEXUAL_ELYTRA);
        entries.accept(ModItems.BISEXUAL_ELYTRA);
        entries.accept(ModItems.DEMIBOY_ELYTRA);
        entries.accept(ModItems.DEMIGIRL_ELYTRA);
        entries.accept(ModItems.DEMISEXUAL_ELYTRA);
        entries.accept(ModItems.GENDERFLUID_ELYTRA);
        entries.accept(ModItems.GENDERQUEER_ELYTRA);
        entries.accept(ModItems.LESBIAN_ELYTRA);
        entries.accept(ModItems.NONBINARY_ELYTRA);
        entries.accept(ModItems.PANSEXUAL_ELYTRA);
        entries.accept(ModItems.POLYSEXUAL_ELYTRA);
        entries.accept(ModItems.PROGRESS_PRIDE_ELYTRA);
        entries.accept(ModItems.TRANS_ELYTRA);

        // Boats (if registered)
        if (ModItems.RAINBOW_BOAT != null) entries.accept(ModItems.RAINBOW_BOAT);
        if (ModItems.RAINBOW_CHEST_BOAT != null) entries.accept(ModItems.RAINBOW_CHEST_BOAT);

        // Spawn egg
        entries.accept(ModItems.RAINBOW_SHEEP_SPAWN_EGG);
    }

    public static void registerCreativeModeTabs() {
        PrideLand.LOGGER.info("Registering Creative Mode Tabs for " + PrideLand.MOD_ID);

        // Add rainbow dye to vanilla Ingredients tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(ModItems.RAINBOW_DYE);
        });
    }
}
