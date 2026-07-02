package net.wolren.land.renderer.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.wolren.land.ModelLayers;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

public class RainbowSheepFeatureRenderer extends RenderLayer<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> {
    private static final ResourceLocation SKIN = new ResourceLocation("pride_land:textures/entity/sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel<MonoColorSheep.RainbowSheepEntity> model;

    public RainbowSheepFeatureRenderer(RenderLayerParent<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> context, EntityModelSet loader) {
        super(context);
        this.model = new RainbowSheepWoolModel<>(loader.bakeLayer(ModelLayers.RAINBOW_SHEEP_FUR));
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, int light, MonoColorSheep.RainbowSheepEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!entity.isSheared() && !entity.isInvisible()) {
            float f = 0.9019608F;
            float f1 = 0.9019608F;
            float f2 = 0.9019608F;
            coloredCutoutModelCopyLayerRender(getParentModel(), model, SKIN, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, f, f1, f2);
        }
    }
}
