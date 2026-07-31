package net.wolren.land.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.MenuScreens;
import net.wolren.land.PrideLand;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;

@Environment(EnvType.CLIENT)
public class PrideLandFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        PrideLand.clientInit();

        // Screen
        MenuScreens.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        // Note: Entity and block entity renderers are temporarily disabled for MC 26.2 compatibility.
    }
}
