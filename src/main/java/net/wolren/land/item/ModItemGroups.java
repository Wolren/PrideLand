package net.wolren.land.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
import net.wolren.land.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup PRIDE_LAND_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Land.MOD_ID, "pride_land"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.pride_land_group")).icon(() ->
                    new ItemStack(ModBlocks.RAINBOW_WOOL)).entries((displayContext, entries) -> {
                entries.add(ModBlocks.RAINBOW_CRAFTING);

                entries.add(ModBlocks.RAINBOW_WOOL);
                entries.add(ModBlocks.AGENDER_WOOL);
                entries.add(ModBlocks.AROMANTIC_WOOL);
                entries.add(ModBlocks.ASEXUAL_WOOL);
                entries.add(ModBlocks.BISEXUAL_WOOL);
                entries.add(ModBlocks.DEMIBOY_WOOL);
                entries.add(ModBlocks.DEMIGIRL_WOOL);
                entries.add(ModBlocks.DEMISEXUAL_WOOL);
                entries.add(ModBlocks.GENDERFLUID_WOOL);
                entries.add(ModBlocks.GENDERQUEER_WOOL);
                entries.add(ModBlocks.LESBIAN_WOOL);
                entries.add(ModBlocks.NONBINARY_WOOL);
                entries.add(ModBlocks.PANSEXUAL_WOOL);
                entries.add(ModBlocks.POLYSEXUAL_WOOL);
                entries.add(ModBlocks.PROGRESS_PRIDE_WOOL);
                entries.add(ModBlocks.TRANS_WOOL);

                entries.add(ModBlocks.RAINBOW_CARPET);
                entries.add(ModBlocks.AGENDER_CARPET);
                entries.add(ModBlocks.AROMANTIC_CARPET);
                entries.add(ModBlocks.ASEXUAL_CARPET);
                entries.add(ModBlocks.BISEXUAL_CARPET);
                entries.add(ModBlocks.DEMIBOY_CARPET);
                entries.add(ModBlocks.DEMIGIRL_CARPET);
                entries.add(ModBlocks.DEMISEXUAL_CARPET);
                entries.add(ModBlocks.GENDERFLUID_CARPET);
                entries.add(ModBlocks.GENDERQUEER_CARPET);
                entries.add(ModBlocks.LESBIAN_CARPET);
                entries.add(ModBlocks.NONBINARY_CARPET);
                entries.add(ModBlocks.PANSEXUAL_CARPET);
                entries.add(ModBlocks.POLYSEXUAL_CARPET);
                entries.add(ModBlocks.PROGRESS_PRIDE_CARPET);
                entries.add(ModBlocks.TRANS_CARPET);

                entries.add(ModBlocks.RAINBOW_BED);
                entries.add(ModBlocks.AGENDER_BED);
                entries.add(ModBlocks.AROMANTIC_BED);
                entries.add(ModBlocks.ASEXUAL_BED);
                entries.add(ModBlocks.BISEXUAL_BED);
                entries.add(ModBlocks.DEMIBOY_BED);
                entries.add(ModBlocks.DEMIGIRL_BED);
                entries.add(ModBlocks.DEMISEXUAL_BED);
                entries.add(ModBlocks.GENDERFLUID_BED);
                entries.add(ModBlocks.GENDERQUEER_BED);
                entries.add(ModBlocks.LESBIAN_BED);
                entries.add(ModBlocks.NONBINARY_BED);
                entries.add(ModBlocks.PANSEXUAL_BED);
                entries.add(ModBlocks.POLYSEXUAL_BED);
                entries.add(ModBlocks.PROGRESS_PRIDE_BED);
                entries.add(ModBlocks.TRANS_BED);

                entries.add(ModBlocks.RAINBOW_STAINED_GLASS);
                entries.add(ModBlocks.AGENDER_STAINED_GLASS);
                entries.add(ModBlocks.AROMANTIC_STAINED_GLASS);
                entries.add(ModBlocks.ASEXUAL_STAINED_GLASS);
                entries.add(ModBlocks.BISEXUAL_STAINED_GLASS);
                entries.add(ModBlocks.DEMIBOY_STAINED_GLASS);
                entries.add(ModBlocks.DEMIGIRL_STAINED_GLASS);
                entries.add(ModBlocks.DEMISEXUAL_STAINED_GLASS);
                entries.add(ModBlocks.GENDERFLUID_STAINED_GLASS);
                entries.add(ModBlocks.GENDERQUEER_STAINED_GLASS);
                entries.add(ModBlocks.LESBIAN_STAINED_GLASS);
                entries.add(ModBlocks.NONBINARY_STAINED_GLASS);
                entries.add(ModBlocks.PANSEXUAL_STAINED_GLASS);
                entries.add(ModBlocks.POLYSEXUAL_STAINED_GLASS);
                entries.add(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS);
                entries.add(ModBlocks.TRANS_STAINED_GLASS);

                entries.add(ModBlocks.RAINBOW_STAINED_GLASS_PANE);
                entries.add(ModBlocks.AGENDER_STAINED_GLASS_PANE);
                entries.add(ModBlocks.AROMANTIC_STAINED_GLASS_PANE);
                entries.add(ModBlocks.ASEXUAL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.BISEXUAL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.DEMIBOY_STAINED_GLASS_PANE);
                entries.add(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE);
                entries.add(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE);
                entries.add(ModBlocks.LESBIAN_STAINED_GLASS_PANE);
                entries.add(ModBlocks.NONBINARY_STAINED_GLASS_PANE);
                entries.add(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE);
                entries.add(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE);
                entries.add(ModBlocks.TRANS_STAINED_GLASS_PANE);
                
                entries.add(ModBlocks.RAINBOW_PLANKS);
                entries.add(ModBlocks.RAINBOW_STAIRS);
                entries.add(ModBlocks.RAINBOW_SLAB);
                entries.add(ModBlocks.RAINBOW_FENCE);
                entries.add(ModBlocks.RAINBOW_FENCE_GATE);
                entries.add(ModBlocks.RAINBOW_BUTTON);
                entries.add(ModBlocks.RAINBOW_PRESSURE_PLATE);
                entries.add(ModBlocks.RAINBOW_DOOR);
                entries.add(ModBlocks.RAINBOW_TRAPDOOR);

                entries.add(ModItems.RAINBOW_SIGN);
                entries.add(ModItems.RAINBOW_HANGING_SIGN);

                entries.add(ModBlocks.RAINBOW_CONCRETE_POWDER);
                entries.add(ModBlocks.RAINBOW_CONCRETE);
                entries.add(ModBlocks.RAINBOW_TERRACOTTA);
                entries.add(ModBlocks.RAINBOW_BRICKS);
                entries.add(ModBlocks.RAINBOW_BRICK_STAIRS);
                entries.add(ModBlocks.RAINBOW_BRICK_SLAB);
                entries.add(ModBlocks.RAINBOW_BRICK_WALL);

                entries.add(ModBlocks.RAINBOW_CANDLE);

                entries.add(ModItems.RAINBOW_SWORD);
                entries.add(ModItems.RAINBOW_SHOVEL);
                entries.add(ModItems.RAINBOW_PICKAXE);
                entries.add(ModItems.RAINBOW_AXE);
                entries.add(ModItems.RAINBOW_HOE);

                entries.add(ModItems.RAINBOW_DYE);

                entries.add(ModItems.RAINBOW_HELMET);
                entries.add(ModItems.RAINBOW_CHESTPLATE);
                entries.add(ModItems.RAINBOW_LEGGINGS);
                entries.add(ModItems.RAINBOW_BOOTS);

                entries.add(ModItems.RAINBOW_ELYTRA);
                entries.add(ModItems.AGENDER_ELYTRA);
                entries.add(ModItems.AROMANTIC_ELYTRA);
                entries.add(ModItems.ASEXUAL_ELYTRA);
                entries.add(ModItems.BISEXUAL_ELYTRA);
                entries.add(ModItems.DEMIBOY_ELYTRA);
                entries.add(ModItems.DEMIGIRL_ELYTRA);
                entries.add(ModItems.DEMISEXUAL_ELYTRA);
                entries.add(ModItems.GENDERFLUID_ELYTRA);
                entries.add(ModItems.GENDERQUEER_ELYTRA);
                entries.add(ModItems.LESBIAN_ELYTRA);
                entries.add(ModItems.NONBINARY_ELYTRA);
                entries.add(ModItems.PANSEXUAL_ELYTRA);
                entries.add(ModItems.POLYSEXUAL_ELYTRA);
                entries.add(ModItems.PROGRESS_PRIDE_ELYTRA);
                entries.add(ModItems.TRANS_ELYTRA);

                entries.add(ModItems.RAINBOW_BOAT);
                entries.add(ModItems.RAINBOW_CHEST_BOAT);

                entries.add(ModItems.RAINBOW_SHEEP_SPAWN_EGG);
            }).build());

    public static void registerItemGroups() {
        Land.LOGGER.info("Registering Item Groups for " + Land.MOD_ID);
    }
}
