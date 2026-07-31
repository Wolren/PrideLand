package net.wolren.land.renderer.feature;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SheepRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import com.mojang.blaze3d.vertex.PoseStack;
import net.wolren.land.ModelLayers;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

public class RainbowSheepFeatureRenderer extends RenderLayer<SheepRenderState, RainbowSheepModel> {
    private static final Identifier SKIN = Identifier.fromNamespaceAndPath("pride_land", "textures/entity/sheep/rainbow_sheep_fur.png");
    private final EntityModel<SheepRenderState> model;

    public RainbowSheepFeatureRenderer(RenderLayerParent<SheepRenderState, RainbowSheepModel> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new RainbowSheepWoolModel(modelSet.bakeLayer(ModelLayers.RAINBOW_SHEEP_FUR));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector collector, int light, SheepRenderState state, float partialTick, float ageInTicks) {
        if (!state.isSheared && !state.isInvisible) {
            poseStack.pushPose();
            if (state.isBaby) {
                poseStack.scale(0.5F, 0.5F, 0.5F);
                poseStack.translate(0.0F, 24.0F / 16.0F, 0.0F);
            }
            collector.submitModel(this.model, state, poseStack, RenderTypes.entityCutout(SKIN), light,
                    LivingEntityRenderer.getOverlayCoords(state, 0.0F), -1, null);
            poseStack.popPose();
        }
    }
}
