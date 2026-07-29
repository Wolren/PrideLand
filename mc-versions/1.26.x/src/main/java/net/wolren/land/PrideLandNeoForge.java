package net.wolren.land;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

/**
 * NeoForge-specific event handler for PrideLand.
 * Handles server lifecycle events.
 */
@EventBusSubscriber(modid = PrideLand.MOD_ID)
public class PrideLandNeoForge {

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        PrideLand.LOGGER.info("PrideLand server starting");
    }
}
