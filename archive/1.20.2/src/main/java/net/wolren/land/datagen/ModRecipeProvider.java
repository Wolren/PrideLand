package net.wolren.land.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAINBOW_CRAFTING, 1)
                .pattern("SS")
                .pattern("WW")
                .pattern("TT")
                .input('S', Items.STRING)
                .input('W', ItemTags.PLANKS)
                .input('T', Blocks.STONE)
                .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_CRAFTING)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.RAINBOW_DYE, 2)
                .input(Items.RED_DYE)
                .input(Items.YELLOW_DYE)
                .input(Items.WHITE_DYE)
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAINBOW_DYE)));




        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_CONCRETE_POWDER, 8)
                .input(Blocks.GRAVEL)
                .input(Blocks.GRAVEL)
                .input(Blocks.GRAVEL)
                .input(Blocks.GRAVEL)
                .input(Blocks.SAND)
                .input(Blocks.SAND)
                .input(Blocks.SAND)
                .input(Blocks.SAND)
                .input(ModItems.RAINBOW_DYE)
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .criterion(hasItem(Blocks.SAND), conditionsFromItem(Blocks.SAND))
                .criterion(hasItem(Blocks.GRAVEL), conditionsFromItem(Blocks.GRAVEL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_CONCRETE_POWDER)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAINBOW_TERRACOTTA, 8)
                .pattern("TTT")
                .pattern("TDT")
                .pattern("TTT")
                .input('D', ModItems.RAINBOW_DYE)
                .input('T', Blocks.TERRACOTTA)
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .criterion(hasItem(Blocks.TERRACOTTA), conditionsFromItem(Blocks.TERRACOTTA))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_TERRACOTTA)));




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAINBOW_STAINED_GLASS, 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .input('D', ModItems.RAINBOW_DYE)
                .input('G', Blocks.GLASS)
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .criterion(hasItem(Blocks.GLASS), conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_STAINED_GLASS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAINBOW_STAINED_GLASS_PANE, 8)
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .input('D', ModItems.RAINBOW_DYE)
                .input('G', Blocks.GLASS_PANE)
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .criterion(hasItem(Blocks.GLASS_PANE), conditionsFromItem(Blocks.GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAINBOW_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.RAINBOW_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.RAINBOW_STAINED_GLASS), conditionsFromItem(ModBlocks.RAINBOW_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_STAINED_GLASS_PANE)) + "2");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TRANS_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.TRANS_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.TRANS_STAINED_GLASS), conditionsFromItem(ModBlocks.TRANS_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TRANS_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NONBINARY_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.NONBINARY_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.NONBINARY_STAINED_GLASS), conditionsFromItem(ModBlocks.NONBINARY_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.NONBINARY_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BISEXUAL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.BISEXUAL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.BISEXUAL_STAINED_GLASS), conditionsFromItem(ModBlocks.BISEXUAL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISEXUAL_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PANSEXUAL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.PANSEXUAL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.PANSEXUAL_STAINED_GLASS), conditionsFromItem(ModBlocks.PANSEXUAL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AROMANTIC_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.AROMANTIC_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.AROMANTIC_STAINED_GLASS), conditionsFromItem(ModBlocks.AROMANTIC_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AROMANTIC_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.DEMISEXUAL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.DEMISEXUAL_STAINED_GLASS), conditionsFromItem(ModBlocks.DEMISEXUAL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.AGENDER_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.AGENDER_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.AGENDER_STAINED_GLASS), conditionsFromItem(ModBlocks.AGENDER_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AGENDER_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.PROGRESS_PRIDE_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS), conditionsFromItem(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ASEXUAL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.ASEXUAL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.ASEXUAL_STAINED_GLASS), conditionsFromItem(ModBlocks.ASEXUAL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASEXUAL_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GENDERFLUID_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.GENDERFLUID_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.GENDERFLUID_STAINED_GLASS), conditionsFromItem(ModBlocks.GENDERFLUID_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LESBIAN_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.LESBIAN_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.LESBIAN_STAINED_GLASS), conditionsFromItem(ModBlocks.LESBIAN_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LESBIAN_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEMIBOY_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.DEMIBOY_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.DEMIBOY_STAINED_GLASS), conditionsFromItem(ModBlocks.DEMIBOY_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIBOY_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.DEMIGIRL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.DEMIGIRL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.DEMIGIRL_STAINED_GLASS), conditionsFromItem(ModBlocks.DEMIGIRL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.GENDERQUEER_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.GENDERQUEER_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.GENDERQUEER_STAINED_GLASS), conditionsFromItem(ModBlocks.GENDERQUEER_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE, 16)
                .pattern("GGG")
                .pattern("GGG")
                .input('G', ModBlocks.POLYSEXUAL_STAINED_GLASS)
                .criterion(hasItem(ModBlocks.POLYSEXUAL_STAINED_GLASS), conditionsFromItem(ModBlocks.POLYSEXUAL_STAINED_GLASS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE)));




        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_WOOL, 1)
                .input(Blocks.WHITE_WOOL)
                .input(ModItems.RAINBOW_DYE)
                .criterion(hasItem(Blocks.WHITE_WOOL), conditionsFromItem(Blocks.WHITE_WOOL))
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_WOOL) + "2"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_CARPET, 1)
                .input(Blocks.WHITE_CARPET)
                .input(ModItems.RAINBOW_DYE)
                .criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_CARPET) + "2"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_BED, 1)
                .input(Blocks.WHITE_BED)
                .input(ModItems.RAINBOW_DYE)
                .criterion(hasItem(Blocks.WHITE_BED), conditionsFromItem(Blocks.WHITE_BED))
                .criterion(hasItem(ModItems.RAINBOW_DYE), conditionsFromItem(ModItems.RAINBOW_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BED) + "2"));

        Ingredient whiteDye = Ingredient.ofItems(Items.WHITE_DYE);

        Ingredient customWool = Ingredient.ofItems(
                ModBlocks.RAINBOW_WOOL,
                ModBlocks.TRANS_WOOL,
                ModBlocks.NONBINARY_WOOL,
                ModBlocks.BISEXUAL_WOOL,
                ModBlocks.PANSEXUAL_WOOL,
                ModBlocks.AROMANTIC_WOOL,
                ModBlocks.DEMISEXUAL_WOOL,
                ModBlocks.AGENDER_WOOL,
                ModBlocks.PROGRESS_PRIDE_WOOL,
                ModBlocks.ASEXUAL_WOOL,
                ModBlocks.GENDERFLUID_WOOL,
                ModBlocks.LESBIAN_WOOL,
                ModBlocks.DEMIBOY_WOOL,
                ModBlocks.DEMIGIRL_WOOL,
                ModBlocks.GENDERQUEER_WOOL,
                ModBlocks.POLYSEXUAL_WOOL
        );

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.WHITE_WOOL)
                .input(whiteDye)
                .input(customWool)
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks.WHITE_WOOL)));

        Ingredient customCarpet = Ingredient.ofItems(
                ModBlocks.RAINBOW_CARPET,
                ModBlocks.TRANS_CARPET,
                ModBlocks.NONBINARY_CARPET,
                ModBlocks.BISEXUAL_CARPET,
                ModBlocks.PANSEXUAL_CARPET,
                ModBlocks.AROMANTIC_CARPET,
                ModBlocks.DEMISEXUAL_CARPET,
                ModBlocks.AGENDER_CARPET,
                ModBlocks.PROGRESS_PRIDE_CARPET,
                ModBlocks.ASEXUAL_CARPET,
                ModBlocks.GENDERFLUID_CARPET,
                ModBlocks.LESBIAN_CARPET,
                ModBlocks.DEMIBOY_CARPET,
                ModBlocks.DEMIGIRL_CARPET,
                ModBlocks.GENDERQUEER_CARPET,
                ModBlocks.POLYSEXUAL_CARPET
        );

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Blocks.WHITE_CARPET)
                .input(customCarpet)
                .input(whiteDye)
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Blocks.WHITE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.RAINBOW_WOOL)
                .criterion(hasItem(ModBlocks.RAINBOW_WOOL), conditionsFromItem(ModBlocks.RAINBOW_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_WOOL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TRANS_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.TRANS_WOOL)
                .criterion(hasItem(ModBlocks.TRANS_WOOL), conditionsFromItem(ModBlocks.TRANS_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TRANS_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.NONBINARY_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.NONBINARY_WOOL)
                .criterion(hasItem(ModBlocks.NONBINARY_WOOL), conditionsFromItem(ModBlocks.NONBINARY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.NONBINARY_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BISEXUAL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.BISEXUAL_WOOL)
                .criterion(hasItem(ModBlocks.BISEXUAL_WOOL), conditionsFromItem(ModBlocks.BISEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISEXUAL_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PANSEXUAL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.PANSEXUAL_WOOL)
                .criterion(hasItem(ModBlocks.PANSEXUAL_WOOL), conditionsFromItem(ModBlocks.PANSEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PANSEXUAL_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AROMANTIC_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.AROMANTIC_WOOL)
                .criterion(hasItem(ModBlocks.AROMANTIC_WOOL), conditionsFromItem(ModBlocks.AROMANTIC_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AROMANTIC_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMISEXUAL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.DEMISEXUAL_WOOL)
                .criterion(hasItem(ModBlocks.DEMISEXUAL_WOOL), conditionsFromItem(ModBlocks.DEMISEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMISEXUAL_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AGENDER_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.AGENDER_WOOL)
                .criterion(hasItem(ModBlocks.AGENDER_WOOL), conditionsFromItem(ModBlocks.AGENDER_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AGENDER_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PROGRESS_PRIDE_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.PROGRESS_PRIDE_WOOL)
                .criterion(hasItem(ModBlocks.PROGRESS_PRIDE_WOOL), conditionsFromItem(ModBlocks.PROGRESS_PRIDE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PROGRESS_PRIDE_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.ASEXUAL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.ASEXUAL_WOOL)
                .criterion(hasItem(ModBlocks.ASEXUAL_WOOL), conditionsFromItem(ModBlocks.ASEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASEXUAL_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GENDERFLUID_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.GENDERFLUID_WOOL)
                .criterion(hasItem(ModBlocks.GENDERFLUID_WOOL), conditionsFromItem(ModBlocks.GENDERFLUID_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERFLUID_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LESBIAN_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.LESBIAN_WOOL)
                .criterion(hasItem(ModBlocks.LESBIAN_WOOL), conditionsFromItem(ModBlocks.LESBIAN_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LESBIAN_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMIBOY_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.DEMIBOY_WOOL)
                .criterion(hasItem(ModBlocks.DEMIBOY_WOOL), conditionsFromItem(ModBlocks.DEMIBOY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIBOY_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMIGIRL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.DEMIGIRL_WOOL)
                .criterion(hasItem(ModBlocks.DEMIGIRL_WOOL), conditionsFromItem(ModBlocks.DEMIGIRL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIGIRL_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GENDERQUEER_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.GENDERQUEER_WOOL)
                .criterion(hasItem(ModBlocks.GENDERQUEER_WOOL), conditionsFromItem(ModBlocks.GENDERQUEER_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERQUEER_CARPET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.POLYSEXUAL_CARPET, 3)
                .pattern("XX")
                .input('X', ModBlocks.POLYSEXUAL_WOOL)
                .criterion(hasItem(ModBlocks.POLYSEXUAL_WOOL), conditionsFromItem(ModBlocks.POLYSEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLYSEXUAL_CARPET)));




        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.RAINBOW_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_WOOL), conditionsFromItem(ModBlocks.RAINBOW_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.TRANS_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.TRANS_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.TRANS_WOOL), conditionsFromItem(ModBlocks.TRANS_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.TRANS_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.NONBINARY_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.NONBINARY_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.NONBINARY_WOOL), conditionsFromItem(ModBlocks.NONBINARY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.NONBINARY_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BISEXUAL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.BISEXUAL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.BISEXUAL_WOOL), conditionsFromItem(ModBlocks.BISEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.BISEXUAL_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PANSEXUAL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.PANSEXUAL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.PANSEXUAL_WOOL), conditionsFromItem(ModBlocks.PANSEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PANSEXUAL_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AROMANTIC_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.AROMANTIC_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.AROMANTIC_WOOL), conditionsFromItem(ModBlocks.AROMANTIC_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AROMANTIC_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMISEXUAL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.DEMISEXUAL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.DEMISEXUAL_WOOL), conditionsFromItem(ModBlocks.DEMISEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMISEXUAL_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.AGENDER_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.AGENDER_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.AGENDER_WOOL), conditionsFromItem(ModBlocks.AGENDER_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.AGENDER_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.PROGRESS_PRIDE_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.PROGRESS_PRIDE_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.PROGRESS_PRIDE_WOOL), conditionsFromItem(ModBlocks.PROGRESS_PRIDE_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.PROGRESS_PRIDE_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.ASEXUAL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.ASEXUAL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.ASEXUAL_WOOL), conditionsFromItem(ModBlocks.ASEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.ASEXUAL_BED)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GENDERFLUID_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.GENDERFLUID_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.GENDERFLUID_WOOL), conditionsFromItem(ModBlocks.GENDERFLUID_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERFLUID_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LESBIAN_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.LESBIAN_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.LESBIAN_WOOL), conditionsFromItem(ModBlocks.LESBIAN_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.LESBIAN_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMIBOY_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.DEMIBOY_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.DEMIBOY_WOOL), conditionsFromItem(ModBlocks.DEMIBOY_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIBOY_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.DEMIGIRL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.DEMIGIRL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.DEMIGIRL_WOOL), conditionsFromItem(ModBlocks.DEMIGIRL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.DEMIGIRL_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.GENDERQUEER_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.GENDERQUEER_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.GENDERQUEER_WOOL), conditionsFromItem(ModBlocks.GENDERQUEER_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.GENDERQUEER_BED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.POLYSEXUAL_BED, 1)
                .pattern("XXX")
                .pattern("YYY")
                .input('X', ModBlocks.POLYSEXUAL_WOOL)
                .input('Y', ItemTags.PLANKS)
                .criterion(hasItem(ModBlocks.POLYSEXUAL_WOOL), conditionsFromItem(ModBlocks.POLYSEXUAL_WOOL))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.POLYSEXUAL_BED)));




        Ingredient customElytra = Ingredient.ofItems(
                ModItems.RAINBOW_ELYTRA,
                ModItems.TRANS_ELYTRA,
                ModItems.NONBINARY_ELYTRA,
                ModItems.BISEXUAL_ELYTRA,
                ModItems.PANSEXUAL_ELYTRA,
                ModItems.AROMANTIC_ELYTRA,
                ModItems.DEMISEXUAL_ELYTRA,
                ModItems.AGENDER_ELYTRA,
                ModItems.PROGRESS_PRIDE_ELYTRA,
                ModItems.ASEXUAL_ELYTRA,
                ModItems.GENDERFLUID_ELYTRA,
                ModItems.LESBIAN_ELYTRA,
                ModItems.DEMIBOY_ELYTRA,
                ModItems.DEMIGIRL_ELYTRA,
                ModItems.GENDERQUEER_ELYTRA,
                ModItems.POLYSEXUAL_ELYTRA
        );

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.ELYTRA)
                .input(customElytra)
                .input(whiteDye)
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.ELYTRA)));




        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.NETHERITE_HELMET)
                .input(ModItems.RAINBOW_HELMET)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_HELMET), conditionsFromItem(ModItems.RAINBOW_HELMET))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_HELMET)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.NETHERITE_CHESTPLATE)
                .input(ModItems.RAINBOW_CHESTPLATE)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_CHESTPLATE), conditionsFromItem(ModItems.RAINBOW_CHESTPLATE))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_CHESTPLATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.NETHERITE_LEGGINGS)
                .input(ModItems.RAINBOW_LEGGINGS)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_LEGGINGS), conditionsFromItem(ModItems.RAINBOW_LEGGINGS))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_LEGGINGS)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.COMBAT, Items.NETHERITE_BOOTS)
                .input(ModItems.RAINBOW_BOOTS)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_BOOTS), conditionsFromItem(ModItems.RAINBOW_BOOTS))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_BOOTS)));




        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.NETHERITE_AXE)
                .input(ModItems.RAINBOW_AXE)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_AXE), conditionsFromItem(ModItems.RAINBOW_AXE))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_AXE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.NETHERITE_HOE)
                .input(ModItems.RAINBOW_HOE)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_HOE), conditionsFromItem(ModItems.RAINBOW_HOE))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_HOE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.NETHERITE_PICKAXE)
                .input(ModItems.RAINBOW_PICKAXE)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_PICKAXE), conditionsFromItem(ModItems.RAINBOW_PICKAXE))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_PICKAXE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.NETHERITE_SHOVEL)
                .input(ModItems.RAINBOW_SHOVEL)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_SHOVEL), conditionsFromItem(ModItems.RAINBOW_SHOVEL))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_SHOVEL)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, Items.NETHERITE_SWORD)
                .input(ModItems.RAINBOW_SWORD)
                .input(whiteDye)
                .criterion(hasItem(ModItems.RAINBOW_SWORD), conditionsFromItem(ModItems.RAINBOW_SWORD))
                .criterion(hasItem(Items.WHITE_DYE), conditionsFromItem(Items.WHITE_DYE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.NETHERITE_SWORD)));




        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_SLAB, 6)
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_FENCE, 3)
                .pattern("XSX")
                .pattern("XSX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_FENCE_GATE, 1)
                .pattern("SXS")
                .pattern("SXS")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_FENCE_GATE)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RAINBOW_BUTTON, 1)
                .input(ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BUTTON)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RAINBOW_PRESSURE_PLATE, 1)
                .pattern("XX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_PRESSURE_PLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_DOOR, 3)
                .pattern("XX ")
                .pattern("XX ")
                .pattern("XX ")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_TRAPDOOR, 2)
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_TRAPDOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_STANDING_SIGN, 3)
                .pattern("XXX")
                .pattern("XXX")
                .pattern(" S ")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .input('S', Items.STICK)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_STANDING_SIGN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_HANGING_SIGN, 3)
                .pattern(" S ")
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .input('S', Items.CHAIN)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .criterion(hasItem(Items.CHAIN), conditionsFromItem(Items.CHAIN))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_HANGING_SIGN)));





        ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.RAINBOW_BOAT, 1)
                .pattern("X X")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_PLANKS)
                .criterion(hasItem(ModBlocks.RAINBOW_PLANKS), conditionsFromItem(ModBlocks.RAINBOW_PLANKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAINBOW_BOAT)));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, ModItems.RAINBOW_CHEST_BOAT, 1)
                .input(ModItems.RAINBOW_BOAT)
                .input(Blocks.CHEST)
                .criterion(hasItem(ModItems.RAINBOW_BOAT), conditionsFromItem(ModItems.RAINBOW_BOAT))
                .criterion(hasItem(Blocks.CHEST), conditionsFromItem(Blocks.CHEST))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RAINBOW_CHEST_BOAT)));




        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_BRICK_STAIRS, 4)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_BRICKS)
                .criterion(hasItem(ModBlocks.RAINBOW_BRICKS), conditionsFromItem(ModBlocks.RAINBOW_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BRICK_STAIRS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_BRICK_SLAB, 6)
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_BRICKS)
                .criterion(hasItem(ModBlocks.RAINBOW_BRICKS), conditionsFromItem(ModBlocks.RAINBOW_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BRICK_SLAB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAINBOW_BRICK_WALL, 6)
                .pattern("XXX")
                .pattern("XXX")
                .input('X', ModBlocks.RAINBOW_BRICKS)
                .criterion(hasItem(ModBlocks.RAINBOW_BRICKS), conditionsFromItem(ModBlocks.RAINBOW_BRICKS))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.RAINBOW_BRICK_WALL)));
    }
}
