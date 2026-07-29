package net.wolren.land.recipe;

import net.minecraft.inventory.RecipeInputInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.HashSet;
import java.util.Set;

public class RainbowDyeRecipe extends ShapelessRecipe {
    public RainbowDyeRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> ingredients) {
        super(id, group, CraftingRecipeCategory.MISC, output, ingredients);
    }

    @Override
    public boolean matches(RecipeInputInventory inventory, World world) {
        // Standard shapeless ingredient check via RecipeMatcher
        if (!super.matches(inventory, world)) return false;

        // Enforce all 3 items are different from each other
        Set<Item> uniqueItems = new HashSet<>();
        boolean hasItems = false;

        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
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
