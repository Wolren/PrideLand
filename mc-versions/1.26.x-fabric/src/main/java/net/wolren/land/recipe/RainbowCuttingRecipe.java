package net.wolren.land.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.StonecutterRecipe;

public class RainbowCuttingRecipe extends StonecutterRecipe {
    public RainbowCuttingRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(group, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, net.minecraft.world.level.Level world) {
        return this.ingredient.test(input.item());
    }

    public ItemStack createIcon() {
        return new ItemStack(net.minecraft.world.level.block.Blocks.STONECUTTER);
    }

    public ItemStack getOutput() {
        return this.result;
    }
}
