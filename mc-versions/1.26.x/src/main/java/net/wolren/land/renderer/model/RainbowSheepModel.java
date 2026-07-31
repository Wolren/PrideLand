package net.wolren.land.renderer.model;

import net.minecraft.client.model.animal.sheep.SheepModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;

public class RainbowSheepModel extends SheepModel {

    public RainbowSheepModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        return SheepModel.createBodyLayer();
    }
}
