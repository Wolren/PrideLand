package net.wolren.land.forge;

import dev.architectury.platform.forge.EventBuses;
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
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;
import net.wolren.land.LandCommon;
import net.wolren.land.block.BlockItemQueue;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.BlockEntityTypeQueue;
import net.wolren.land.entity.EntityTypeQueue;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItemGroups;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreenHandler;
import net.wolren.land.util.config.RainbowConfig;

@Mod("pride_land")
public class LandForge {
    // WoodType for rainbow signs (registered during class init)
    // Namespace-qualified name so the renderer looks up textures in the mod's namespace
    private static final WoodType RAINBOW_WOOD_TYPE = WoodType.register(new WoodType(LandCommon.MOD_ID + ":rainbow", BlockSetType.OAK));
    
    // Custom block entity types for rainbow signs
    public static BlockEntityType<RainbowSignBlockEntity> RAINBOW_SIGN_BE;
    public static BlockEntityType<RainbowHangingSignBlockEntity> RAINBOW_HANGING_SIGN_BE;

    private final IEventBus modBus;

    public LandForge() {
        modBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus("pride_land", modBus);

        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);
        modBus.addListener(this::entityAttributeCreation);

        // Config — Cloth Config / AutoConfig shared with Fabric
        AutoConfig.register(RainbowConfig.class, GsonConfigSerializer::new);
        MinecraftForge.EVENT_BUS.addListener(LandForge::onPotentialSpawns);

        // Natural spawning is handled via Forge's data-driven biome modifier JSON
        // (data/pride_land/forge/biome_modifier/add_rainbow_sheep_spawns.json) +
        // a runtime filter that reads config values.
        MinecraftForge.EVENT_BUS.addListener(LandForge::onMobSpawnPositionCheck);

        // Register forge-native sign blocks/items
        modBus.addListener((RegisterEvent event) -> {
            var key = event.getRegistryKey();

            if (key.equals(RegistryKeys.BLOCK)) {
                ModBlocks.registerModBlocks();

                // Forge-native sign blocks with custom block entity support
                Block signBlock = Registry.register(Registries.BLOCK,
                        new Identifier(LandCommon.MOD_ID, "rainbow_standing_sign"),
                        new RainbowStandingSignBlock(Block.Settings.copy(Blocks.OAK_SIGN), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_STANDING_SIGN = signBlock;

                Block wallSignBlock = Registry.register(Registries.BLOCK,
                        new Identifier(LandCommon.MOD_ID, "rainbow_wall_sign"),
                        new RainbowWallSignBlock(Block.Settings.copy(Blocks.OAK_WALL_SIGN), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_WALL_SIGN = wallSignBlock;

                Block hangingBlock = Registry.register(Registries.BLOCK,
                        new Identifier(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                        new RainbowHangingSignBlock(Block.Settings.copy(Blocks.OAK_HANGING_SIGN), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_HANGING_SIGN = hangingBlock;

                Block wallHangingBlock = Registry.register(Registries.BLOCK,
                        new Identifier(LandCommon.MOD_ID, "rainbow_wall_hanging_sign"),
                        new RainbowWallHangingSignBlock(Block.Settings.copy(Blocks.OAK_WALL_HANGING_SIGN), RAINBOW_WOOD_TYPE));
                ModBlocks.RAINBOW_WALL_HANGING_SIGN = wallHangingBlock;
            }

            if (key.equals(RegistryKeys.ITEM)) {
                ModItems.registerModItems();
                int blockItems = BlockItemQueue.PENDING.size();
                BlockItemQueue.PENDING.forEach(Runnable::run);
                BlockItemQueue.PENDING.clear();
                LandCommon.LOGGER.info("Registered items + " + blockItems + " block items");

                // Spawn egg — ForgeSpawnEggItem uses a lazy supplier. Forge patches
                // SpawnEggItem.getType(ItemStack) to call getDefaultType(), which
                // ForgeSpawnEggItem overrides to return typeSupplier.get().
                var egg = new ForgeSpawnEggItem(() -> ModEntities.RAINBOW_SHEEP, 0xFFFFFF, 0xFF69B4, new Item.Settings());
                Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, "rainbow_sheep_spawn_egg"), egg);
                ModItems.RAINBOW_SHEEP_SPAWN_EGG = (SpawnEggItem) egg;

                // Forge-native sign items
                var signItem = new SignItem(new Item.Settings().maxCount(16),
                        ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN);
                Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, "rainbow_sign"), signItem);
                ModItems.RAINBOW_SIGN = signItem;

                var hangingSignItem = new HangingSignItem(ModBlocks.RAINBOW_HANGING_SIGN,
                        ModBlocks.RAINBOW_WALL_HANGING_SIGN, new Item.Settings().maxCount(16));
                Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, "rainbow_hanging_sign"), hangingSignItem);
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

                // Custom sign block entity types
                RAINBOW_SIGN_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                        new Identifier(LandCommon.MOD_ID, "rainbow_sign"),
                        BlockEntityType.Builder.create(RainbowSignBlockEntity::new,
                                ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN).build(null));

                RAINBOW_HANGING_SIGN_BE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                        new Identifier(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                        BlockEntityType.Builder.create(RainbowHangingSignBlockEntity::new,
                                ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN).build(null));
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
                        new Identifier(LandCommon.MOD_ID, "box_screen"), type);
                ModScreenHandlers.setBoxScreenHandler(type);
            }
        });

        LandCommon.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LandCommon.LOGGER.info("Forge common setup");
    }

    private void entityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAINBOW_SHEEP, LandCommon.createRainbowSheepAttributes().build());
    }

    /**
     * Runtime spawn filter for rainbow sheep.
     * The JSON biome modifier always registers the spawn entry with generous values;
     * this runtime gate applies the actual config settings.
     * Fires on the game bus (MinecraftForge.EVENT_BUS) during natural spawning.
     */
    public static void onMobSpawnPositionCheck(MobSpawnEvent.PositionCheck event) {
        if (event.getEntity().getType() == ModEntities.RAINBOW_SHEEP) {
            var config = AutoConfig.getConfigHolder(RainbowConfig.class).getConfig();
            if (!config.enableRainbowSheepSpawning) {
                event.setResult(Event.Result.DENY);
            }
        }
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
            event.addSpawnerData(new SpawnSettings.SpawnEntry(ModEntities.RAINBOW_SHEEP,
                    config.sheepWeight,
                    config.sheepMinGroupSize,
                    config.sheepMaxGroupSize));
        }
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LandCommon.clientInit();
        LandForgeClient.init();
    }
}
