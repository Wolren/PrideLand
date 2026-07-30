package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.ShapelessRecipeInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class RainbowDyeRecipe extends ShapelessRecipe {
    private final ItemStack output;
    private final List<Ingredient> ingredientList;

    public RainbowDyeRecipe(String group, CraftingBookCategory category, ItemStack output, List<Ingredient> ingredients) {
        super(group, category, output, ingredients);
        this.output = output;
        this.ingredientList = Collections.unmodifiableList(ingredients);
    }

    @Override
    public boolean matches(ShapelessRecipeInput input, Level world) {
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
        return (RecipeSerializer<ShapelessRecipe>) (RecipeSerializer<?>) ModSerializers.RAINBOW_DYE_SERIALIZER;
    }

    @Override
    public net.minecraft.world.item.crafting.RecipeType<net.minecraft.world.item.crafting.CraftingRecipe> getType() {
        return net.minecraft.world.item.crafting.RecipeType.CRAFTING;
    }

    public List<Ingredient> getIngredients() {
        return ingredientList;
    }

    public ItemStack getResult() {
        return output;
    }
}
