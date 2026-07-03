package net.wolren.land.screen;

import net.minecraft.screen.ScreenHandlerType;
import net.wolren.land.LandCommon;

public class ModScreenHandlers {
    // Initialized by platform-specific modules (fabric/forge) during init
    public static ScreenHandlerType<RainbowCraftingScreenHandler> BOX_SCREEN_HANDLER = null;

    public static void registerScreenHandlers() {
        LandCommon.LOGGER.info("Registering Screen Handlers for " + LandCommon.MOD_ID);
    }

    public static void setBoxScreenHandler(ScreenHandlerType<RainbowCraftingScreenHandler> type) {
        BOX_SCREEN_HANDLER = type;
    }
}
