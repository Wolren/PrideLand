package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wolren.land.LandClient;
import net.wolren.land.entity.RainbowSheepEntity;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

@Environment(EnvType.CLIENT)
public class RainbowSheepFeatureRenderer extends FeatureRenderer<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> {
    private static final Identifier SKIN = new Identifier("pride_land:textures/entity/sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel<RainbowSheepEntity> model;

    public RainbowSheepFeatureRenderer(FeatureRendererContext<RainbowSheepEntity, RainbowSheepModel<RainbowSheepEntity>> context, EntityModelLoader loader) {
        super(context);
        this.model = new RainbowSheepWoolModel<>(loader.getModelPart(LandClient.RAINBOW_SHEEP_FUR_ENTITY_MODEL_LAYER));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, RainbowSheepEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!entity.isSheared() && !entity.isInvisible()) {
            float f = 0.9019608F;
            float f1 = 0.9019608F;
            float f2 = 0.9019608F;
            render(getContextModel(), model, SKIN, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, f, f1, f2);
        }
    }
}
