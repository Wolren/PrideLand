package net.wolren.land.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapelessRecipe;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class RainbowDyeRecipe extends ShapelessRecipe {
    private final ItemStack output;
    private final ItemStackTemplate resultTemplate;
    private final List<Ingredient> ingredientList;
    private final CraftingRecipe.CraftingBookInfo bookInfo;

    public RainbowDyeRecipe(CraftingRecipe.CraftingBookInfo bookInfo, ItemStackTemplate result, List<Ingredient> ingredients) {
        super(new Recipe.CommonInfo(true), bookInfo, result, ingredients);
        this.bookInfo = bookInfo;
        this.output = result.create();
        this.resultTemplate = result;
        this.ingredientList = Collections.unmodifiableList(ingredients);
    }

    @Override
    public boolean matches(CraftingInput input, Level world) {
        if (!super.matches(input, world)) return false;

        // Enforce all 3 items are different from each other
        Set<Item> uniqueItems = new HashSet<>();
        boolean hasItems = false;

        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
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
        return (RecipeSerializer<ShapelessRecipe>)(RecipeSerializer<?>) ModSerializers.RAINBOW_DYE_SERIALIZER;
    }

    @Override
    public RecipeType<CraftingRecipe> getType() {
        return RecipeType.CRAFTING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public CraftingRecipe.CraftingBookInfo getBookInfo() {
        return bookInfo;
    }

    public List<Ingredient> getIngredients() {
        return ingredientList;
    }

    public ItemStack getResult() {
        return output;
    }

    public ItemStackTemplate getResultTemplate() {
        return resultTemplate;
    }

    public String getGroup() {
        return bookInfo.group();
    }

    public CraftingBookCategory getCategory() {
        return bookInfo.category();
    }
}
