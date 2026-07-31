package net.wolren.land.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.wolren.land.ModelLayers;
import net.wolren.land.PrideLand;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;

@Environment(EnvType.CLIENT)
public class PrideLandFabricClient implements ClientModInitializer {

    static {
        ModelLayerRegistry.registerModelLayer(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::createBodyLayer);
        ModelLayerRegistry.registerModelLayer(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::createBodyLayer);
    }

    @Override
    public void onInitializeClient() {
        PrideLand.clientInit();

        // Screen
        MenuScreens.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        // Entity renderers
        EntityRendererRegistry.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        BlockEntityRendererRegistry.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new);
    }
}
