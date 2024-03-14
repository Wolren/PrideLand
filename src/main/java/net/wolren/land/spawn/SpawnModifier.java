package net.wolren.land.spawn;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.wolren.land.entity.ModEntities;

public class SpawnModifier {
    public static void modifySpawning() {
        BiomeModifications.addSpawn(
                BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST, BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.BIRCH_FOREST),
                SpawnGroup.CREATURE,
                ModEntities.RAINBOW_SHEEP,
                5,
                2,
                3
        );
    }
}
