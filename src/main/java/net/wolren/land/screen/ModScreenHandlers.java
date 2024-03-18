package net.wolren.land.screen;


import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RainbowCraftingScreenHandler> BOX_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Land.MOD_ID, "rainbow_workstation"),
                    new ExtendedScreenHandlerType<>(RainbowCraftingScreenHandler::new));

    public static void registerScreenHandlers() {
        Land.LOGGER.info("Registering Screen Handlers for " + Land.MOD_ID);
    }
}
