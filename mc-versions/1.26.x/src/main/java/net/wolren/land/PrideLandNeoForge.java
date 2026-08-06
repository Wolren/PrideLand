package net.wolren.land;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.MobSpawnEvent;
import net.neoforged.neoforge.event.entity.living.SpawnClusterSizeEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.wolren.land.entity.ModEntities;

/**
 * NeoForge-specific event handler for PrideLand.
 * Handles server lifecycle events and config-driven rainbow sheep spawning.
 *
 * Natural spawns are registered by the data-driven biome modifier
 * (data/pride_land/forge/biome_modifier/add_rainbow_sheep_spawns.json) at the
 * base weight of 10; the events below apply the runtime config on top:
 *   - PositionCheck   — deny entirely when spawning is disabled
 *   - FinalizeSpawn   — scale the rate down when the config weight is below 10
 *   - SpawnClusterSize — clamp group sizes to the config min/max
 */
@EventBusSubscriber(modid = PrideLand.MOD_ID)
public class PrideLandNeoForge {

    private static final int BASE_SPAWN_WEIGHT = 10;

    @SubscribeEvent
    public static void onServerStarting(ServerStartingEvent event) {
        PrideLand.LOGGER.info("PrideLand server starting");
    }

    @SubscribeEvent
    public static void onPositionCheck(MobSpawnEvent.PositionCheck event) {
        if (event.getEntity().getType() != ModEntities.RAINBOW_SHEEP.get()) return;
        String biome = event.getLevel().getBiome(event.getEntity().blockPosition())
                .unwrapKey().map(k -> k.identifier().toString()).orElse("");
        if (!PrideLandConfig.activeSheepSpawnBiomes().contains(biome)) {
            event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
            return;
        }
        if (!PrideLandConfig.ENABLE_RAINBOW_SHEEP_SPAWNING.get()) {
            event.setResult(MobSpawnEvent.PositionCheck.Result.FAIL);
        }
    }

    @SubscribeEvent
    public static void onFinalizeSpawn(FinalizeSpawnEvent event) {
        if (event.getEntity().getType() != ModEntities.RAINBOW_SHEEP.get()) return;
        int cfgWeight = PrideLandConfig.SHEEP_WEIGHT.get();
        if (cfgWeight < BASE_SPAWN_WEIGHT
                && event.getEntity().getRandom().nextFloat() > (float) cfgWeight / BASE_SPAWN_WEIGHT) {
            event.setSpawnCancelled(true);
        }
    }

    @SubscribeEvent
    public static void onSpawnClusterSize(SpawnClusterSizeEvent event) {
        if (event.getEntity().getType() != ModEntities.RAINBOW_SHEEP.get()) return;
        int min = PrideLandConfig.SHEEP_MIN_GROUP_SIZE.get();
        int max = Math.max(min, PrideLandConfig.SHEEP_MAX_GROUP_SIZE.get());
        event.setSize(min + event.getEntity().getRandom().nextInt(max - min + 1));
    }
}
