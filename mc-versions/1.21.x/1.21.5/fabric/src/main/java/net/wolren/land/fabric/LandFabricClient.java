package net.wolren.land.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.api.SpriteIdentifierRegistry;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.block.ModBlocks;
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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_TRAPDOOR, RenderLayer.getCutout());



        // Sign sprites
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(
            TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
            Identifier.of(LandCommon.MOD_ID, "entity/signs/rainbow")
        ));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(
            TexturedRenderLayers.SIGNS_ATLAS_TEXTURE,
            Identifier.of(LandCommon.MOD_ID, "entity/signs/hanging/rainbow")
        ));

        // Boat models
        TerraformBoatClientHelper.registerModelLayers(ModBoats.RAINBOW_BOAT_ID);

        // Elytra feature renderer
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            Identifier rainbowElytra = Identifier.of("pride_land", "textures/entity/rainbow_elytra.png");
            var renderer = new CustomElytraFeatureRenderer(
                (net.minecraft.client.render.entity.feature.FeatureRendererContext) entityRenderer,
                context.getEntityModels(), rainbowElytra);
            @SuppressWarnings({"unchecked", "rawtypes"})
            net.minecraft.client.render.entity.feature.FeatureRenderer castRenderer = (net.minecraft.client.render.entity.feature.FeatureRenderer) renderer;
            registrationHelper.register(castRenderer);
        });

        // Entity renderers
        EntityRendererRegistry.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);
        BlockEntityRendererRegistry.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new);
    }

    private static void registerBedBlockRenderLayers() {
        Block[] beds = {
            ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED, ModBlocks.NONBINARY_BED,
            ModBlocks.BISEXUAL_BED, ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
            ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED, ModBlocks.PROGRESS_PRIDE_BED,
            ModBlocks.ASEXUAL_BED, ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
            ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED, ModBlocks.GENDERQUEER_BED,
            ModBlocks.POLYSEXUAL_BED
        };
        for (Block bed : beds) {
            BlockRenderLayerMap.INSTANCE.putBlock(bed, RenderLayer.getCutout());
        }
    }

    private static void registerGlassBlockRenderLayers() {
        Block[] glasses = {
            ModBlocks.RAINBOW_STAINED_GLASS, ModBlocks.RAINBOW_STAINED_GLASS_PANE,
            ModBlocks.TRANS_STAINED_GLASS, ModBlocks.TRANS_STAINED_GLASS_PANE,
            ModBlocks.NONBINARY_STAINED_GLASS, ModBlocks.NONBINARY_STAINED_GLASS_PANE,
            ModBlocks.BISEXUAL_STAINED_GLASS, ModBlocks.BISEXUAL_STAINED_GLASS_PANE,
            ModBlocks.PANSEXUAL_STAINED_GLASS, ModBlocks.PANSEXUAL_STAINED_GLASS_PANE,
            ModBlocks.AROMANTIC_STAINED_GLASS, ModBlocks.AROMANTIC_STAINED_GLASS_PANE,
            ModBlocks.DEMISEXUAL_STAINED_GLASS, ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE,
            ModBlocks.AGENDER_STAINED_GLASS, ModBlocks.AGENDER_STAINED_GLASS_PANE,
            ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE,
            ModBlocks.ASEXUAL_STAINED_GLASS, ModBlocks.ASEXUAL_STAINED_GLASS_PANE,
            ModBlocks.GENDERFLUID_STAINED_GLASS, ModBlocks.GENDERFLUID_STAINED_GLASS_PANE,
            ModBlocks.LESBIAN_STAINED_GLASS, ModBlocks.LESBIAN_STAINED_GLASS_PANE,
            ModBlocks.DEMIBOY_STAINED_GLASS, ModBlocks.DEMIBOY_STAINED_GLASS_PANE,
            ModBlocks.DEMIGIRL_STAINED_GLASS, ModBlocks.DEMIGIRL_STAINED_GLASS_PANE,
            ModBlocks.GENDERQUEER_STAINED_GLASS, ModBlocks.GENDERQUEER_STAINED_GLASS_PANE,
            ModBlocks.POLYSEXUAL_STAINED_GLASS, ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE
        };
        for (Block glass : glasses) {
            BlockRenderLayerMap.INSTANCE.putBlock(glass, RenderLayer.getTranslucent());
        }
    }
}