package net.wolren.land.integration.emi;

import dev.emi.emi.api.recipe.BasicEmiRecipe;
import dev.emi.emi.api.render.EmiTexture;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;

public class RainbowRecipe extends BasicEmiRecipe {

    public RainbowRecipe(RainbowCuttingRecipe recipe) {
        super(ClientEmi.RAINBOW_CATEGORY, recipe.getId(), 100, 60);
        this.inputs.add(EmiIngredient.of(recipe.getIngredients().get(0)));
        this.outputs.add(EmiStack.of(recipe.getOutput()));
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addTexture(EmiTexture.EMPTY_ARROW, 40, 20);

        widgets.addSlot(inputs.get(0), 15, 8);
        widgets.addSlot(EmiStack.of(ModItems.RAINBOW_DYE), 15, 32);

        widgets.addSlot(outputs.get(0), 70, 20).recipeContext(this);
    }
}