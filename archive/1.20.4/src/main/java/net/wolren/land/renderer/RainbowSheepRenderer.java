package net.wolren.land.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wolren.land.LandClient;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import net.wolren.land.renderer.feature.RainbowSheepFeatureRenderer;
import net.wolren.land.renderer.model.RainbowSheepModel;


@Environment(EnvType.CLIENT)
public class RainbowSheepRenderer extends MobEntityRenderer<MonoColorSheep.RainbowSheepEntity, RainbowSheepModel<MonoColorSheep.RainbowSheepEntity>> {
    private static final Identifier TEXTURE = new Identifier("pride_land:textures/entity/sheep/rainbow_sheep.png");

    public RainbowSheepRenderer(EntityRendererFactory.Context context) {
        super(context, new RainbowSheepModel<>(context.getPart(LandClient.RAINBOW_SHEEP_ENTITY_MODEL_LAYER)), 0.7F);
        this.addFeature(new RainbowSheepFeatureRenderer(this, context.getModelLoader()));
    }

    @Override
    public Identifier getTexture(MonoColorSheep.RainbowSheepEntity entity) {
        return TEXTURE;
    }
}