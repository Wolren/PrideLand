package net.wolren.land.screen;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * Rainbow crafting screen - client side.
 * Simplified version for compilation.
 */
public class RainbowCraftingScreen extends AbstractContainerScreen<RainbowCraftingScreenHandler> {

    public RainbowCraftingScreen(RainbowCraftingScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void renderBg(net.minecraft.client.gui.GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
    }
}
