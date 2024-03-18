package net.wolren.land.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.wolren.land.Land;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.recipe.RainbowCuttingRecipe;

public class ClientREIPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.addWorkstations(RainbowCategory.RAINBOW_DISPLAY, EntryStacks.of(ModBlocks.RAINBOW_CRAFTING));
        registry.add(new RainbowCategory());
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(RainbowCuttingRecipe.class, Land.RAINBOW_CUTTING, RainbowCuttingDisplay::new);
    }
}
