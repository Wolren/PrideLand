package net.wolren.land.forge;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.HangingSignBlockEntityRenderer;
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

        // Screen — crafting table GUI
        MenuRegistry.registerScreenFactory(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        // Render layers — blocks with transparency need a transparent layer.
        // NOTE: Architectury's RenderTypeRegistry silently no-ops on Forge+Yarn
        // in this dev setup, so these use Forge's direct RenderLayers API.
        // Glass + panes MUST be TRANSLUCENT (semi-alpha textures: cutout only
        // discards fully-transparent pixels and renders the rest opaque) —
        // matching the registerTranslucent fix used on the NeoForge clients.
        registerCutout(
                ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED, ModBlocks.NONBINARY_BED,
                ModBlocks.BISEXUAL_BED, ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED, ModBlocks.PROGRESS_PRIDE_BED,
                ModBlocks.ASEXUAL_BED, ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
                ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED, ModBlocks.GENDERQUEER_BED,
                ModBlocks.POLYSEXUAL_BED
        );
        registerTranslucentDirect(
                ModBlocks.RAINBOW_STAINED_GLASS, ModBlocks.TRANS_STAINED_GLASS,
                ModBlocks.NONBINARY_STAINED_GLASS, ModBlocks.BISEXUAL_STAINED_GLASS,
                ModBlocks.PANSEXUAL_STAINED_GLASS, ModBlocks.AROMANTIC_STAINED_GLASS,
                ModBlocks.DEMISEXUAL_STAINED_GLASS, ModBlocks.AGENDER_STAINED_GLASS,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, ModBlocks.ASEXUAL_STAINED_GLASS,
                ModBlocks.GENDERFLUID_STAINED_GLASS, ModBlocks.LESBIAN_STAINED_GLASS,
                ModBlocks.DEMIBOY_STAINED_GLASS, ModBlocks.DEMIGIRL_STAINED_GLASS,
                ModBlocks.GENDERQUEER_STAINED_GLASS, ModBlocks.POLYSEXUAL_STAINED_GLASS
        );
        registerTranslucentDirect(
                ModBlocks.RAINBOW_STAINED_GLASS_PANE, ModBlocks.TRANS_STAINED_GLASS_PANE,
                ModBlocks.NONBINARY_STAINED_GLASS_PANE, ModBlocks.BISEXUAL_STAINED_GLASS_PANE,
                ModBlocks.PANSEXUAL_STAINED_GLASS_PANE, ModBlocks.AROMANTIC_STAINED_GLASS_PANE,
                ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE, ModBlocks.AGENDER_STAINED_GLASS_PANE,
                ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE, ModBlocks.ASEXUAL_STAINED_GLASS_PANE,
                ModBlocks.GENDERFLUID_STAINED_GLASS_PANE, ModBlocks.LESBIAN_STAINED_GLASS_PANE,
                ModBlocks.DEMIBOY_STAINED_GLASS_PANE, ModBlocks.DEMIGIRL_STAINED_GLASS_PANE,
                ModBlocks.GENDERQUEER_STAINED_GLASS_PANE, ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE
        );
        registerCutoutDirect(ModBlocks.RAINBOW_DOOR, ModBlocks.RAINBOW_TRAPDOOR, ModBlocks.RAINBOW_CANDLE);

        // Config screen — register Cloth Config screen with Forge's mod list,
        // so a Config button appears for our mod in the mod list screen.
        // No additional mod (Configured, etc.) is needed; Forge 1.20.1 natively
        // reads ConfigScreenHandler.ConfigScreenFactory extension points.
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (mc, screen) -> AutoConfig.getConfigScreen(RainbowConfig.class, screen).get()
                )
        );
        LandCommon.LOGGER.info("Registered config screen factory");

        // Model layer definitions — register directly using Forge's static API.
        // Do NOT rely on EntityRenderersEvent.RegisterLayerDefinitions: in this
        // Yarn-mapped Architectury dev environment the event may not reach our
        // mod bus listener due to bus wiring order. Registering direct static calls
        // ensures the data is available when the model loader runs.
        ForgeHooksClient.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::getTexturedModelData);
        ForgeHooksClient.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::getTexturedModelData);
        LandCommon.LOGGER.info("Registered entity model layer definitions");

        // Entity renderers — register directly to avoid silent drop with
        // Architectury's EntityRendererRegistry on Forge+Yarn.
        EntityRenderers.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        LandCommon.LOGGER.info("Registered entity renderer for rainbow_sheep");

        // Sign block entity renderers — register directly (same issue as entity renderers).
        // Hanging signs need their own renderer: the vanilla SignBlockEntityRenderer draws
        // the standing sign model/texture, so using it for the hanging BE made hanging
        // signs inherit the standing sign's texture (fixed in later versions by class).
        BlockEntityRendererFactories.register(LandForge.RAINBOW_SIGN_BE, SignBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(LandForge.RAINBOW_HANGING_SIGN_BE, HangingSignBlockEntityRenderer::new);
        LandCommon.LOGGER.info("Registered sign block entity renderers");

        // Bed block entity renderers — use Architectury's API (works fine for block entities)
        BlockEntityRendererRegistry.register(
                ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new
        );
    }

    private static void registerCutout(net.minecraft.block.Block... blocks) {
        for (var block : blocks) {
            RenderTypeRegistry.register(RenderLayer.getCutout(), block);
        }
    }

    private static void registerCutoutDirect(net.minecraft.block.Block... blocks) {
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getCutout());
        }
    }

    private static void registerTranslucentDirect(net.minecraft.block.Block... blocks) {
        for (var block : blocks) {
            RenderLayers.setRenderLayer(block, RenderLayer.getTranslucent());
        }
    }
}
