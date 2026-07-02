package net.wolren.land.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.recipe.RecipeEntry;
import net.wolren.land.recipe.RainbowCuttingRecipe;

import java.util.Collections;
import java.util.List;

public class RainbowCuttingDisplay extends BasicDisplay {
    public RainbowCuttingDisplay(RecipeEntry<RainbowCuttingRecipe> recipe) {
        this(EntryIngredients.ofIngredients(recipe.value().getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.value().getOutput())));
    }

    public RainbowCuttingDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RainbowCategory.RAINBOW_DISPLAY;
    }
}
