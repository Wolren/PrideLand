package net.wolren.land.integration.emi;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RainbowRecipe implements EmiRecipe {
    private final EmiIngredient input;
    private final EmiStack output;
    private final Identifier id;

    public RainbowRecipe(EmiIngredient input, EmiStack output, Identifier id) {
        this.input = input;
        this.output = output;
        this.id = id;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return ClientEmi.RAINBOW_CATEGORY;
    }

    @Override
    public @Nullable Identifier getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return List.of(input, EmiStack.of(ModItems.RAINBOW_DYE));
    }

    @Override
    public List<EmiStack> getOutputs() {
        return List.of(output);
    }

    @Override
    public int getDisplayWidth() { return 100; }

    @Override
    public int getDisplayHeight() { return 60; }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        widgets.addSlot(input, 15, 8);
        widgets.addSlot(EmiStack.of(ModItems.RAINBOW_DYE), 15, 32);
        widgets.addSlot(output, 70, 20).recipeContext(this);
    }
}
