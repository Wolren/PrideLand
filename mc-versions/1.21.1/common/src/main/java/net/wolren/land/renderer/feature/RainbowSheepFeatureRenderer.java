package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

@Environment(EnvType.CLIENT)
public class RainbowSheepFeatureRenderer extends FeatureRenderer<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> {
    private static final Identifier SKIN = Identifier.of("pride_land", "textures/entity/sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel<MonoColorSheep.RainbowSheepEntity> model;

    public RainbowSheepFeatureRenderer(FeatureRendererContext<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> context, EntityModelLoader loader) {
        super(context);
        this.model = new RainbowSheepWoolModel<>(loader.getModelPart(ModelLayers.RAINBOW_SHEEP_FUR));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, MonoColorSheep.RainbowSheepEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (!entity.isSheared() && !entity.isInvisible()) {
            int color = 0xFFE6E6E6;
            render(getContextModel(), model, SKIN, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch, tickDelta, color);
        }
    }
}
