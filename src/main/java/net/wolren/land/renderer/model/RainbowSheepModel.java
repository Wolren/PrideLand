package net.wolren.land.renderer.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.wolren.land.entity.custom.living.MonoColorSheep;

@Environment(EnvType.CLIENT)
public class RainbowSheepModel<T extends MonoColorSheep> extends SheepEntityModel<T> {

    public RainbowSheepModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = QuadrupedEntityModel.getModelData(12, Dilation.NONE);
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild(EntityModelPartNames.HEAD,
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F),
                ModelTransform.pivot(0.0F, 6.0F, -8.0F));
        modelPartData.addChild(EntityModelPartNames.BODY,
                ModelPartBuilder.create().uv(36, 10).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F),
                ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
}
