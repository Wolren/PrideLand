package net.wolren.land.screen;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.wolren.land.PrideLand;

public class ModScreenHandlers {
    public static MenuType<RainbowCraftingScreenHandler> BOX_SCREEN_HANDLER = null;

    public static void registerScreenHandlers() {
        PrideLand.LOGGER.info("Registering Screen Handlers for " + PrideLand.MOD_ID);
    }

    public static void setBoxScreenHandler(MenuType<RainbowCraftingScreenHandler> type) {
        BOX_SCREEN_HANDLER = type;
    }
}
