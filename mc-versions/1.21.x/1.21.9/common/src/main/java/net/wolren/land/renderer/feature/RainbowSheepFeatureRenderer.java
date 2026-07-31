package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.entity.state.SheepEntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

@Environment(EnvType.CLIENT)
public class RainbowSheepFeatureRenderer extends FeatureRenderer<SheepEntityRenderState, RainbowSheepModel> {
    private static final Identifier SKIN = Identifier.of("pride_land:textures/entity/sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel model;

    public RainbowSheepFeatureRenderer(FeatureRendererContext<SheepEntityRenderState, RainbowSheepModel> context, LoadedEntityModels loader) {
        super(context);
        this.model = new RainbowSheepWoolModel(loader.getModelPart(ModelLayers.RAINBOW_SHEEP_FUR));
    }

    @Override
    public void render(MatrixStack matrices, net.minecraft.client.render.command.OrderedRenderCommandQueue queue, int light, SheepEntityRenderState state, float limbAngle, float limbDistance) {
        if (!state.sheared && !state.invisible) {
            render(this.model, SKIN, matrices, queue, light, state, -1, -1);
        }
    }
}
