package net.wolren.land.forge;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.SignBlockEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderers;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.ModLoadingContext;
import me.shedaniel.autoconfig.AutoConfig;
import net.wolren.land.LandCommon;
import net.wolren.land.util.config.RainbowConfig;
import net.wolren.land.ModelLayers;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;

public class LandForgeClient {
    public static void init() {
        LandCommon.LOGGER.info("Initializing Pride Land Forge client");

        MenuRegistry.registerScreenFactory(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        registerCutout(
                ModBlocks.RAINBOW_DOOR, ModBlocks.RAINBOW_TRAPDOOR,
                ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED, ModBlocks.NONBINARY_BED,
                ModBlocks.BISEXUAL_BED, ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED, ModBlocks.PROGRESS_PRIDE_BED,
                ModBlocks.ASEXUAL_BED, ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
                ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED, ModBlocks.GENDERQUEER_BED,
                ModBlocks.POLYSEXUAL_BED
        );
        registerCutout(
                ModBlocks.RAINBOW_STAINED_GLASS, ModBlocks.TRANS_STAINED_GLASS,
                ModBlocks.NONBINARY_STAINED_GLASS, ModBlocks.BISEXUAL_STAINED_GLASS,
                ModBlocks.PANSEXUAL_STAINED_GLASS, ModBlocks.AROMANTIC_STAINED_GLASS,
                ModBlocks.DEMISEXUAL_STAINED_GLASS, ModBlocks.AGENDER_STAINED_GLASS,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, ModBlocks.ASEXUAL_STAINED_GLASS,
                ModBlocks.GENDERFLUID_STAINED_GLASS, ModBlocks.LESBIAN_STAINED_GLASS,
                ModBlocks.DEMIBOY_STAINED_GLASS, ModBlocks.DEMIGIRL_STAINED_GLASS,
                ModBlocks.GENDERQUEER_STAINED_GLASS, ModBlocks.POLYSEXUAL_STAINED_GLASS
        );
        registerCutout(
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

        // No additional mod (Configured, etc.) is needed; Forge 1.20.1 natively reads ConfigScreenHandler.ConfigScreenFactory extension points.
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (mc, screen) -> AutoConfig.getConfigScreen(RainbowConfig.class, screen).get()
                )
        );
        LandCommon.LOGGER.info("Registered config screen factory");

        ForgeHooksClient.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::getTexturedModelData);
        ForgeHooksClient.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::getTexturedModelData);
        LandCommon.LOGGER.info("Registered entity model layer definitions");

        EntityRenderers.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        LandCommon.LOGGER.info("Registered entity renderer for rainbow_sheep");

        BlockEntityRendererFactories.register(LandForge.RAINBOW_SIGN_BE, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(LandForge.RAINBOW_HANGING_SIGN_BE, SignBlockEntityRenderer::new);
        LandCommon.LOGGER.info("Registered sign block entity renderers");

        BlockEntityRendererRegistry.register(
                ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new
        );
    }

    private static void registerCutout(net.minecraft.block.Block... blocks) {
        for (var block : blocks) {
            RenderTypeRegistry.register(RenderLayer.getCutout(), block);
        }
    }
}
