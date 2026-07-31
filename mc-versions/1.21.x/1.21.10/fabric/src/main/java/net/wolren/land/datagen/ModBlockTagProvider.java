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
        valueLookupBuilder(BlockTags.CANDLES)
                .add(ModBlocks.RAINBOW_CANDLE);




        valueLookupBuilder(ModTags.Blocks.GLASS_BLOCKS)
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

        valueLookupBuilder(BlockTags.IMPERMEABLE)
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




        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAINBOW_CRAFTING)
                .add(ModBlocks.RAINBOW_BRICKS)
                .add(ModBlocks.RAINBOW_BRICK_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_SLAB)
                .add(ModBlocks.RAINBOW_BRICK_WALL)
                .add(ModBlocks.RAINBOW_CONCRETE)
                .add(ModBlocks.RAINBOW_TERRACOTTA);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.RAINBOW_PLANKS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_SLAB)
                .add(ModBlocks.RAINBOW_FENCE)
                .add(ModBlocks.RAINBOW_FENCE_GATE)
                .add(ModBlocks.RAINBOW_BUTTON)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE)
                .add(ModBlocks.RAINBOW_DOOR)
                .add(ModBlocks.RAINBOW_TRAPDOOR)
                .add(ModBlocks.RAINBOW_STANDING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.RAINBOW_CONCRETE_POWDER);




        valueLookupBuilder(ModTags.Blocks.WOOLS)
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

        valueLookupBuilder(BlockTags.WOOL)
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

        valueLookupBuilder(ModTags.Blocks.CARPETS)
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

        valueLookupBuilder(BlockTags.WOOL_CARPETS)
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





        valueLookupBuilder(ModTags.Blocks.BED_BLOCKS)
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

        valueLookupBuilder(BlockTags.BEDS)
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




        valueLookupBuilder(BlockTags.PLANKS)
                .add(ModBlocks.RAINBOW_PLANKS);

        valueLookupBuilder(BlockTags.FENCES)
                .add(ModBlocks.RAINBOW_FENCE);

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.RAINBOW_FENCE);

        valueLookupBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.RAINBOW_FENCE_GATE);

        valueLookupBuilder(BlockTags.STAIRS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_STAIRS);

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.RAINBOW_STAIRS);

        valueLookupBuilder(BlockTags.SLABS)
                .add(ModBlocks.RAINBOW_STAIRS)
                .add(ModBlocks.RAINBOW_BRICK_SLAB);

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.RAINBOW_STAIRS);

        valueLookupBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.RAINBOW_BUTTON);

        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.RAINBOW_BUTTON);

        valueLookupBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.WALL_POST_OVERRIDE)
                .add(ModBlocks.RAINBOW_PRESSURE_PLATE);

        valueLookupBuilder(BlockTags.DOORS)
                .add(ModBlocks.RAINBOW_DOOR);

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.RAINBOW_DOOR);

        valueLookupBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.RAINBOW_TRAPDOOR);

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.RAINBOW_TRAPDOOR);




        valueLookupBuilder(BlockTags.SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_STANDING_SIGN);

        valueLookupBuilder(BlockTags.ALL_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN)
                .add(ModBlocks.RAINBOW_STANDING_SIGN)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        valueLookupBuilder(BlockTags.WALL_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_SIGN);

        valueLookupBuilder(BlockTags.ALL_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_HANGING_SIGN)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_HANGING_SIGN);

        valueLookupBuilder(BlockTags.STANDING_SIGNS)
                .add(ModBlocks.RAINBOW_STANDING_SIGN);

        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
                .add(ModBlocks.RAINBOW_WALL_HANGING_SIGN);




        valueLookupBuilder(BlockTags.WALLS)
                .add(ModBlocks.RAINBOW_BRICK_WALL);

        valueLookupBuilder(BlockTags.TERRACOTTA)
                .add(ModBlocks.RAINBOW_TERRACOTTA);
    }
}