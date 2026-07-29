package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.world.World;
import net.wolren.land.Land;

public class RainbowCuttingRecipe extends CuttingRecipe {
    public RainbowCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(Land.RAINBOW_CUTTING, ModSerializers.RAINBOW_CUTTING_SERIALIZER, group, ingredient, result);
    }

    public boolean matches(Inventory inventory, World world) {
        return this.ingredient.test(inventory.getStack(0));
    }

    public ItemStack createIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    public ItemStack getOutput() {
        return this.result;
    }

    public Ingredient getIngredient() {
        return this.ingredient;
    }

    @Override
    public RecipeType<?> getType() {
        return Land.RAINBOW_CUTTING;
    }
}
