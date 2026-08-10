package net.wolren.land.forge;

import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import me.shedaniel.autoconfig.AutoConfig;
import net.wolren.land.LandCommon;
import net.wolren.land.util.config.RainbowConfig;
import net.wolren.land.ModelLayers;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;

@EventBusSubscriber(modid = LandCommon.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class LandForgeClient {
    public static void init() {
        LandCommon.LOGGER.info("Initializing Pride Land NeoForge client");

        // Render layers
        registerCutout(
            ModBlocks.RAINBOW_DOOR, ModBlocks.RAINBOW_TRAPDOOR,
            ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED, ModBlocks.NONBINARY_BED,
            ModBlocks.BISEXUAL_BED, ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
            ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED, ModBlocks.PROGRESS_PRIDE_BED,
            ModBlocks.ASEXUAL_BED, ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
            ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED, ModBlocks.GENDERQUEER_BED,
            ModBlocks.POLYSEXUAL_BED
        );
        registerCutout(ModBlocks.RAINBOW_CANDLE);
        registerTranslucent(
                ModBlocks.RAINBOW_STAINED_GLASS,
                ModBlocks.TRANS_STAINED_GLASS,
                ModBlocks.NONBINARY_STAINED_GLASS,
                ModBlocks.BISEXUAL_STAINED_GLASS,
                ModBlocks.PANSEXUAL_STAINED_GLASS,
                ModBlocks.AROMANTIC_STAINED_GLASS,
                ModBlocks.DEMISEXUAL_STAINED_GLASS,
                ModBlocks.AGENDER_STAINED_GLASS,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS,
                ModBlocks.ASEXUAL_STAINED_GLASS,
                ModBlocks.GENDERFLUID_STAINED_GLASS,
                ModBlocks.LESBIAN_STAINED_GLASS,
                ModBlocks.DEMIBOY_STAINED_GLASS,
                ModBlocks.DEMIGIRL_STAINED_GLASS,
                ModBlocks.GENDERQUEER_STAINED_GLASS,
                ModBlocks.POLYSEXUAL_STAINED_GLASS
        );
        registerTranslucent(
                ModBlocks.RAINBOW_STAINED_GLASS_PANE,
                ModBlocks.TRANS_STAINED_GLASS_PANE,
                ModBlocks.NONBINARY_STAINED_GLASS_PANE,
                ModBlocks.BISEXUAL_STAINED_GLASS_PANE,
                ModBlocks.PANSEXUAL_STAINED_GLASS_PANE,
                ModBlocks.AROMANTIC_STAINED_GLASS_PANE,
                ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE,
                ModBlocks.AGENDER_STAINED_GLASS_PANE,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE,
                ModBlocks.ASEXUAL_STAINED_GLASS_PANE,
                ModBlocks.GENDERFLUID_STAINED_GLASS_PANE,
                ModBlocks.LESBIAN_STAINED_GLASS_PANE,
                ModBlocks.DEMIBOY_STAINED_GLASS_PANE,
                ModBlocks.DEMIGIRL_STAINED_GLASS_PANE,
                ModBlocks.GENDERQUEER_STAINED_GLASS_PANE,
                ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE
        );

        // Config screen
        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
            (mc, screen) -> AutoConfig.getConfigScreen(RainbowConfig.class, screen).get()
        );
        LandCommon.LOGGER.info("Registered config screen factory");

        // Model layers
        net.neoforged.neoforge.client.ClientHooks.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::getTexturedModelData);
        net.neoforged.neoforge.client.ClientHooks.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::getTexturedModelData);

        // Sign layers are registered by the vanilla EntityModels.getModels for every registered WoodType
        // Boat model layers (client setup timing works in 1.21.3)
        EntityModelLayer rainbowBoatLayer = new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "boat/rainbow"), "main");
        net.neoforged.neoforge.client.ClientHooks.registerLayerDefinition(rainbowBoatLayer, BoatEntityModel::getTexturedModelData);
        EntityModelLayer rainbowChestBoatLayer = new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "chest_boat/rainbow"), "main");
        net.neoforged.neoforge.client.ClientHooks.registerLayerDefinition(rainbowChestBoatLayer, BoatEntityModel::getChestTexturedModelData);

        // Sign renderers
        BlockEntityRendererFactories.register(LandForge.RAINBOW_SIGN_BE, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(LandForge.RAINBOW_HANGING_SIGN_BE, HangingSignBlockEntityRenderer::new);

        // Bed renderers
        dev.architectury.registry.client.rendering.BlockEntityRendererRegistry.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
        event.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        EntityRendererFactory<MonoColorSheep.RainbowSheepEntity> factory = context -> new RainbowSheepRenderer(context);
        event.registerEntityRenderer(ModEntities.RAINBOW_SHEEP, factory);
        event.registerEntityRenderer(ModEntities.RAINBOW_BOAT_ENTITY, ctx -> new BoatEntityRenderer(ctx, new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "boat/rainbow"), "main")));
        event.registerEntityRenderer(ModEntities.RAINBOW_CHEST_BOAT_ENTITY, ctx -> new BoatEntityRenderer(ctx, new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "chest_boat/rainbow"), "main")));
    }

    private static void registerCutout(Block... blocks) {
        var layers = net.wolren.land.mixin.RenderLayersAccessor.prideLand$getBlocks();
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getCutout());
            layers.put(block, RenderLayer.getCutout());
        }
    }

    private static void registerTranslucent(Block... blocks) {
        var layers = net.wolren.land.mixin.RenderLayersAccessor.prideLand$getBlocks();
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getTranslucent());
            layers.put(block, RenderLayer.getTranslucent());
        }
    }
}
