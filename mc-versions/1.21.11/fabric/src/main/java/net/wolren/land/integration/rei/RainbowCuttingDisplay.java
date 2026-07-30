package net.wolren.land.integration.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryStacks;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RainbowCuttingDisplay implements Display {
    private final List<EntryIngredient> input;
    private final List<EntryIngredient> output;

    public RainbowCuttingDisplay(List<EntryIngredient> input, List<EntryIngredient> output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return input;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return output;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return RainbowCategory.RAINBOW_DISPLAY;
    }

    @Override
    public Optional<net.minecraft.util.Identifier> getDisplayLocation() {
        return Optional.empty();
    }

    @Override
    public DisplaySerializer<?> getSerializer() {
        return null;
    }
}
