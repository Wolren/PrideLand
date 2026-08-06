package net.wolren.land.util.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RainbowConfig {
    public boolean enableRainbowSheepSpawning = true;
    public int sheepWeight = 10;
    public int sheepMinGroupSize = 2;
    public int sheepMaxGroupSize = 3;
    public SpawnBiomes sheepSpawnBiomes = new SpawnBiomes();

    public static class SpawnBiomes {
        public boolean plains = true;
        public boolean forest = true;
        public boolean flowerForest = true;
        public boolean sunflowerPlains = true;
        public boolean birchForest = true;
        public boolean oldGrowthBirchForest = false;
        public boolean darkForest = false;
        public boolean paleGarden = false;
        public boolean snowyPlains = false;
        public boolean iceSpikes = false;
        public boolean snowyTaiga = false;
        public boolean taiga = false;
        public boolean oldGrowthPineTaiga = false;
        public boolean oldGrowthSpruceTaiga = false;
        public boolean jungle = false;
        public boolean sparseJungle = false;
        public boolean bambooJungle = false;
        public boolean savanna = false;
        public boolean savannaPlateau = false;
        public boolean windsweptSavanna = false;
        public boolean windsweptHills = false;
        public boolean windsweptForest = false;
        public boolean windsweptGravellyHills = false;
        public boolean desert = false;
        public boolean badlands = false;
        public boolean woodedBadlands = false;
        public boolean erodedBadlands = false;
        public boolean meadow = false;
        public boolean cherryGrove = false;
        public boolean grove = false;
        public boolean snowySlopes = false;
        public boolean frozenPeaks = false;
        public boolean jaggedPeaks = false;
        public boolean stonyPeaks = false;
        public boolean swamp = false;
        public boolean mangroveSwamp = false;
        public boolean mushroomFields = false;
        public boolean deepDark = false;
        public boolean dripstoneCaves = false;
        public boolean lushCaves = false;
        public boolean beach = false;
        public boolean snowyBeach = false;
        public boolean stonyShore = false;
        public boolean river = false;
        public boolean frozenRiver = false;
        public boolean ocean = false;
        public boolean deepOcean = false;
        public boolean warmOcean = false;
        public boolean lukewarmOcean = false;
        public boolean deepLukewarmOcean = false;
        public boolean coldOcean = false;
        public boolean deepColdOcean = false;
        public boolean frozenOcean = false;
        public boolean deepFrozenOcean = false;
        public boolean netherWastes = false;
        public boolean soulSandValley = false;
        public boolean crimsonForest = false;
        public boolean warpedForest = false;
        public boolean basaltDeltas = false;
        public boolean theEnd = false;
        public boolean smallEndIslands = false;
        public boolean endMidlands = false;
        public boolean endHighlands = false;
        public boolean endBarrens = false;
    }

    public java.util.List<String> activeSheepSpawnBiomes() {
        java.util.List<String> result = new java.util.ArrayList<>();
        SpawnBiomes b = sheepSpawnBiomes;
        if (b.plains) result.add("minecraft:plains");
        if (b.forest) result.add("minecraft:forest");
        if (b.flowerForest) result.add("minecraft:flower_forest");
        if (b.sunflowerPlains) result.add("minecraft:sunflower_plains");
        if (b.birchForest) result.add("minecraft:birch_forest");
        if (b.oldGrowthBirchForest) result.add("minecraft:old_growth_birch_forest");
        if (b.darkForest) result.add("minecraft:dark_forest");
        if (b.paleGarden) result.add("minecraft:pale_garden");
        if (b.snowyPlains) result.add("minecraft:snowy_plains");
        if (b.iceSpikes) result.add("minecraft:ice_spikes");
        if (b.snowyTaiga) result.add("minecraft:snowy_taiga");
        if (b.taiga) result.add("minecraft:taiga");
        if (b.oldGrowthPineTaiga) result.add("minecraft:old_growth_pine_taiga");
        if (b.oldGrowthSpruceTaiga) result.add("minecraft:old_growth_spruce_taiga");
        if (b.jungle) result.add("minecraft:jungle");
        if (b.sparseJungle) result.add("minecraft:sparse_jungle");
        if (b.bambooJungle) result.add("minecraft:bamboo_jungle");
        if (b.savanna) result.add("minecraft:savanna");
        if (b.savannaPlateau) result.add("minecraft:savanna_plateau");
        if (b.windsweptSavanna) result.add("minecraft:windswept_savanna");
        if (b.windsweptHills) result.add("minecraft:windswept_hills");
        if (b.windsweptForest) result.add("minecraft:windswept_forest");
        if (b.windsweptGravellyHills) result.add("minecraft:windswept_gravelly_hills");
        if (b.desert) result.add("minecraft:desert");
        if (b.badlands) result.add("minecraft:badlands");
        if (b.woodedBadlands) result.add("minecraft:wooded_badlands");
        if (b.erodedBadlands) result.add("minecraft:eroded_badlands");
        if (b.meadow) result.add("minecraft:meadow");
        if (b.cherryGrove) result.add("minecraft:cherry_grove");
        if (b.grove) result.add("minecraft:grove");
        if (b.snowySlopes) result.add("minecraft:snowy_slopes");
        if (b.frozenPeaks) result.add("minecraft:frozen_peaks");
        if (b.jaggedPeaks) result.add("minecraft:jagged_peaks");
        if (b.stonyPeaks) result.add("minecraft:stony_peaks");
        if (b.swamp) result.add("minecraft:swamp");
        if (b.mangroveSwamp) result.add("minecraft:mangrove_swamp");
        if (b.mushroomFields) result.add("minecraft:mushroom_fields");
        if (b.deepDark) result.add("minecraft:deep_dark");
        if (b.dripstoneCaves) result.add("minecraft:dripstone_caves");
        if (b.lushCaves) result.add("minecraft:lush_caves");
        if (b.beach) result.add("minecraft:beach");
        if (b.snowyBeach) result.add("minecraft:snowy_beach");
        if (b.stonyShore) result.add("minecraft:stony_shore");
        if (b.river) result.add("minecraft:river");
        if (b.frozenRiver) result.add("minecraft:frozen_river");
        if (b.ocean) result.add("minecraft:ocean");
        if (b.deepOcean) result.add("minecraft:deep_ocean");
        if (b.warmOcean) result.add("minecraft:warm_ocean");
        if (b.lukewarmOcean) result.add("minecraft:lukewarm_ocean");
        if (b.deepLukewarmOcean) result.add("minecraft:deep_lukewarm_ocean");
        if (b.coldOcean) result.add("minecraft:cold_ocean");
        if (b.deepColdOcean) result.add("minecraft:deep_cold_ocean");
        if (b.frozenOcean) result.add("minecraft:frozen_ocean");
        if (b.deepFrozenOcean) result.add("minecraft:deep_frozen_ocean");
        if (b.netherWastes) result.add("minecraft:nether_wastes");
        if (b.soulSandValley) result.add("minecraft:soul_sand_valley");
        if (b.crimsonForest) result.add("minecraft:crimson_forest");
        if (b.warpedForest) result.add("minecraft:warped_forest");
        if (b.basaltDeltas) result.add("minecraft:basalt_deltas");
        if (b.theEnd) result.add("minecraft:the_end");
        if (b.smallEndIslands) result.add("minecraft:small_end_islands");
        if (b.endMidlands) result.add("minecraft:end_midlands");
        if (b.endHighlands) result.add("minecraft:end_highlands");
        if (b.endBarrens) result.add("minecraft:end_barrens");
        return result;
    }



    /**
     * Loads the config from config/pride_land.json under the given config dir,
     * writing defaults on first run. Missing or corrupt files fall back to defaults.
     */
    public static RainbowConfig load(Path configDir) {
        Path file = configDir.resolve("pride_land.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        RainbowConfig config = new RainbowConfig();
        if (Files.exists(file)) {
            try {
                RainbowConfig parsed = gson.fromJson(Files.readString(file), RainbowConfig.class);
                if (parsed != null) config = parsed;
            } catch (IOException | com.google.gson.JsonSyntaxException ignored) {
                // keep defaults
            }
        } else {
            try {
                Files.createDirectories(configDir);
                Files.writeString(file, gson.toJson(config));
            } catch (IOException ignored) {
            }
        }
        return config;
    }
}
