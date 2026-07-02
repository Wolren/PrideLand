package net.wolren.land.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.CANDLES)
                .add(ModBlocks.RAINBOW_CANDLE);




        getOrCreateTagBuilder(ModTags.Blocks.GLASS_BLOCKS)
                .add(ModBlocks.RAINBOW_STAINED_GLASS)
                .add(ModBlocks.TRANS_STAINED_GLASS)
                .add(ModBlocks.NONBINARY_STAINED_GLASS)
                .add(ModBlocks.BISEXUAL_STAINED_GLASS)
                .add(ModBlocks.PANSEXUAL_STAINED_GLASS)
                .add(ModBlocks.AROMANTIC_STAINED_GLASS)
                .add(ModBlocks.DEMISEXUAL_STAINED_GLASS)
                .add(ModBlocks.AGENDER_STAINED_GLASS)
                .add(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS)
                .add(ModBlocks.ASEXUAL_STAINED_GLASS)
                .add(ModBlocks.GENDERFLUID_STAINED_GLASS)
                .add(ModBlocks.LESBIAN_STAINED_GLASS)
                .add(ModBlocks.DEMIBOY_STAINED_GLASS)
                .add(ModBlocks.DEMIGIRL_STAINED_GLASS)
                .add(ModBlocks.GENDERQUEER_STAINED_GLASS)
                .add(ModBlocks.POLYSEXUAL_STAINED_GLASS);

        getOrCreateTagBuilder(BlockTags.IMPERMEABLE)
                .add(ModBlocks.RAINBOW_STAINED_GLASS)
                .add(ModBlocks.TRANS_STAINED_GLASS)
                .add(ModBlocks.NONBINARY_STAINED_GLASS)
                .add(ModBlocks.BISEXUAL_STAINED_GLASS)
                .add(ModBlocks.PANSEXUAL_STAINED_GLASS)
                .add(ModBlocks.AROMANTIC_STAINED_GLASS)
                .add(ModBlocks.DEMISEXUAL_STAINED_GLASS)
                .add(ModBlocks.AGENDER_STAINED_GLASS)
                .add(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS)
                .add(ModBlocks.ASEXUAL_STAINED_GLASS)
                .add(ModBlocks.GENDERFLUID_STAINED_GLASS)
                .add(ModBlocks.LESBIAN_STAINED_GLASS)
                .add(ModBlocks.DEMIBOY_STAINED_GLASS)
                .add(ModBlocks.DEMIGIRL_STAINED_GLASS)
                .add(ModBlocks.GENDERQUEER_STAINED_GLASS)
                .add(ModBlocks.POLYSEXUAL_STAINED_GLASS);




        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAINBOW_CRAFTING)
                .add(ModBlocks.RAINBOW_BRICKS)
                .add(ModBlocks.RAINBOW_BRICK_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_SLAB)
                .add(ModBlocks.RAINBOW_BRICK_WALL)
                .add(ModBlocks.RAINBOW_CONCRETE)
                .add(ModBlocks.RAINBOW_TERRACOTTA);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.RAINBOW_PLANKS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_SLAB)
                .add(ModBlocks.RAINBOW_FENCE)
                .add(ModBlocks.RAINBOW_FENCE_GATE)
                .add(ModBlocks.RAINBOW_BUTTON)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE)
                .add(ModBlocks.RAINBOW_DOOR)
                .add(ModBlocks.RAINBOW_TRAPDOOR)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_STANDING_SIGN)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.RAINBOW_CONCRETE_POWDER);




        getOrCreateTagBuilder(ModTags.Blocks.WOOLS)
                .add(ModBlocks.RAINBOW_WOOL)
                .add(ModBlocks.TRANS_WOOL)
                .add(ModBlocks.NONBINARY_WOOL)
                .add(ModBlocks.BISEXUAL_WOOL)
                .add(ModBlocks.PANSEXUAL_WOOL)
                .add(ModBlocks.AROMANTIC_WOOL)
                .add(ModBlocks.DEMISEXUAL_WOOL)
                .add(ModBlocks.AGENDER_WOOL)
                .add(ModBlocks.PROGRESS_PRIDE_WOOL)
                .add(ModBlocks.ASEXUAL_WOOL)
                .add(ModBlocks.GENDERFLUID_WOOL)
                .add(ModBlocks.LESBIAN_WOOL)
                .add(ModBlocks.DEMIBOY_WOOL)
                .add(ModBlocks.DEMIGIRL_WOOL)
                .add(ModBlocks.GENDERQUEER_WOOL)
                .add(ModBlocks.POLYSEXUAL_WOOL);

        getOrCreateTagBuilder(BlockTags.WOOL)
                .add(ModBlocks.RAINBOW_WOOL)
                .add(ModBlocks.TRANS_WOOL)
                .add(ModBlocks.NONBINARY_WOOL)
                .add(ModBlocks.BISEXUAL_WOOL)
                .add(ModBlocks.PANSEXUAL_WOOL)
                .add(ModBlocks.AROMANTIC_WOOL)
                .add(ModBlocks.DEMISEXUAL_WOOL)
                .add(ModBlocks.AGENDER_WOOL)
                .add(ModBlocks.PROGRESS_PRIDE_WOOL)
                .add(ModBlocks.ASEXUAL_WOOL)
                .add(ModBlocks.GENDERFLUID_WOOL)
                .add(ModBlocks.LESBIAN_WOOL)
                .add(ModBlocks.DEMIBOY_WOOL)
                .add(ModBlocks.DEMIGIRL_WOOL)
                .add(ModBlocks.GENDERQUEER_WOOL)
                .add(ModBlocks.POLYSEXUAL_WOOL);

        getOrCreateTagBuilder(ModTags.Blocks.CARPETS)
                .add(ModBlocks.RAINBOW_CARPET)
                .add(ModBlocks.TRANS_CARPET)
                .add(ModBlocks.NONBINARY_CARPET)
                .add(ModBlocks.BISEXUAL_CARPET)
                .add(ModBlocks.PANSEXUAL_CARPET)
                .add(ModBlocks.AROMANTIC_CARPET)
                .add(ModBlocks.DEMISEXUAL_CARPET)
                .add(ModBlocks.AGENDER_CARPET)
                .add(ModBlocks.PROGRESS_PRIDE_CARPET)
                .add(ModBlocks.ASEXUAL_CARPET)
                .add(ModBlocks.GENDERFLUID_CARPET)
                .add(ModBlocks.LESBIAN_CARPET)
                .add(ModBlocks.DEMIBOY_CARPET)
                .add(ModBlocks.DEMIGIRL_CARPET)
                .add(ModBlocks.GENDERQUEER_CARPET)
                .add(ModBlocks.POLYSEXUAL_CARPET);

        getOrCreateTagBuilder(BlockTags.WOOL_CARPETS)
                .add(ModBlocks.RAINBOW_CARPET)
                .add(ModBlocks.TRANS_CARPET)
                .add(ModBlocks.NONBINARY_CARPET)
                .add(ModBlocks.BISEXUAL_CARPET)
                .add(ModBlocks.PANSEXUAL_CARPET)
                .add(ModBlocks.AROMANTIC_CARPET)
                .add(ModBlocks.DEMISEXUAL_CARPET)
                .add(ModBlocks.AGENDER_CARPET)
                .add(ModBlocks.PROGRESS_PRIDE_CARPET)
                .add(ModBlocks.ASEXUAL_CARPET)
                .add(ModBlocks.GENDERFLUID_CARPET)
                .add(ModBlocks.LESBIAN_CARPET)
                .add(ModBlocks.DEMIBOY_CARPET)
                .add(ModBlocks.DEMIGIRL_CARPET)
                .add(ModBlocks.GENDERQUEER_CARPET)
                .add(ModBlocks.POLYSEXUAL_CARPET);





        getOrCreateTagBuilder(ModTags.Blocks.BED_BLOCKS)
                .add(ModBlocks.RAINBOW_BED)
                .add(ModBlocks.TRANS_BED)
                .add(ModBlocks.NONBINARY_BED)
                .add(ModBlocks.BISEXUAL_BED)
                .add(ModBlocks.PANSEXUAL_BED)
                .add(ModBlocks.AROMANTIC_BED)
                .add(ModBlocks.DEMISEXUAL_BED)
                .add(ModBlocks.AGENDER_BED)
                .add(ModBlocks.PROGRESS_PRIDE_BED)
                .add(ModBlocks.ASEXUAL_BED)
                .add(ModBlocks.GENDERFLUID_BED)
                .add(ModBlocks.LESBIAN_BED)
                .add(ModBlocks.DEMIBOY_BED)
                .add(ModBlocks.DEMIGIRL_BED)
                .add(ModBlocks.GENDERQUEER_BED)
                .add(ModBlocks.POLYSEXUAL_BED);

        getOrCreateTagBuilder(BlockTags.BEDS)
                .add(ModBlocks.RAINBOW_BED)
                .add(ModBlocks.TRANS_BED)
                .add(ModBlocks.NONBINARY_BED)
                .add(ModBlocks.BISEXUAL_BED)
                .add(ModBlocks.PANSEXUAL_BED)
                .add(ModBlocks.AROMANTIC_BED)
                .add(ModBlocks.DEMISEXUAL_BED)
                .add(ModBlocks.AGENDER_BED)
                .add(ModBlocks.PROGRESS_PRIDE_BED)
                .add(ModBlocks.ASEXUAL_BED)
                .add(ModBlocks.GENDERFLUID_BED)
                .add(ModBlocks.LESBIAN_BED)
                .add(ModBlocks.DEMIBOY_BED)
                .add(ModBlocks.DEMIGIRL_BED)
                .add(ModBlocks.GENDERQUEER_BED)
                .add(ModBlocks.POLYSEXUAL_BED);




        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.RAINBOW_PLANKS);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.RAINBOW_FENCE);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.RAINBOW_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RAINBOW_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.RAINBOW_STAIRS);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.RAINBOW_STAIRS);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.RAINBOW_BUTTON);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.RAINBOW_BUTTON);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.RAINBOW_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.RAINBOW_DOOR);

        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.RAINBOW_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.RAINBOW_TRAPDOOR);




        getOrCreateTagBuilder(BlockTags.SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_STANDING_SIGN);

        getOrCreateTagBuilder(BlockTags.ALL_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_STANDING_SIGN)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN);

        getOrCreateTagBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.RAINBOW_STANDING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);




        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.RAINBOW_BRICK_WALL);

        getOrCreateTagBuilder(BlockTags.TERRACOTTA)
                .add(ModBlocks.RAINBOW_TERRACOTTA);
    }
}