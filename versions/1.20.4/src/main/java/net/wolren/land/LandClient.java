package net.wolren.land;

import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.block.fuels.CustomFuelRegistry;
import net.wolren.land.entity.ModBoats;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItems;
import net.wolren.land.renderer.CustomBedBlockEntityRenderer;
import net.wolren.land.renderer.feature.CustomElytraFeatureRenderer;
import net.wolren.land.renderer.RainbowSheepRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;
import net.wolren.land.screen.ModScreenHandlers;
import net.wolren.land.screen.RainbowCraftingScreen;
import net.wolren.land.util.ModTags;


@Environment(EnvType.CLIENT)
public class LandClient implements ClientModInitializer {
    public static final EntityModelLayer RAINBOW_SHEEP_ENTITY_MODEL_LAYER;
    public static final EntityModelLayer RAINBOW_SHEEP_FUR_ENTITY_MODEL_LAYER;

    static {
        RAINBOW_SHEEP_ENTITY_MODEL_LAYER = registerEntityModelLayer("rainbow_sheep", RainbowSheepModel.getTexturedModelData());
        RAINBOW_SHEEP_FUR_ENTITY_MODEL_LAYER = registerEntityModelLayer("rainbow_sheep_fur", RainbowSheepWoolModel.getTexturedModelData());
    }

    public static EntityModelLayer registerEntityModelLayer(String registryName, TexturedModelData modelPart) {
        EntityModelLayer entityModelLayer = new EntityModelLayer(new Identifier(Land.MOD_ID, registryName), "rainbow_sheep");
        EntityModelLayerRegistry.registerModelLayer(entityModelLayer, () -> modelPart);
        return entityModelLayer;
    }

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.BOX_SCREEN_HANDLER, RainbowCraftingScreen::new);

        registerBedBlockRenderLayers();
        registerGlassBlockRenderLayers();

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_TRAPDOOR, RenderLayer.getCutout());

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.RAINBOW_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ModBlocks.RAINBOW_HANGING_SIGN_TEXTURE));

        registerCustomFuels();
        CustomFuelRegistry.linkCustomFuels();

        TerraformBoatClientHelper.registerModelLayers(ModBoats.RAINBOW_BOAT_ID, false);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register((entityType, entityRenderer, registrationHelper, context) -> {
            Identifier rainbowElytra = new Identifier("pride_land:textures/entity/rainbow_elytra.png");
            registrationHelper.register(new CustomElytraFeatureRenderer<>(entityRenderer, context.getModelLoader(), rainbowElytra));
        });

        EntityRendererRegistry.register(ModEntities.RAINBOW_SHEEP, RainbowSheepRenderer::new);

        BlockEntityRendererFactories.register(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlockEntityRenderer::new);
    }

    private static void registerBedBlockRenderLayers () {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_BED, RenderLayer.getCutout());
    }

    private static void registerGlassBlockRenderLayers () {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RAINBOW_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TRANS_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.NONBINARY_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BISEXUAL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PANSEXUAL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AROMANTIC_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AGENDER_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ASEXUAL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERFLUID_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LESBIAN_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIBOY_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEMIGIRL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GENDERQUEER_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_STAINED_GLASS, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POLYSEXUAL_STAINED_GLASS_PANE, RenderLayer.getTranslucent());
    }

    private static void registerCustomFuels() {
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.TRANS_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.NONBINARY_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.BISEXUAL_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.PANSEXUAL_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.AROMANTIC_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMISEXUAL_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.AGENDER_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.PROGRESS_PRIDE_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.ASEXUAL_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.GENDERFLUID_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.LESBIAN_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMIBOY_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMIGIRL_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.GENDERQUEER_WOOL.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.POLYSEXUAL_WOOL.asItem(), 100);

        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.TRANS_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.NONBINARY_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.BISEXUAL_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.PANSEXUAL_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.AROMANTIC_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMISEXUAL_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.AGENDER_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.PROGRESS_PRIDE_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.ASEXUAL_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.GENDERFLUID_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.LESBIAN_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMIBOY_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.DEMIGIRL_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.GENDERQUEER_CARPET.asItem(), 68);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.POLYSEXUAL_CARPET.asItem(), 68);

        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_CRAFTING.asItem(), 300);

        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_STAIRS.asItem(), 300);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_SLAB.asItem(), 150);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_FENCE.asItem(), 300);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_FENCE_GATE.asItem(), 300);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_BUTTON.asItem(), 100);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_PRESSURE_PLATE.asItem(), 150);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_DOOR.asItem(), 200);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_TRAPDOOR.asItem(), 200);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_STANDING_SIGN.asItem(), 200);
        CustomFuelRegistry.registerCustomFuel(ModBlocks.RAINBOW_HANGING_SIGN.asItem(), 800);
        CustomFuelRegistry.registerCustomFuel(ModItems.RAINBOW_BOAT.asItem(), 1200);
        CustomFuelRegistry.registerCustomFuel(ModItems.RAINBOW_CHEST_BOAT.asItem(), 1200);
        CustomFuelRegistry.registerCustomFuel(ModItems.RAINBOW_CHEST_BOAT.asItem(), 1200);
    }
}
