package net.wolren.land.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootTable;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAINBOW_WOOL);
        addDrop(ModBlocks.TRANS_WOOL);
        addDrop(ModBlocks.NONBINARY_WOOL);
        addDrop(ModBlocks.BISEXUAL_WOOL);
        addDrop(ModBlocks.PANSEXUAL_WOOL);
        addDrop(ModBlocks.AROMANTIC_WOOL);
        addDrop(ModBlocks.DEMISEXUAL_WOOL);
        addDrop(ModBlocks.AGENDER_WOOL);
        addDrop(ModBlocks.PROGRESS_PRIDE_WOOL);
        addDrop(ModBlocks.ASEXUAL_WOOL);
        addDrop(ModBlocks.GENDERFLUID_WOOL);
        addDrop(ModBlocks.LESBIAN_WOOL);
        addDrop(ModBlocks.DEMIBOY_WOOL);
        addDrop(ModBlocks.DEMIGIRL_WOOL);
        addDrop(ModBlocks.GENDERQUEER_WOOL);
        addDrop(ModBlocks.POLYSEXUAL_WOOL);

        addDrop(ModBlocks.RAINBOW_CARPET);
        addDrop(ModBlocks.TRANS_CARPET);
        addDrop(ModBlocks.NONBINARY_CARPET);
        addDrop(ModBlocks.BISEXUAL_WOOL);
        addDrop(ModBlocks.PANSEXUAL_CARPET);
        addDrop(ModBlocks.AROMANTIC_CARPET);
        addDrop(ModBlocks.DEMISEXUAL_CARPET);
        addDrop(ModBlocks.AGENDER_CARPET);
        addDrop(ModBlocks.PROGRESS_PRIDE_CARPET);
        addDrop(ModBlocks.ASEXUAL_CARPET);
        addDrop(ModBlocks.GENDERFLUID_CARPET);
        addDrop(ModBlocks.LESBIAN_CARPET);
        addDrop(ModBlocks.DEMIBOY_CARPET);
        addDrop(ModBlocks.DEMIGIRL_CARPET);
        addDrop(ModBlocks.GENDERQUEER_CARPET);
        addDrop(ModBlocks.POLYSEXUAL_CARPET);

        addDropWithSilkTouch(ModBlocks.RAINBOW_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.RAINBOW_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.TRANS_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.TRANS_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.NONBINARY_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.NONBINARY_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.BISEXUAL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.BISEXUAL_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.PANSEXUAL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.AROMANTIC_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.AROMANTIC_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.DEMISEXUAL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.AGENDER_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.AGENDER_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.ASEXUAL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.ASEXUAL_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.GENDERFLUID_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.LESBIAN_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.LESBIAN_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.DEMIBOY_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.DEMIBOY_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.DEMIGIRL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.GENDERQUEER_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE);
        addDropWithSilkTouch(ModBlocks.POLYSEXUAL_STAINED_GLASS);
        addDropWithSilkTouch(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE);

        addDrop(ModBlocks.RAINBOW_PLANKS);
        addDrop(ModBlocks.RAINBOW_STAIRS);
        addDrop(ModBlocks.RAINBOW_SLAB);
        addDrop(ModBlocks.RAINBOW_FENCE);
        addDrop(ModBlocks.RAINBOW_FENCE_GATE);
        addDrop(ModBlocks.RAINBOW_BUTTON);
        addDrop(ModBlocks.RAINBOW_PRESSURE_PLATE);
        addDrop(ModBlocks.RAINBOW_DOOR);
        addDrop(ModBlocks.RAINBOW_TRAPDOOR);
        addDrop(ModBlocks.RAINBOW_STANDING_SIGN);
        addDrop(ModBlocks.RAINBOW_WALL_SIGN);
        addDrop(ModBlocks.RAINBOW_HANGING_SIGN);
        addDrop(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        addDrop(ModBlocks.RAINBOW_BRICK_STAIRS);
        addDrop(ModBlocks.RAINBOW_BRICK_SLAB);
        addDrop(ModBlocks.RAINBOW_BRICK_WALL);

        addDrop(ModBlocks.RAINBOW_CONCRETE);
        addDrop(ModBlocks.RAINBOW_CONCRETE_POWDER);
        addDrop(ModBlocks.RAINBOW_BRICKS);
        addDrop(ModBlocks.RAINBOW_TERRACOTTA);
        addDrop(ModBlocks.RAINBOW_CRAFTING);
    }
}
