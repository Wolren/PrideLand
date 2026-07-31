package net.wolren.land.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.state.SheepEntityRenderState;
import net.minecraft.util.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.feature.RainbowSheepFeatureRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;


@Environment(EnvType.CLIENT)
public class RainbowSheepRenderer extends MobEntityRenderer<MonoColorSheep.RainbowSheepEntity, SheepEntityRenderState, RainbowSheepModel> {
    private static final Identifier TEXTURE = Identifier.of("pride_land:textures/entity/sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererFactory.Context context) {
        super(context, new RainbowSheepModel(context.getPart(ModelLayers.RAINBOW_SHEEP)), 0.7F);
        this.addFeature(new RainbowSheepFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(SheepEntityRenderState state) {
        return TEXTURE;
    }

    @Override
    public SheepEntityRenderState createRenderState() {
        return new SheepEntityRenderState();
    }

    @Override
    public void updateRenderState(MonoColorSheep.RainbowSheepEntity entity, SheepEntityRenderState state, float tickDelta) {
        super.updateRenderState(entity, state, tickDelta);
        state.sheared = entity.isSheared();
        state.neckAngle = entity.getNeckAngle(tickDelta);
        state.headAngle = entity.getHeadAngle(tickDelta);
    }
}
