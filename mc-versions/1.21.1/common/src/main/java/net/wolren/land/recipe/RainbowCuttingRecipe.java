package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wolren.land.LandCommon;

public class RainbowCuttingRecipe extends CuttingRecipe {
    public RainbowCuttingRecipe(String group, Ingredient input, ItemStack output) {
        super(LandCommon.RAINBOW_CUTTING, ModSerializers.RAINBOW_CUTTING_SERIALIZER, group, input, output);
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        return this.ingredient.test(input.item());
    }

    // Use Yarn field name from CuttingRecipe: "result" not "output"
    public ItemStack getOutput() {
        return this.result;
    }

    @Override
    public RecipeType<?> getType() {
        return LandCommon.RAINBOW_CUTTING;
    }
}
