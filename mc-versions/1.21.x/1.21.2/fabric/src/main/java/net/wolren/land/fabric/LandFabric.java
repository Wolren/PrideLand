package net.wolren.land.fabric;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;

import com.terraformersmc.terraform.boat.api.item.TerraformBoatItemHelper;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
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
        ModItems.RAINBOW_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.RAINBOW_BOAT_ID, false);
        ModItems.RAINBOW_CHEST_BOAT = TerraformBoatItemHelper.registerBoatItem(ModBoats.RAINBOW_BOAT_ID, true);

        // Signs (Terraform API - Fabric only)
        registerRainbowSigns();

        // Entity attributes
        FabricDefaultAttributeRegistry.register(ModEntities.RAINBOW_SHEEP, createSheepAttributes());

        // Recipe type
        LandCommon.RAINBOW_CUTTING = Registry.register(
                Registries.RECIPE_TYPE,
                Identifier.of(LandCommon.MOD_ID, "rainbow_cutting"),
                new net.minecraft.recipe.RecipeType<>() {});

        // Biome spawning for rainbow sheep
        if (AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().enableRainbowSheepSpawning) {
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(
                            AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().activeSheepSpawnBiomes().stream()
                                    .map(s -> RegistryKey.of(RegistryKeys.BIOME, Identifier.of(s)))
                                    .toArray(RegistryKey[]::new)
                    ),
                    SpawnGroup.CREATURE,
                    ModEntities.RAINBOW_SHEEP,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepWeight,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepMinGroupSize,
                    AutoConfig.getConfigHolder(RainbowConfig.class).getConfig().sheepMaxGroupSize
            );
        }

        // Fuel registry


        // Screen handler type (vanilla registry in 1.21+)
        ModScreenHandlers.setBoxScreenHandler(
                Registry.register(
                        Registries.SCREEN_HANDLER,
                        Identifier.of(LandCommon.MOD_ID, "rainbow_workstation"),
                        new ScreenHandlerType<>((syncId, inventory) -> new RainbowCraftingScreenHandler(syncId, inventory), FeatureFlags.VANILLA_FEATURES)
                )
        );

        // Biome spawning
    }

    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.MAX_HEALTH, 8.0)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.23F);
    }

    private static void registerRainbowSigns() {
        Identifier signTexture = Identifier.of(LandCommon.MOD_ID, "entity/signs/rainbow");
        Identifier hangingSignTexture = Identifier.of(LandCommon.MOD_ID, "entity/signs/hanging/rainbow");
        Identifier hangingGuiTexture = Identifier.of(LandCommon.MOD_ID, "textures/gui/hanging_signs/rainbow");

        ModBlocks.RAINBOW_STANDING_SIGN = Registry.register(Registries.BLOCK,
                Identifier.of(LandCommon.MOD_ID, "rainbow_standing_sign"),
                new TerraformSignBlock(signTexture, Block.Settings.copy(Blocks.OAK_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LandCommon.MOD_ID, "rainbow_standing_sign")))));
        ModBlocks.RAINBOW_WALL_SIGN = Registry.register(Registries.BLOCK,
                Identifier.of(LandCommon.MOD_ID, "rainbow_wall_sign"),
                new TerraformWallSignBlock(signTexture, Block.Settings.copy(Blocks.OAK_WALL_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LandCommon.MOD_ID, "rainbow_wall_sign")))));
        ModBlocks.RAINBOW_HANGING_SIGN = Registry.register(Registries.BLOCK,
                Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                new TerraformHangingSignBlock(hangingSignTexture, hangingGuiTexture, Block.Settings.copy(Blocks.OAK_HANGING_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign")))));
        ModBlocks.RAINBOW_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK,
                Identifier.of(LandCommon.MOD_ID, "rainbow_wall_hanging_sign"),
                new TerraformWallHangingSignBlock(hangingSignTexture, hangingGuiTexture, Block.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LandCommon.MOD_ID, "rainbow_wall_hanging_sign")))));

        ModItems.RAINBOW_SIGN = (SignItem) Registry.register(Registries.ITEM, Identifier.of(LandCommon.MOD_ID, "rainbow_sign"),
                new SignItem(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN, new Item.Settings().maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LandCommon.MOD_ID, "rainbow_sign")))));
        ModItems.RAINBOW_HANGING_SIGN = (HangingSignItem) Registry.register(Registries.ITEM, Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN, new Item.Settings().maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign")))));

        // Spawn egg — entity types are registered before items on Fabric
        ModItems.RAINBOW_SHEEP_SPAWN_EGG = (SpawnEggItem) Registry.register(Registries.ITEM,
                Identifier.of(LandCommon.MOD_ID, "rainbow_sheep_spawn_egg"),
                new RainbowSpawnEggItem(ModEntities.RAINBOW_SHEEP, 0xFFFFFF, 0xFF69B4, new Item.Settings()));

        LandCommon.LOGGER.info("Registered rainbow signs via Terraform API");
    }
}
