package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.StonecuttingRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wolren.land.LandCommon;

public class RainbowCuttingRecipe extends StonecuttingRecipe {
    public RainbowCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.ingredient.test(inventory.getStack(0));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public RecipeType<? extends StonecuttingRecipe> getType() {
        return LandCommon.RAINBOW_CUTTING;
    }
}
