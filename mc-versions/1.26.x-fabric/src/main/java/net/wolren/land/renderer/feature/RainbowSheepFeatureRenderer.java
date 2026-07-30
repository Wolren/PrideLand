package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.SheepFurModel;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.client.renderer.entity.state.SheepRenderState;
import net.minecraft.resources.Identifier;
import net.wolren.land.ModelLayers;
import net.wolren.land.renderer.model.RainbowSheepModel;
import net.wolren.land.renderer.model.RainbowSheepWoolModel;

@Environment(EnvType.CLIENT)
public class RainbowSheepFeatureRenderer extends SheepFurLayer<SheepRenderState, RainbowSheepModel> {
    private static final Identifier SKIN = Identifier.fromNamespaceAndPath("pride_land", "textures/entity/sheep/rainbow_sheep_fur.png");
    private final RainbowSheepWoolModel model;

    public RainbowSheepFeatureRenderer(net.minecraft.client.renderer.entity.RenderLayerParent<SheepRenderState, RainbowSheepModel> renderer, net.minecraft.client.model.geom.EntityModelSet modelSet) {
        super(renderer, modelSet);
        this.model = new RainbowSheepWoolModel(modelSet.bakeLayer(ModelLayers.RAINBOW_SHEEP_FUR));
    }

    @Override
    public void render(net.minecraft.client.gui.GuiGraphics guiGraphics, net.minecraft.client.renderer.entity.state.SheepRenderState state, int packedLight, float partialTick, float limbSwing, float limbSwingAmount) {
        if (!state.sheared && !state.isInvisible) {
            // We override render to use our custom model and texture
            renderColoredLayer(guiGraphics.getPose().last().pose(), guiGraphics, packedLight, state, -1, SKIN, this.model);
        }
    }
}
