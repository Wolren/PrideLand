package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;

public class RainbowCuttingRecipe extends StonecutterRecipe {
    public RainbowCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level world) {
        return this.ingredient.test(input.item());
    }

    @Override
    public RecipeSerializer<? extends StonecutterRecipe> getSerializer() {
        return ModSerializers.RAINBOW_CUTTING_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return net.wolren.land.PrideLand.RAINBOW_CUTTING;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.ingredient);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER_MISC;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    public ItemStack getResult() {
        return this.result;
    }
}
