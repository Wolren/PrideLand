package net.wolren.land.forge;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodType;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.HangingSignItem;
import net.minecraft.item.Item;
import net.minecraft.item.SignItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.neoforged.neoforge.event.level.LevelEvent;
import net.minecraft.util.collection.Weighted;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.wolren.land.LandCommon;
import net.wolren.land.block.BlockItemQueue;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.BlockEntityTypeQueue;
import net.wolren.land.entity.EntityTypeQueue;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItemGroups;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.custom.RainbowSpawnEggItem;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.util.config.RainbowConfig;

import java.util.Set;

@Mod("pride_land")
public class LandForge {
    // WoodType for rainbow signs (registered during class init)
    private static final WoodType RAINBOW_WOOD_TYPE = WoodType.register(new WoodType(LandCommon.MOD_ID + ":rainbow", BlockSetType.OAK));

    // Custom block entity types for rainbow signs
    public static BlockEntityType<RainbowSignBlockEntity> RAINBOW_SIGN_BE;
    public static BlockEntityType<RainbowHangingSignBlockEntity> RAINBOW_HANGING_SIGN_BE;

    private final IEventBus modBus;

    public LandForge() {
        modBus = net.neoforged.fml.ModLoadingContext.get().getActiveContainer().getEventBus();

        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);
        modBus.addListener(this::entityAttributeCreation);
        modBus.addListener(LandForgeClient::onRegisterRenderers);
        // Register menu screens (HandledScreens.register is package-private in Yarn 1.21.11)
        modBus.addListener((net.neoforged.neoforge.client.event.RegisterMenuScreensEvent event) -> {
            event.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);
        });

        // Config
        AutoConfig.register(RainbowConfig.class, GsonConfigSerializer::new);
        NeoForge.EVENT_BUS.addListener(LandForge::onPotentialSpawns);

        // Register forge-native sign blocks/items
        modBus.addListener((RegisterEvent event) -> {
            var key = event.getRegistryKey();

            if (key.equals(RegistryKeys.BLOCK)) {
                ModBlocks.registerModBlocks();

                Identifier standingId = Identifier.of(LandCommon.MOD_ID, "rainbow_standing_sign");
                Block signBlock = Registry.register(Registries.BLOCK, standingId,
                        new RainbowStandingSignBlock(Block.Settings.copy(Blocks.OAK_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, standingId)), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_STANDING_SIGN = signBlock;

                Identifier wallSignId = Identifier.of(LandCommon.MOD_ID, "rainbow_wall_sign");
                Block wallSignBlock = Registry.register(Registries.BLOCK, wallSignId,
                        new RainbowWallSignBlock(Block.Settings.copy(Blocks.OAK_WALL_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, wallSignId)), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_WALL_SIGN = wallSignBlock;

                Identifier hangingId = Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign");
                Block hangingBlock = Registry.register(Registries.BLOCK, hangingId,
                        new RainbowHangingSignBlock(Block.Settings.copy(Blocks.OAK_HANGING_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, hangingId)), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_HANGING_SIGN = hangingBlock;

                Identifier wallHangingId = Identifier.of(LandCommon.MOD_ID, "rainbow_wall_hanging_sign");
                Block wallHangingBlock = Registry.register(Registries.BLOCK, wallHangingId,
                        new RainbowWallHangingSignBlock(Block.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN).registryKey(RegistryKey.of(RegistryKeys.BLOCK, wallHangingId)), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_WALL_HANGING_SIGN = wallHangingBlock;
            }

            if (key.equals(RegistryKeys.ITEM)) {
                ModItems.registerModItems();
                int blockItems = BlockItemQueue.PENDING.size();
                BlockItemQueue.PENDING.forEach(Runnable::run);
                BlockItemQueue.PENDING.clear();
                LandCommon.LOGGER.info("Registered items + " + blockItems + " block items");

                Identifier signItemId = Identifier.of(LandCommon.MOD_ID, "rainbow_sign");
                var signItem = new SignItem(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN, new Item.Settings().maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, signItemId)));
                Registry.register(Registries.ITEM, signItemId, signItem);
                ModItems.RAINBOW_SIGN = signItem;

                Identifier hangingSignItemId = Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign");
                var hangingSignItem = new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN,
                        ModBlocks.RAINBOW_WALL_HANGING_SIGN, new Item.Settings().maxCount(16).registryKey(RegistryKey.of(RegistryKeys.ITEM, hangingSignItemId)));
                Registry.register(Registries.ITEM, hangingSignItemId, hangingSignItem);
                ModItems.RAINBOW_HANGING_SIGN = hangingSignItem;
            }

            if (key.equals(RegistryKeys.ENTITY_TYPE)) {
                ModEntities.registerBlockEntities();
                EntityTypeQueue.PENDING.forEach(Runnable::run);
                EntityTypeQueue.PENDING.clear();
            }

            if (key.equals(RegistryKeys.BLOCK_ENTITY_TYPE)) {
                ModEntities.registerBlockEntities();
                BlockEntityTypeQueue.PENDING.forEach(Runnable::run);
                BlockEntityTypeQueue.PENDING.clear();

                RAINBOW_SIGN_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                        Identifier.of(LandCommon.MOD_ID, "rainbow_sign"),
                        new BlockEntityType<RainbowSignBlockEntity>(
                                RainbowSignBlockEntity::new,
                                Set.of(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN)
                        ));

                RAINBOW_HANGING_SIGN_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                        Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                        new BlockEntityType<RainbowHangingSignBlockEntity>(
                                RainbowHangingSignBlockEntity::new,
                                Set.of(ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN)
                        ));
            }

            if (key.equals(RegistryKeys.RECIPE_SERIALIZER)) {
                ModSerializers.registerCuttingSerializers();
            }

            if (key.equals(RegistryKeys.ITEM_GROUP)) {
                ModItemGroups.registerItemGroups();
            }

            if (key.equals(RegistryKeys.SCREEN_HANDLER)) {
                var type = new ScreenHandlerType<>((syncId, inventory) ->
                        new RainbowCraftingScreenHandler(syncId, inventory), FeatureFlags.VANILLA_FEATURES);
                Registry.register(Registries.SCREEN_HANDLER,
                        Identifier.of(LandCommon.MOD_ID, "box_screen"), type);
                ModScreenHandlers.setBoxScreenHandler(type);
            }
        });

        LandCommon.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LandCommon.LOGGER.info("NeoForge common setup");
    }

    private void entityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAINBOW_SHEEP, LandCommon.createRainbowSheepAttributes().build());
    }

    /**
     * Adds the rainbow sheep to natural creature spawns in the config-selected biomes.
     * Fires on the game bus during each chunk's natural spawn pass, so the config
     * weight/min/max apply live (the data-driven biome modifier JSON cannot read config).
     */
    public static void onPotentialSpawns(LevelEvent.PotentialSpawns event) {
        if (event.getMobCategory() != SpawnGroup.CREATURE) return;
        var config = AutoConfig.getConfigHolder(RainbowConfig.class).getConfig();
        if (!config.enableRainbowSheepSpawning) return;
        var biomeKey = event.getLevel().getBiome(event.getPos()).getKey().orElse(null);
        if (biomeKey != null && config.activeSheepSpawnBiomes().contains(biomeKey.getValue().toString())) {
            event.addSpawnerData(new Weighted<>(new SpawnSettings.SpawnEntry(ModEntities.RAINBOW_SHEEP,
                    config.sheepMinGroupSize, config.sheepMaxGroupSize), config.sheepWeight));
        }
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LandCommon.clientInit();
        LandForgeClient.init();
    }
}
