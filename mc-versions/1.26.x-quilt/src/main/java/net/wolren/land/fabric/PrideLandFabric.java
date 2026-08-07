package net.wolren.land.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityTypes;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.block.fuels.CustomFuelRegistry;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.item.ModCreativeModeTabs;
import net.wolren.land.item.ModItems;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.util.ModTags;
import net.wolren.land.util.config.RainbowConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

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

        // Sign blocks use the shared vanilla SIGN/HANGING_SIGN block entity
        // types - register them as valid blocks or placement crashes with
        // "Invalid block entity minecraft:sign ... got Block{pride_land:...}"
        ((FabricBlockEntityType) BlockEntityTypes.SIGN).addValidBlock(ModBlocks.RAINBOW_STANDING_SIGN);
        ((FabricBlockEntityType) BlockEntityTypes.SIGN).addValidBlock(ModBlocks.RAINBOW_WALL_SIGN);
        ((FabricBlockEntityType) BlockEntityTypes.HANGING_SIGN).addValidBlock(ModBlocks.RAINBOW_HANGING_SIGN);
        ((FabricBlockEntityType) BlockEntityTypes.HANGING_SIGN).addValidBlock(ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        // Boats (Terraform API - Fabric only, basic setup)
        ModBoats.registerBoats();

        // Entity attributes for rainbow sheep (26.2: createMobAttributes is
        // the Mob base; the animal+sheep chain uses createAnimalAttributes /
        // Sheep.createAttributes which include tempt_range for TemptGoal)
        FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_SHEEP, Sheep.createAttributes()
                .add(Attributes.MAX_HEALTH, 8.0)
                .add(Attributes.MOVEMENT_SPEED, 0.23F));

        // Recipe type (26.2: RecipeType.register(String) no longer parses
        // namespaces - register via the registry with an Identifier)
        PrideLand.RAINBOW_CUTTING = Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_cutting"),
                new net.minecraft.world.item.crafting.RecipeType<net.wolren.land.recipe.RainbowCuttingRecipe>() {
                });

        // Biome spawning for rainbow sheep (config-gated)
        AutoConfig.register(RainbowConfig.class, GsonConfigSerializer::new);
        RainbowConfig config = AutoConfig.getConfigHolder(RainbowConfig.class).get();
        if (config.enableRainbowSheepSpawning) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(
                            config.activeSheepSpawnBiomes().stream()
                                    .map(s -> ResourceKey.create(Registries.BIOME, Identifier.parse(s)))
                                    .toArray(ResourceKey[]::new)
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
