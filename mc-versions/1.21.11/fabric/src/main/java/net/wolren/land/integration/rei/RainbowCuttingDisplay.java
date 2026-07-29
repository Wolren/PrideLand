package net.wolren.land.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.wolren.land.recipe.RainbowCuttingRecipe;

import java.util.Collections;
import java.util.List;

public class RainbowCuttingDisplay extends BasicDisplay {
    public RainbowCuttingDisplay(RainbowCuttingRecipe recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()), Collections.singletonList(EntryIngredients.of(recipe.getOutput(BasicDisplay.registryAccess()))));
    }

    public RainbowCuttingDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RainbowCategory.RAINBOW_DISPLAY;
    }
}
