package net.wolren.land.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.context.ContextMap;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.SelectableRecipe;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.item.crafting.display.SlotDisplayContext;
import net.wolren.land.PrideLand;

import java.util.List;

public class RainbowCraftingScreen extends AbstractContainerScreen<RainbowCraftingScreenHandler> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "textures/gui/container/rainbow_crafting.png");
    private static final Identifier SCROLLER_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/scroller");
    private static final Identifier SCROLLER_DISABLED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/scroller_disabled");
    private static final Identifier RECIPE_SELECTED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe_selected");
    private static final Identifier RECIPE_HIGHLIGHTED_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe_highlighted");
    private static final Identifier RECIPE_SPRITE = Identifier.withDefaultNamespace("container/stonecutter/recipe");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public RainbowCraftingScreen(RainbowCraftingScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
        handler.registerUpdateListener(this::containerChanged);
        this.titleLabelY--;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractBackground(graphics, mouseX, mouseY, partialTick);
        int x = this.leftPos;
        int y = this.topPos;
        graphics.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);

        int sy = (int) (41.0F * this.scrollAmount);
        Identifier sprite = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        int scrollerX = x + 119;
        int scrollerY = y + 15;
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, sprite, scrollerX, scrollerY + sy, 12, 15);

        int rx = this.leftPos + 52;
        int ry = this.topPos + 14;
        int endIndex = this.scrollOffset + 12;
        this.extractButtons(graphics, mouseX, mouseY, rx, ry, endIndex);
        this.extractRecipes(graphics, rx, ry, endIndex);
    }

    private void extractButtons(GuiGraphicsExtractor graphics, int mouseX, int mouseY, int x, int y, int endIndex) {
        List<SelectableRecipe.SingleInputEntry<StonecutterRecipe>> recipes = this.menu.getVisibleRecipes().entries();
        for (int index = this.scrollOffset; index < endIndex && index < recipes.size(); index++) {
            int posIndex = index - this.scrollOffset;
            int posX = x + posIndex % 4 * 16;
            int row = posIndex / 4;
            int posY = y + row * 18 + 2;
            Identifier sprite;
            if (index == this.menu.getSelectedRecipe()) {
                sprite = RECIPE_SELECTED_SPRITE;
            } else if (mouseX >= posX && mouseY >= posY && mouseX < posX + 16 && mouseY < posY + 18) {
                sprite = RECIPE_HIGHLIGHTED_SPRITE;
            } else {
                sprite = RECIPE_SPRITE;
            }
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, sprite, posX, posY - 1, 16, 18);
        }
    }

    private void extractRecipes(GuiGraphicsExtractor graphics, int x, int y, int endIndex) {
        List<SelectableRecipe.SingleInputEntry<StonecutterRecipe>> recipes = this.menu.getVisibleRecipes().entries();
        ContextMap context = SlotDisplayContext.fromLevel(this.minecraft.level);
        for (int index = this.scrollOffset; index < endIndex && index < recipes.size(); index++) {
            int posIndex = index - this.scrollOffset;
            int posX = x + posIndex % 4 * 16;
            int row = posIndex / 4;
            int posY = y + row * 18 + 2;
            ItemStack result = recipes.get(index).recipe().optionDisplay().resolveForFirstStack(context);
            graphics.item(result, posX, posY);
        }
    }

    @Override
    public boolean mouseClicked(MouseButtonEvent event, boolean doubleClick) {
        if (this.canCraft) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.scrollOffset + 12;

            for (int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = event.x() - (double) (i + m % 4 * 16);
                double e = event.y() - (double) (j + m / 4 * 18);
                if (d >= 0.0 && e >= 0.0 && d < 16.0 && e < 18.0 && this.menu.clickMenuButton(this.minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, l);
                    return true;
                }
            }

            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (event.x() >= (double) i && event.x() < (double) (i + 12) && event.y() >= (double) j && event.y() < (double) (j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(event, doubleClick);
    }

    @Override
    public boolean mouseDragged(MouseButtonEvent event, double dragX, double dragY) {
        double mouseY = event.y();
        if (this.mouseClicked && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollAmount = ((float) mouseY - (float) i - 7.5F) / ((float) (j - i) - 15.0F);
            this.scrollAmount = Mth.clamp(this.scrollAmount, 0.0F, 1.0F);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) this.getMaxScroll()) + 0.5) * 4;
            return true;
        }
        return super.mouseDragged(event, dragX, dragY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (this.isScrollBarActive()) {
            int i = this.getMaxScroll();
            float f = (float) scrollY / (float) i;
            this.scrollAmount = Mth.clamp(this.scrollAmount - f, 0.0F, 1.0F);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) i) + 0.5) * 4;
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return this.canCraft && this.menu.getVisibleRecipes().size() > 12;
    }

    private int getMaxScroll() {
        return (this.menu.getVisibleRecipes().size() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.canCraft = this.menu.canCraft();
        this.scrollAmount = 0.0F;
        this.scrollOffset = 0;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        this.canCraft = this.menu.canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0F;
            this.scrollOffset = 0;
        }
    }
}
