package net.wolren.land;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * PrideLand configuration via NeoForge config system.
 */
public class PrideLandConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.BooleanValue ENABLE_RAINBOW_SHEEP_SPAWNING;
    public static final ModConfigSpec.IntValue SHEEP_WEIGHT;
    public static final ModConfigSpec.IntValue SHEEP_MIN_GROUP_SIZE;
    public static final ModConfigSpec.IntValue SHEEP_MAX_GROUP_SIZE;

    /** Per-biome spawn toggles: field name -> default (the original five default true). */
    public static final Map<String, Boolean> SHEEP_BIOME_DEFAULTS = new LinkedHashMap<>();
    /** Field name -> minecraft biome id. */
    public static final Map<String, String> SHEEP_BIOME_IDS = new LinkedHashMap<>();
    public static final Map<String, ModConfigSpec.BooleanValue> SHEEP_SPAWN_BIOMES = new LinkedHashMap<>();

    private static void biome(String field, String id, boolean def) {
        SHEEP_BIOME_DEFAULTS.put(field, def);
        SHEEP_BIOME_IDS.put(field, id);
    }

    static {
        biome("plains", "minecraft:plains", true);
        biome("forest", "minecraft:forest", true);
        biome("flowerForest", "minecraft:flower_forest", true);
        biome("sunflowerPlains", "minecraft:sunflower_plains", true);
        biome("birchForest", "minecraft:birch_forest", true);
        biome("oldGrowthBirchForest", "minecraft:old_growth_birch_forest", false);
        biome("darkForest", "minecraft:dark_forest", false);
        biome("paleGarden", "minecraft:pale_garden", false);
        biome("snowyPlains", "minecraft:snowy_plains", false);
        biome("iceSpikes", "minecraft:ice_spikes", false);
        biome("snowyTaiga", "minecraft:snowy_taiga", false);
        biome("taiga", "minecraft:taiga", false);
        biome("oldGrowthPineTaiga", "minecraft:old_growth_pine_taiga", false);
        biome("oldGrowthSpruceTaiga", "minecraft:old_growth_spruce_taiga", false);
        biome("jungle", "minecraft:jungle", false);
        biome("sparseJungle", "minecraft:sparse_jungle", false);
        biome("bambooJungle", "minecraft:bamboo_jungle", false);
        biome("savanna", "minecraft:savanna", false);
        biome("savannaPlateau", "minecraft:savanna_plateau", false);
        biome("windsweptSavanna", "minecraft:windswept_savanna", false);
        biome("windsweptHills", "minecraft:windswept_hills", false);
        biome("windsweptForest", "minecraft:windswept_forest", false);
        biome("windsweptGravellyHills", "minecraft:windswept_gravelly_hills", false);
        biome("desert", "minecraft:desert", false);
        biome("badlands", "minecraft:badlands", false);
        biome("woodedBadlands", "minecraft:wooded_badlands", false);
        biome("erodedBadlands", "minecraft:eroded_badlands", false);
        biome("meadow", "minecraft:meadow", false);
        biome("cherryGrove", "minecraft:cherry_grove", false);
        biome("grove", "minecraft:grove", false);
        biome("snowySlopes", "minecraft:snowy_slopes", false);
        biome("frozenPeaks", "minecraft:frozen_peaks", false);
        biome("jaggedPeaks", "minecraft:jagged_peaks", false);
        biome("stonyPeaks", "minecraft:stony_peaks", false);
        biome("swamp", "minecraft:swamp", false);
        biome("mangroveSwamp", "minecraft:mangrove_swamp", false);
        biome("mushroomFields", "minecraft:mushroom_fields", false);
        biome("deepDark", "minecraft:deep_dark", false);
        biome("dripstoneCaves", "minecraft:dripstone_caves", false);
        biome("lushCaves", "minecraft:lush_caves", false);
        biome("beach", "minecraft:beach", false);
        biome("snowyBeach", "minecraft:snowy_beach", false);
        biome("stonyShore", "minecraft:stony_shore", false);
        biome("river", "minecraft:river", false);
        biome("frozenRiver", "minecraft:frozen_river", false);
        biome("ocean", "minecraft:ocean", false);
        biome("deepOcean", "minecraft:deep_ocean", false);
        biome("warmOcean", "minecraft:warm_ocean", false);
        biome("lukewarmOcean", "minecraft:lukewarm_ocean", false);
        biome("deepLukewarmOcean", "minecraft:deep_lukewarm_ocean", false);
        biome("coldOcean", "minecraft:cold_ocean", false);
        biome("deepColdOcean", "minecraft:deep_cold_ocean", false);
        biome("frozenOcean", "minecraft:frozen_ocean", false);
        biome("deepFrozenOcean", "minecraft:deep_frozen_ocean", false);
        biome("netherWastes", "minecraft:nether_wastes", false);
        biome("soulSandValley", "minecraft:soul_sand_valley", false);
        biome("crimsonForest", "minecraft:crimson_forest", false);
        biome("warpedForest", "minecraft:warped_forest", false);
        biome("basaltDeltas", "minecraft:basalt_deltas", false);
        biome("theEnd", "minecraft:the_end", false);
        biome("smallEndIslands", "minecraft:small_end_islands", false);
        biome("endMidlands", "minecraft:end_midlands", false);
        biome("endHighlands", "minecraft:end_highlands", false);
        biome("endBarrens", "minecraft:end_barrens", false);

        BUILDER.push("general");
        ENABLE_RAINBOW_SHEEP_SPAWNING = BUILDER
                .comment("Whether rainbow sheep spawn naturally")
                .translation("pride_land.configuration.general.enableRainbowSheepSpawning")
                .define("enableRainbowSheepSpawning", true);
        SHEEP_WEIGHT = BUILDER
                .comment("Natural spawn weight (relative to the biome modifier base weight of 10)")
                .translation("pride_land.configuration.general.sheepWeight")
                .defineInRange("sheepWeight", 10, 0, 10);
        SHEEP_MIN_GROUP_SIZE = BUILDER
                .comment("Minimum rainbow sheep per spawn group")
                .translation("pride_land.configuration.general.sheepMinGroupSize")
                .defineInRange("sheepMinGroupSize", 2, 1, 16);
        SHEEP_MAX_GROUP_SIZE = BUILDER
                .comment("Maximum rainbow sheep per spawn group")
                .translation("pride_land.configuration.general.sheepMaxGroupSize")
                .defineInRange("sheepMaxGroupSize", 3, 1, 16);
        BUILDER.pop();

        BUILDER.push("sheepSpawnBiomes");
        for (Map.Entry<String, Boolean> e : SHEEP_BIOME_DEFAULTS.entrySet()) {
            SHEEP_SPAWN_BIOMES.put(e.getKey(), BUILDER
                    .translation("pride_land.configuration.sheepSpawnBiomes." + e.getKey())
                    .define(e.getKey(), e.getValue().booleanValue()));
        }
        BUILDER.pop();

        SPEC = BUILDER.build();
    }

    /** Biome ids currently toggled on. */
    public static List<String> activeSheepSpawnBiomes() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, ModConfigSpec.BooleanValue> e : SHEEP_SPAWN_BIOMES.entrySet()) {
            if (e.getValue().get()) result.add(SHEEP_BIOME_IDS.get(e.getKey()));
        }
        return result;
    }
}
