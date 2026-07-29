package net.wolren.land.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import net.minecraft.item.ItemStack;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import net.wolren.land.item.ModItems;

import java.util.Collections;
import java.util.List;

public class RainbowCuttingDisplay extends BasicDisplay {
    public RainbowCuttingDisplay(RainbowCuttingRecipe recipe) {
        this(
            Collections.singletonList(EntryIngredients.of(recipe.getIngredients().get(0).getMatchingStacks()[0].getItem())),
            Collections.singletonList(EntryIngredients.of(recipe.getOutput()))
        );
    }

    public RainbowCuttingDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RainbowCategory.RAINBOW_DISPLAY;
    }

    @Override
    public DisplaySerializer<? extends BasicDisplay> getSerializer() {
        return BasicDisplay.Serializer.INSTANCE;
    }
}
