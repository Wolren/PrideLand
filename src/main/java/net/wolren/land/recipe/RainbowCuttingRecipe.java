package net.wolren.land.recipe;

import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wolren.land.Land;

public class RainbowCuttingRecipe extends CuttingRecipe {
    public RainbowCuttingRecipe(Identifier id, String group, Ingredient input, ItemStack output) {
        super(Land.RAINBOW_CUTTING, ModSerializers.RAINBOW_CUTTING_SERIALIZER, id, group, input, output);
    }

    public boolean matches(Inventory inventory, World world) {
        return this.input.test(inventory.getStack(0));
    }

    public ItemStack createIcon() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    @Override
    public RecipeType<?> getType() {
        return Land.RAINBOW_CUTTING;
    }
}
