package net.wolren.land.screen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class RainbowCraftingScreen extends AbstractContainerScreen<RainbowCraftingScreenHandler> {
    public RainbowCraftingScreen(RainbowCraftingScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }
}
