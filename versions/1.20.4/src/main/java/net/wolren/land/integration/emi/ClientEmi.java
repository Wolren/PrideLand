package net.wolren.land.integration.emi;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.recipe.RainbowCuttingRecipe;

public class ClientEmi implements EmiPlugin {
    public static final EmiStack WORKSTATION = EmiStack.of(ModBlocks.RAINBOW_CRAFTING);
    public static final EmiRecipeCategory RAINBOW_CATEGORY
            = new EmiRecipeCategory(new Identifier(Land.MOD_ID, "rainbow_cutting"), WORKSTATION);
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(RAINBOW_CATEGORY);
        registry.addWorkstation(RAINBOW_CATEGORY, WORKSTATION);

        RecipeManager manager = registry.getRecipeManager();

        for (RecipeEntry<RainbowCuttingRecipe> recipe : manager.listAllOfType(Land.RAINBOW_CUTTING)) {
            registry.addRecipe(new RainbowRecipe(recipe.value()));
        }
    }
}
