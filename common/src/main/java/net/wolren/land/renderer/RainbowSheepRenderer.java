package net.wolren.land.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.wolren.land.ModelLayers;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.feature.RainbowSheepFeatureRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;

public class RainbowSheepRenderer extends MobRenderer<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("pride_land:textures/entity/sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererProvider.Context context) {
        super(context, new RainbowSheepModel<>(context.bakeLayer(ModelLayers.RAINBOW_SHEEP)), 0.7F);
        this.addLayer(new RainbowSheepFeatureRenderer(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(MonoColorSheep.RainbowSheepEntity entity) {
        return TEXTURE;
    }
}
