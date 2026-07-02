package net.wolren.land.integration.rei;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.wolren.land.Land;
import net.wolren.land.item.ModItems;
import org.spongepowered.include.com.google.common.collect.Lists;

import java.util.List;

public class RainbowCategory implements DisplayCategory {
    public static final CategoryIdentifier<RainbowCuttingDisplay> RAINBOW_DISPLAY = CategoryIdentifier.of(Land.MOD_ID, "rainbow_cutting");
    @Override
    public List<Widget> setupDisplay(Display display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 41, bounds.getCenterY() - 13);
        List<Widget> widgets = Lists.newArrayList();

        widgets.add(Widgets.createRecipeBase(bounds));

        widgets.add(Widgets.createArrow(new Point(startPoint.x + 27, startPoint.y + 4)));

        widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 61, startPoint.y + 5)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 61, startPoint.y + 5))
                .entries(display.getOutputEntries().get(0))
                .disableBackground()
                .markOutput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y - 7))
                .entries(display.getInputEntries().get(0))
                .markInput());

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 4, startPoint.y + 17))
                .entry(EntryStacks.of(ModItems.RAINBOW_DYE))
                .markInput());

        return widgets;
    }


    @Override
    public CategoryIdentifier getCategoryIdentifier() {
        return RAINBOW_DISPLAY;
    }

    @Override
    public Text getTitle() {
        return Text.of("Rainbow Crafting");
    }

    @Override
    public Renderer getIcon() {
        return null;
    }
}
