package net.wolren.land.fabric;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderSetup;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BedBlockEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.feature.CustomElytraFeatureRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;

@Environment(EnvType.CLIENT)
public class LandFabricClient implements ClientModInitializer {
    public static final EntityModelLayer RAINBOW_SHEEP_ENTITY_MODEL_LAYER;
    public static final EntityModelLayer RAINBOW_SHEEP_FUR_ENTITY_MODEL_LAYER;

    private static final RenderLayer CUTOUT_LAYER = RenderLayer.of("cutout", RenderSetup.builder(RenderPipelines.CUTOUT_BLOCK).build());
    private static final RenderLayer TRANSLUCENT_LAYER = RenderLayer.of("translucent", RenderSetup.builder(RenderPipelines.TRANSLUCENT).build());

    static {
        RAINBOW_SHEEP_ENTITY_MODEL_LAYER = registerEntityModelLayer("rainbow_sheep", RainbowSheepModel.getTexturedModelData());
        RAINBOW_SHEEP_FUR_ENTITY_MODEL_LAYER = registerEntityModelLayer("rainbow_sheep_fur", RainbowSheepWoolModel.getTexturedModelData());
    }

    public static EntityModelLayer registerEntityModelLayer(String registryName, net.minecraft.client.model.TexturedModelData modelPart) {
        EntityModelLayer entityModelLayer = new EntityModelLayer(Identifier.of(LandCommon.MOD_ID, registryName), "rainbow_sheep");
        EntityModelLayerRegistry.registerModelLayer(entityModelLayer, () -> modelPart);
        return entityModelLayer;
    }

    @Override
    public void onInitializeClient() {
        LandCommon.clientInit();

        // Screen
        HandledScreens.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        // Render layers
        registerBedBlockRenderLayers();
        registerGlassBlockRenderLayers();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_DOOR, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_TRAPDOOR, CUTOUT_LAYER);

        // Sign sprites — in 1.21+ Terraform handles sign textures via WoodType

        // Boat models
        TerraformBoatClientHelper.registerModelLayers(ModBoats.RAINBOW_BOAT_ID);

        // Elytra feature renderer
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            Identifier rainbowElytra = Identifier.of("pride_land", "textures/entity/rainbow_elytra.png");
            registrationHelper.register(new CustomElytraFeatureRenderer<>(entityRenderer, context.getModelLoader(), rainbowElytra));
        });

        // Entity renderers
        EntityRendererRegistry.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        BlockEntityRendererRegistry.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new);
    }

    private static void registerBedBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_BED, CUTOUT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_BED, CUTOUT_LAYER);
    }

    private static void registerGlassBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_STAINED_GLASS, TRANSLUCENT_LAYER);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE, TRANSLUCENT_LAYER);
    }
}
