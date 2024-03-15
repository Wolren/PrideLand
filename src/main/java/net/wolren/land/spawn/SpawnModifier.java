package net.wolren.land.spawn;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.util.config.RainbowConfig;

public class SpawnModifier {
    public static RainbowConfig config = AutoConfig.getConfigHolder(RainbowConfig.class).getConfig();
    public static void modifySpawning() {
        if (config.enableRainbowSheepSpawning) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.BIRCH_FOREST),
                    SpawnGroup.CREATURE,
                    ModEntities.RAINBOW_SHEEP,
                    config.sheepWeight,
                    config.sheepMinGroupSize,
                    config.sheepMaxGroupSize
            );
        }
    }
}
