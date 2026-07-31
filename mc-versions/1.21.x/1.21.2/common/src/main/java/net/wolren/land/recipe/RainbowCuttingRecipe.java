package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.SingleStackRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wolren.land.LandCommon;

public class RainbowCuttingRecipe extends SingleStackRecipe {
    public RainbowCuttingRecipe(String group, Ingredient input, ItemStack output) {
        super(group, input, output);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.item());
    }

    // Use Yarn field name from CuttingRecipe: "result" not "output"
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public net.minecraft.recipe.book.RecipeBookCategory getRecipeBookCategory() {
        return net.minecraft.recipe.book.RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public RecipeSerializer<? extends SingleStackRecipe> getSerializer() {
        return ModSerializers.RAINBOW_CUTTING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends SingleStackRecipe> getType() {
        return (RecipeType<? extends SingleStackRecipe>) LandCommon.RAINBOW_CUTTING;
    }
}
