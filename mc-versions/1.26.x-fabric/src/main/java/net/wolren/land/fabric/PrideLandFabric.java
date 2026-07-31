package net.wolren.land.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.block.fuels.CustomFuelRegistry;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.fabric.entity.ModBoats;
import net.wolren.land.item.ModCreativeModeTabs;
import net.wolren.land.item.ModItems;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.util.ModTags;
import net.wolren.land.util.config.RainbowConfig;

public class PrideLandFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PrideLand.init();

        // Registrations
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModCreativeModeTabs.registerCreativeModeTabs();
        ModEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModSerializers.registerCuttingSerializers();
        ModTags.registerModTags();

        // Boats (Terraform API - Fabric only, basic setup)
        ModBoats.registerBoats();

        // Entity attributes for rainbow sheep
        FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_SHEEP, Sheep.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0)
                .add(Attributes.MOVEMENT_SPEED, 0.23F));

        // Recipe type
        PrideLand.RAINBOW_CUTTING = net.minecraft.world.item.crafting.RecipeType.register(PrideLand.MOD_ID + ":rainbow_cutting");

        // Biome spawning for rainbow sheep (config-gated)
        RainbowConfig config = new RainbowConfig();
        if (config.enableRainbowSheepSpawning) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(
                            Biomes.PLAINS, Biomes.FOREST, Biomes.FLOWER_FOREST,
                            Biomes.SUNFLOWER_PLAINS, Biomes.BIRCH_FOREST
                    ),
                    MobCategory.CREATURE,
                    ModEntities.RAINBOW_SHEEP,
                    config.sheepWeight,
                    config.sheepMinGroupSize,
                    config.sheepMaxGroupSize
            );
        }

        // Fuel registry (MC 26.2: FuelValueEvents.BUILD)
        FuelValueEvents.BUILD.register((builder, context) -> {
            CustomFuelRegistry.getCustomFuels().forEach((item, burnTime) ->
                builder.add(item, burnTime)
            );
        });

        // Screen handler type (vanilla registry)
        ModScreenHandlers.setBoxScreenHandler(
                Registry.register(
                        BuiltInRegistries.MENU,
                        Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_workstation"),
                        new MenuType<>((syncId, inventory) -> new RainbowCraftingScreenHandler(syncId, inventory), FeatureFlags.DEFAULT_FLAGS)
                )
        );
    }
}
