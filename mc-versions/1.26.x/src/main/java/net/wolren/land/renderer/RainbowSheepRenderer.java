package net.wolren.land.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SheepRenderState;
import net.minecraft.resources.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.feature.RainbowSheepFeatureRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;

public class RainbowSheepRenderer extends MobRenderer<MonoColorSheep.RainbowSheepEntity, SheepRenderState, RainbowSheepModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("pride_land", "textures/entity/sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererProvider.Context context) {
        super(context, new RainbowSheepModel(context.bakeLayer(ModelLayers.RAINBOW_SHEEP)), 0.7F);
        this.addLayer(new RainbowSheepFeatureRenderer(this, context.getModelSet()));
    }

    @Override
    public Identifier getTextureLocation(SheepRenderState state) {
        return TEXTURE;
    }

    @Override
    public SheepRenderState createRenderState() {
        return new SheepRenderState();
    }

    @Override
    public void extractRenderState(MonoColorSheep.RainbowSheepEntity entity, SheepRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.isSheared = entity.isSheared();
        state.headEatPositionScale = entity.getHeadEatPositionScale(partialTick);
        state.headEatAngleScale = entity.getHeadEatAngleScale(partialTick);
    }
}
