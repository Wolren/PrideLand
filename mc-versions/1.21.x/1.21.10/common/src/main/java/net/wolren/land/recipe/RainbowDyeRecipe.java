package net.wolren.land.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.CraftingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RainbowDyeRecipe extends ShapelessRecipe {
    private final ItemStack output;
    private final List<Ingredient> ingredientList;

    public RainbowDyeRecipe(String group, CraftingRecipeCategory category, ItemStack output, List<Ingredient> ingredients) {
        super(group, category, output, ingredients);
        this.output = output;
        this.ingredientList = Collections.unmodifiableList(ingredients);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {
        // Standard shapeless ingredient check via RecipeMatcher
        if (!super.matches(input, world)) return false;

        // Enforce all 3 items are different from each other
        Set<Item> uniqueItems = new HashSet<>();
        boolean hasItems = false;

        for (int i = 0; i < input.size(); i++) {
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
    @SuppressWarnings("unchecked")
    public RecipeSerializer<ShapelessRecipe> getSerializer() {
        // Safe: RainbowDyeSerializer implements RecipeSerializer<RainbowDyeRecipe>,
        // and RainbowDyeRecipe extends ShapelessRecipe
        return (RecipeSerializer<ShapelessRecipe>) (RecipeSerializer<?>) ModSerializers.RAINBOW_DYE_SERIALIZER;
    }

    @Override
    public RecipeType<CraftingRecipe> getType() {
        return RecipeType.CRAFTING;
    }

    public List<Ingredient> getIngredients() {
        return ingredientList;
    }

    public ItemStack getResult() {
        return output;
    }
}
