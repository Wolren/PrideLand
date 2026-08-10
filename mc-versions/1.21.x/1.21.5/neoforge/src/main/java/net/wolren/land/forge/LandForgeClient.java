package net.wolren.land.forge;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
import net.minecraft.client.render.entity.BoatEntityRenderer;
import net.minecraft.client.render.entity.model.BoatEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.wolren.land.LandCommon;
import net.wolren.land.ModelLayers;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;

public class LandForgeClient {
    public static void init() {
        LandCommon.LOGGER.info("Initializing Pride Land NeoForge client");

        // Render layers — blocks with transparency need cutout
        registerCutout(
                ModBlocks.RAINBOW_DOOR, ModBlocks.RAINBOW_TRAPDOOR,
                ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED, ModBlocks.NONBINARY_BED,
                ModBlocks.BISEXUAL_BED, ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED, ModBlocks.PROGRESS_PRIDE_BED,
                ModBlocks.ASEXUAL_BED, ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
                ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED, ModBlocks.GENDERQUEER_BED,
                ModBlocks.POLYSEXUAL_BED
        );
        registerTranslucent(
                ModBlocks.RAINBOW_STAINED_GLASS, ModBlocks.TRANS_STAINED_GLASS,
                ModBlocks.NONBINARY_STAINED_GLASS, ModBlocks.BISEXUAL_STAINED_GLASS,
                ModBlocks.PANSEXUAL_STAINED_GLASS, ModBlocks.AROMANTIC_STAINED_GLASS,
                ModBlocks.DEMISEXUAL_STAINED_GLASS, ModBlocks.AGENDER_STAINED_GLASS,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, ModBlocks.ASEXUAL_STAINED_GLASS,
                ModBlocks.GENDERFLUID_STAINED_GLASS, ModBlocks.LESBIAN_STAINED_GLASS,
                ModBlocks.DEMIBOY_STAINED_GLASS, ModBlocks.DEMIGIRL_STAINED_GLASS,
                ModBlocks.GENDERQUEER_STAINED_GLASS, ModBlocks.POLYSEXUAL_STAINED_GLASS
        );
        registerTranslucent(
                ModBlocks.RAINBOW_STAINED_GLASS_PANE, ModBlocks.TRANS_STAINED_GLASS_PANE,
                ModBlocks.NONBINARY_STAINED_GLASS_PANE, ModBlocks.BISEXUAL_STAINED_GLASS_PANE,
                ModBlocks.PANSEXUAL_STAINED_GLASS_PANE, ModBlocks.AROMANTIC_STAINED_GLASS_PANE,
                ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE, ModBlocks.AGENDER_STAINED_GLASS_PANE,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE, ModBlocks.ASEXUAL_STAINED_GLASS_PANE,
                ModBlocks.GENDERFLUID_STAINED_GLASS_PANE, ModBlocks.LESBIAN_STAINED_GLASS_PANE,
                ModBlocks.DEMIBOY_STAINED_GLASS_PANE, ModBlocks.DEMIGIRL_STAINED_GLASS_PANE,
                ModBlocks.GENDERQUEER_STAINED_GLASS_PANE, ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE
        );
        registerCutout(ModBlocks.RAINBOW_CANDLE);

        // Model layer definitions are registered in onRegisterLayerDefinitions
        // (RegisterLayerDefinitions fires during Minecraft construction, before the first
        // resource reload — registering here in client setup is too late in 1.21.4+).

        // Sign block entity renderers
        BlockEntityRendererFactories.register(LandForge.RAINBOW_SIGN_BE, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(LandForge.RAINBOW_HANGING_SIGN_BE, HangingSignBlockEntityRenderer::new);
        LandCommon.LOGGER.info("Registered sign block entity renderers");

        // Bed block entity renderers
        BlockEntityRendererRegistry.register(
                ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new
        );
    }

    /**
     * Register entity renderers via NeoForge's RegisterRenderers event.
     */
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::getTexturedModelData);
        event.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::getTexturedModelData);
        event.registerLayerDefinition(new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "boat/rainbow"), "main"), BoatEntityModel::getTexturedModelData);
        event.registerLayerDefinition(new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "chest_boat/rainbow"), "main"), BoatEntityModel::getChestTexturedModelData);
        LandCommon.LOGGER.info("Registered entity model layer definitions via event");
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        event.registerEntityRenderer(ModEntities.RAINBOW_BOAT_ENTITY, ctx -> new BoatEntityRenderer(ctx, new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "boat/rainbow"), "main")));
        event.registerEntityRenderer(ModEntities.RAINBOW_CHEST_BOAT_ENTITY, ctx -> new BoatEntityRenderer(ctx, new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, "chest_boat/rainbow"), "main")));
        LandCommon.LOGGER.info("Registered entity renderer for rainbow_sheep via event");
    }

    private static void registerCutout(Block... blocks) {
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getCutout());
        }
    }

    private static void registerTranslucent(Block... blocks) {
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getTranslucent());
        }
    }
}
