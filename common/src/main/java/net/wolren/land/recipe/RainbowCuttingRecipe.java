package net.wolren.land.recipe;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.wolren.land.LandCommon;

public class RainbowCuttingRecipe extends SingleItemRecipe {
    public RainbowCuttingRecipe(ResourceLocation id, String group, Ingredient input, ItemStack output) {
        super(LandCommon.RAINBOW_CUTTING, ModSerializers.RAINBOW_CUTTING_SERIALIZER, id, group, input, output);
    }

    @Override
    public boolean matches(Container inventory, Level world) {
        return this.ingredient.test(inventory.getItem(0));
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.STONECUTTER);
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.result;
    }

    @Override
    public RecipeType<?> getType() {
        return LandCommon.RAINBOW_CUTTING;
    }
}
