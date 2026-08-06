package net.wolren.land.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.resources.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.PrideLand;
import net.wolren.land.entity.ModBoats;
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
        // Bed renders via block models (vanilla 26.2 approach) - no entity renderer needed.
        // Boats: model layers boat/rainbow + chest_boat/rainbow; textures entity/boat/rainbow.png
        // and entity/chest_boat/rainbow.png are derived from the layer location by BoatRenderer.
        ModelLayerRegistry.registerModelLayer(
                new ModelLayerLocation(ModBoats.RAINBOW_BOAT_ID.withPrefix("boat/"), "main"),
                BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(
                new ModelLayerLocation(ModBoats.RAINBOW_BOAT_ID.withPrefix("chest_boat/"), "main"),
                BoatModel::createChestBoatModel);
    }

    @Override
    public void onInitializeClient() {
        PrideLand.clientInit();

        // Screen
        MenuScreens.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        // Entity renderers
        EntityRendererRegistry.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        // Bed renders via block models (vanilla 26.2 approach) - no entity renderer needed.
        // Boats
        EntityRendererRegistry.register(ModBoats.RAINBOW_BOAT_ENTITY,
                context -> new BoatRenderer(context, new ModelLayerLocation(
                        ModBoats.RAINBOW_BOAT_ID.withPrefix("boat/"), "main")));
        EntityRendererRegistry.register(ModBoats.RAINBOW_CHEST_BOAT_ENTITY,
                context -> new BoatRenderer(context, new ModelLayerLocation(
                        ModBoats.RAINBOW_BOAT_ID.withPrefix("chest_boat/"), "main")));
    }
}
