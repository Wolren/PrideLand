package net.wolren.land.renderer.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.client.render.entity.state.SheepEntityRenderState;

@Environment(EnvType.CLIENT)
public class RainbowSheepWoolModel extends QuadrupedEntityModel<SheepEntityRenderState> {
    private float headRotationAngleX;

    public RainbowSheepWoolModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("head",
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F,
                        new Dilation(0.6F)), ModelTransform.pivot(0.0F, 6.0F, -8.0F));

        modelPartData.addChild(
                "body",
                ModelPartBuilder.create().uv(36, 10).cuboid(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, new Dilation(1.75F)),
                ModelTransform.of(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );

        ModelPartBuilder hindLegModelPartBuilder = ModelPartBuilder.create().uv(18, 22).cuboid(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F));
        modelPartData.addChild("right_hind_leg", hindLegModelPartBuilder, ModelTransform.pivot(-3.0F, 12.0F, 7.0F));
        modelPartData.addChild("left_hind_leg", hindLegModelPartBuilder, ModelTransform.pivot(3.0F, 12.0F, 7.0F));
        ModelPartBuilder frontLegModelPartBuilder = ModelPartBuilder.create().uv(0, 22).cuboid(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.5F));
        modelPartData.addChild("right_front_leg", frontLegModelPartBuilder, ModelTransform.pivot(-3.0F, 12.0F, -5.0F));
        modelPartData.addChild("left_front_leg", frontLegModelPartBuilder, ModelTransform.pivot(3.0F, 12.0F, -5.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(SheepEntityRenderState state) {
        super.setAngles(state);
        head.pivotY = 6.0F + state.neckAngle * 9.0F;
        head.pitch = state.headAngle;
    }
}
