package net.wolren.land.creativetab;

import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

/**
 * PrideLand creative mode tabs — NeoForge 26.X DeferredRegister pattern.
 */
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PrideLand.MOD_ID);

    public static final Supplier<CreativeModeTab> PRIDE_LAND_TAB = CREATIVE_MODE_TABS.register("pride_land_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RAINBOW_WOOL.get()))
                    .title(Component.translatable("creativetab.pride_land.pride_land_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // === Blocks ===

                        // Crafting
                        output.accept(ModBlocks.RAINBOW_CRAFTING);

                        // Wools
                        output.accept(ModBlocks.RAINBOW_WOOL);
                        output.accept(ModBlocks.TRANS_WOOL);
                        output.accept(ModBlocks.NONBINARY_WOOL);
                        output.accept(ModBlocks.BISEXUAL_WOOL);
                        output.accept(ModBlocks.PANSEXUAL_WOOL);
                        output.accept(ModBlocks.AROMANTIC_WOOL);
                        output.accept(ModBlocks.DEMISEXUAL_WOOL);
                        output.accept(ModBlocks.AGENDER_WOOL);
                        output.accept(ModBlocks.PROGRESS_PRIDE_WOOL);
                        output.accept(ModBlocks.ASEXUAL_WOOL);
                        output.accept(ModBlocks.GENDERFLUID_WOOL);
                        output.accept(ModBlocks.LESBIAN_WOOL);
                        output.accept(ModBlocks.DEMIBOY_WOOL);
                        output.accept(ModBlocks.DEMIGIRL_WOOL);
                        output.accept(ModBlocks.GENDERQUEER_WOOL);
                        output.accept(ModBlocks.POLYSEXUAL_WOOL);

                        // Carpets
                        output.accept(ModBlocks.RAINBOW_CARPET);
                        output.accept(ModBlocks.TRANS_CARPET);
                        output.accept(ModBlocks.NONBINARY_CARPET);
                        output.accept(ModBlocks.BISEXUAL_CARPET);
                        output.accept(ModBlocks.PANSEXUAL_CARPET);
                        output.accept(ModBlocks.AROMANTIC_CARPET);
                        output.accept(ModBlocks.DEMISEXUAL_CARPET);
                        output.accept(ModBlocks.AGENDER_CARPET);
                        output.accept(ModBlocks.PROGRESS_PRIDE_CARPET);
                        output.accept(ModBlocks.ASEXUAL_CARPET);
                        output.accept(ModBlocks.GENDERFLUID_CARPET);
                        output.accept(ModBlocks.LESBIAN_CARPET);
                        output.accept(ModBlocks.DEMIBOY_CARPET);
                        output.accept(ModBlocks.DEMIGIRL_CARPET);
                        output.accept(ModBlocks.GENDERQUEER_CARPET);
                        output.accept(ModBlocks.POLYSEXUAL_CARPET);

                        // Beds
                        output.accept(ModBlocks.RAINBOW_BED);
                        output.accept(ModBlocks.TRANS_BED);
                        output.accept(ModBlocks.NONBINARY_BED);
                        output.accept(ModBlocks.BISEXUAL_BED);
                        output.accept(ModBlocks.PANSEXUAL_BED);
                        output.accept(ModBlocks.AROMANTIC_BED);
                        output.accept(ModBlocks.DEMISEXUAL_BED);
                        output.accept(ModBlocks.AGENDER_BED);
                        output.accept(ModBlocks.PROGRESS_PRIDE_BED);
                        output.accept(ModBlocks.ASEXUAL_BED);
                        output.accept(ModBlocks.GENDERFLUID_BED);
                        output.accept(ModBlocks.LESBIAN_BED);
                        output.accept(ModBlocks.DEMIBOY_BED);
                        output.accept(ModBlocks.DEMIGIRL_BED);
                        output.accept(ModBlocks.GENDERQUEER_BED);
                        output.accept(ModBlocks.POLYSEXUAL_BED);

                        // Glass blocks
                        output.accept(ModBlocks.RAINBOW_STAINED_GLASS);
                        output.accept(ModBlocks.TRANS_STAINED_GLASS);
                        output.accept(ModBlocks.NONBINARY_STAINED_GLASS);
                        output.accept(ModBlocks.BISEXUAL_STAINED_GLASS);
                        output.accept(ModBlocks.PANSEXUAL_STAINED_GLASS);
                        output.accept(ModBlocks.AROMANTIC_STAINED_GLASS);
                        output.accept(ModBlocks.DEMISEXUAL_STAINED_GLASS);
                        output.accept(ModBlocks.AGENDER_STAINED_GLASS);
                        output.accept(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS);
                        output.accept(ModBlocks.ASEXUAL_STAINED_GLASS);
                        output.accept(ModBlocks.GENDERFLUID_STAINED_GLASS);
                        output.accept(ModBlocks.LESBIAN_STAINED_GLASS);
                        output.accept(ModBlocks.DEMIBOY_STAINED_GLASS);
                        output.accept(ModBlocks.DEMIGIRL_STAINED_GLASS);
                        output.accept(ModBlocks.GENDERQUEER_STAINED_GLASS);
                        output.accept(ModBlocks.POLYSEXUAL_STAINED_GLASS);

                        // Glass panes
                        output.accept(ModBlocks.RAINBOW_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.TRANS_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.NONBINARY_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.BISEXUAL_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.AROMANTIC_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.AGENDER_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.ASEXUAL_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.LESBIAN_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.DEMIBOY_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE);
                        output.accept(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE);

                        // Planks family
                        output.accept(ModBlocks.RAINBOW_PLANKS);
                        output.accept(ModBlocks.RAINBOW_STAIRS);
                        output.accept(ModBlocks.RAINBOW_SLAB);
                        output.accept(ModBlocks.RAINBOW_FENCE);
                        output.accept(ModBlocks.RAINBOW_FENCE_GATE);
                        output.accept(ModBlocks.RAINBOW_BUTTON);
                        output.accept(ModBlocks.RAINBOW_PRESSURE_PLATE);
                        output.accept(ModBlocks.RAINBOW_DOOR);
                        output.accept(ModBlocks.RAINBOW_TRAPDOOR);

                        // Bricks
                        output.accept(ModBlocks.RAINBOW_BRICKS);
                        output.accept(ModBlocks.RAINBOW_BRICK_STAIRS);
                        output.accept(ModBlocks.RAINBOW_BRICK_SLAB);
                        output.accept(ModBlocks.RAINBOW_BRICK_WALL);

                        // Concrete & Terracotta
                        output.accept(ModBlocks.RAINBOW_CONCRETE);
                        output.accept(ModBlocks.RAINBOW_CONCRETE_POWDER);
                        output.accept(ModBlocks.RAINBOW_TERRACOTTA);

                        // Other blocks
                        output.accept(ModBlocks.RAINBOW_CANDLE);

                        // === Items ===
                        output.accept(ModItems.RAINBOW_SWORD);
                        output.accept(ModItems.RAINBOW_PICKAXE);
                        output.accept(ModItems.RAINBOW_AXE);
                        output.accept(ModItems.RAINBOW_SHOVEL);
                        output.accept(ModItems.RAINBOW_HOE);
                        output.accept(ModItems.RAINBOW_DYE);
                        output.accept(ModItems.RAINBOW_HELMET);
                        output.accept(ModItems.RAINBOW_CHESTPLATE);
                        output.accept(ModItems.RAINBOW_LEGGINGS);
                        output.accept(ModItems.RAINBOW_BOOTS);

                        // Elytras
                        output.accept(ModItems.RAINBOW_ELYTRA);
                        output.accept(ModItems.TRANS_ELYTRA);
                        output.accept(ModItems.NONBINARY_ELYTRA);
                        output.accept(ModItems.BISEXUAL_ELYTRA);
                        output.accept(ModItems.PANSEXUAL_ELYTRA);
                        output.accept(ModItems.AROMANTIC_ELYTRA);
                        output.accept(ModItems.DEMISEXUAL_ELYTRA);
                        output.accept(ModItems.AGENDER_ELYTRA);
                        output.accept(ModItems.PROGRESS_PRIDE_ELYTRA);
                        output.accept(ModItems.ASEXUAL_ELYTRA);
                        output.accept(ModItems.GENDERFLUID_ELYTRA);
                        output.accept(ModItems.LESBIAN_ELYTRA);
                        output.accept(ModItems.DEMIBOY_ELYTRA);
                        output.accept(ModItems.DEMIGIRL_ELYTRA);
                        output.accept(ModItems.GENDERQUEER_ELYTRA);
                        output.accept(ModItems.POLYSEXUAL_ELYTRA);

                        // Spawn egg
                        output.accept(ModItems.RAINBOW_SHEEP_SPAWN_EGG);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
