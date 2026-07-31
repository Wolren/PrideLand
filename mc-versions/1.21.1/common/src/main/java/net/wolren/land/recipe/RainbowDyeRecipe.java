package net.wolren.land.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class RainbowDyeRecipe extends ShapelessRecipe {
    public RainbowDyeRecipe(String group, ItemStack output, DefaultedList<Ingredient> ingredients) {
        super(group, CraftingRecipeCategory.MISC, output, ingredients);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        // Standard shapeless ingredient check via RecipeMatcher
        if (!super.matches(input, world)) return false;

        // Enforce all 3 items are different from each other
        Set<Item> uniqueItems = new HashSet<>();
        boolean hasItems = false;

        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);
            if (!stack.isEmpty()) {
                if (!uniqueItems.add(stack.getItem())) {
                    return false; // duplicate dye item
                }
                hasItems = true;
            }
        }

        return hasItems;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModSerializers.RAINBOW_DYE_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }
}
