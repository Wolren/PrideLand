package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SingleStackRecipe;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.world.World;
import net.wolren.land.LandCommon;

public class RainbowCuttingRecipe extends StonecuttingRecipe {
    public RainbowCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient().test(input.item());
    }

    public ItemStack createIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    public ItemStack getOutput() {
        return this.result();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModSerializers.RAINBOW_CUTTING_SERIALIZER;
    }

    @Override
    public RecipeType<? extends SingleStackRecipe> getType() {
        return LandCommon.RAINBOW_CUTTING;
    }
}
