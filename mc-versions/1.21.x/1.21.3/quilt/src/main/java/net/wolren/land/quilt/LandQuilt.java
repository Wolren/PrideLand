package net.wolren.land.quilt;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.BiomeKeys;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.ModItemGroups;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.util.config.RainbowConfig;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;

public class LandQuilt implements ModInitializer {
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

        // Boats (Terraform API - works through QFAPI)
        ModBoats.registerBoats();

        // Signs (Terraform API - works through QFAPI)
        registerRainbowSigns();

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


        // Screen handler type (simple, no extended data needed)
        ModScreenHandlers.setBoxScreenHandler(
                ScreenHandlerRegistry.registerSimple(
                        new Identifier(LandCommon.MOD_ID, "rainbow_workstation"),
                        (syncId, inventory) -> new RainbowCraftingScreenHandler(syncId, inventory))
        );
    }

    public static DefaultAttributeContainer.Builder createSheepAttributes() {
        return MobEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23F);
    }

    private static void registerRainbowSigns() {
        Identifier signTexture = new Identifier(LandCommon.MOD_ID, "entity/signs/rainbow");
        Identifier hangingSignTexture = new Identifier(LandCommon.MOD_ID, "entity/signs/hanging/rainbow");
        Identifier hangingGuiTexture = new Identifier(LandCommon.MOD_ID, "textures/gui/hanging_signs/rainbow");

        // Use FabricBlockSettings.create() with explicit properties instead of copyOf(Block)
        // because QFAPI's FabricBlockSettings only has copyOf(AbstractBlock.Settings)
        ModBlocks.RAINBOW_STANDING_SIGN = Registry.register(Registries.BLOCK,
                new Identifier(LandCommon.MOD_ID, "rainbow_standing_sign"),
                new TerraformSignBlock(signTexture, FabricBlockSettings.create().strength(1.0F).noCollision().nonOpaque()));
        ModBlocks.RAINBOW_WALL_SIGN = Registry.register(Registries.BLOCK,
                new Identifier(LandCommon.MOD_ID, "rainbow_wall_sign"),
                new TerraformWallSignBlock(signTexture, FabricBlockSettings.create().strength(1.0F).noCollision().nonOpaque()));
        ModBlocks.RAINBOW_HANGING_SIGN = Registry.register(Registries.BLOCK,
                new Identifier(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                new TerraformHangingSignBlock(hangingSignTexture, hangingGuiTexture, FabricBlockSettings.create().strength(1.0F).nonOpaque()));
        ModBlocks.RAINBOW_WALL_HANGING_SIGN = Registry.register(Registries.BLOCK,
                new Identifier(LandCommon.MOD_ID, "rainbow_wall_hanging_sign"),
                new TerraformWallHangingSignBlock(hangingSignTexture, hangingGuiTexture, FabricBlockSettings.create().strength(1.0F).nonOpaque()));

        ModItems.RAINBOW_SIGN = (SignItem) Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, "rainbow_sign"),
                new SignItem(new Item.Settings().maxCount(16), ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN));
        ModItems.RAINBOW_HANGING_SIGN = (HangingSignItem) Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN, new Item.Settings().maxCount(16)));

        // Spawn egg — entity types are registered before items on Fabric
        ModItems.RAINBOW_SHEEP_SPAWN_EGG = (SpawnEggItem) Registry.register(Registries.ITEM,
                new Identifier(LandCommon.MOD_ID, "rainbow_sheep_spawn_egg"),
                new RainbowSpawnEggItem(ModEntities.RAINBOW_SHEEP, 0xFFFFFF, 0xFF69B4, new Item.Settings()));

        LandCommon.LOGGER.info("Registered rainbow signs via Terraform API (Quilt)");
    }
}
