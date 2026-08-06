package net.wolren.land;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;
import net.wolren.land.screen.RainbowCraftingScreenHandler;

@EventBusSubscriber(value = Dist.CLIENT, modid = PrideLand.MOD_ID)
public class PrideLandNeoForgeClient {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.RAINBOW_SHEEP.get(), RainbowSheepRenderer::new);
        event.registerBlockEntityRenderer(ModEntities.CUSTOM_BED_BLOCK_ENTITY.get(), CustomBedBlockEntityRenderer::new);
        // Boats (layers boat/rainbow + chest_boat/rainbow; textures entity/boat/rainbow.png etc)
        event.registerEntityRenderer(ModEntities.RAINBOW_BOAT.get(),
                context -> new BoatRenderer(context, ModBoats.RAINBOW_BOAT_LAYER));
        event.registerEntityRenderer(ModEntities.RAINBOW_CHEST_BOAT.get(),
                context -> new BoatRenderer(context, ModBoats.RAINBOW_CHEST_BOAT_LAYER));
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP, RainbowSheepModel::createBodyLayer);
        event.registerLayerDefinition(ModelLayers.RAINBOW_SHEEP_FUR, RainbowSheepWoolModel::createBodyLayer);
        // Boats
        event.registerLayerDefinition(ModBoats.RAINBOW_BOAT_LAYER, BoatModel::createBoatModel);
        event.registerLayerDefinition(ModBoats.RAINBOW_CHEST_BOAT_LAYER, BoatModel::createChestBoatModel);
    }

    @SubscribeEvent
    public static void onRegisterMenuScreens(RegisterMenuScreensEvent event) {
        event.register((MenuType<RainbowCraftingScreenHandler>) ModScreenHandlers.RAINBOW_CRAFTING_MENU.get(), RainbowCraftingScreen::new);
    }
}
