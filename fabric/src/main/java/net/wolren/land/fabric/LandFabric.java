package net.wolren.land.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.biome.BiomeKeys;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.block.fuels.CustomFuelRegistry;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.ModItemGroups;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.util.config.RainbowConfig;

public class LandFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LandCommon.init();

        // Config
        AutoConfig.register(RainbowConfig.class, GsonConfigSerializer::new);

        // Registrations
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();
        ModSerializers.registerCuttingSerializers();

        // Boats (Terraform API - Fabric only)
        ModBoats.registerBoats();

        // Entity attributes
        FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_SHEEP, createSheepAttributes());

        // Recipe type
        LandCommon.RAINBOW_CUTTING = net.minecraft.recipe.RecipeType.register(LandCommon.MOD_ID + ":rainbow_cutting");

        // Biome spawning for rainbow sheep
        if (AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().enableRainbowSheepSpawning) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(
                            BiomeKeys.PLAINS, BiomeKeys.FOREST, BiomeKeys.FLOWER_FOREST,
                            BiomeKeys.SUNFLOWER_PLAINS, BiomeKeys.BIRCH_FOREST
                    ),
                    SpawnGroup.CREATURE,
                    ModEntities.RAINBOW_SHEEP,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepWeight,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepMinGroupSize,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepMaxGroupSize
            );
        }

        // Fuel registry
        CustomFuelRegistry.getCustomFuels().forEach((item, burnTime) ->
            FuelRegistry.INSTANCE.add(item, burnTime)
        );

        // Screen handler type (Fabric ExtendedScreenHandlerType)
        ModScreenHandlers.setBoxScreenHandler(
                Registry.register(Registries.SCREEN_HANDLER, new Identifier(LandCommon.MOD_ID, "rainbow_workstation"),
                        new ExtendedScreenHandlerType<>(RainbowCraftingScreenHandler::new))
        );

        // Biome spawning
    }

    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F);
    }
}
