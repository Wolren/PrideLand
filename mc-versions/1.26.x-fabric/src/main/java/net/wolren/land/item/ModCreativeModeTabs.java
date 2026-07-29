package net.wolren.land.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final CreativeModeTab PRIDE_LAND_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "pride_land"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RAINBOW_WOOL))
                    .title(Component.translatable("creativetab.pride_land"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.RAINBOW_WOOL);
                        output.accept(ModBlocks.RAINBOW_PLANKS);
                        output.accept(ModBlocks.RAINBOW_BRICKS);
                        output.accept(ModBlocks.RAINBOW_STAINED_GLASS);
                        output.accept(ModBlocks.RAINBOW_CRAFTING);
                        output.accept(ModItems.RAINBOW_DYE);
                        output.accept(ModItems.RAINBOW_SWORD);
                        output.accept(ModItems.RAINBOW_PICKAXE);
                        output.accept(ModItems.RAINBOW_AXE);
                        output.accept(ModItems.RAINBOW_SHOVEL);
                        output.accept(ModItems.RAINBOW_HOE);
                    }).build());

    public static void registerCreativeModeTabs() {
        PrideLand.LOGGER.info("Registering Creative Mode Tabs for " + PrideLand.MOD_ID);

        // Add items to vanilla Ingredients tab
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(ModItems.RAINBOW_DYE);
        });
    }
}
