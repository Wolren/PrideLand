package net.wolren.land.renderer.model;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.SheepRenderState;
import net.minecraft.util.Mth;

public class RainbowSheepWoolModel extends QuadrupedModel<SheepRenderState> {
    private float headRotationAngleX;

    public RainbowSheepWoolModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition root = meshDefinition.getRoot();

        root.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F,
                                new net.minecraft.client.model.geom.builders.CubeDeformation(0.6F)),
                PartPose.offset(0.0F, 6.0F, -8.0F));

        root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(36, 10)
                        .addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F,
                                new net.minecraft.client.model.geom.builders.CubeDeformation(1.75F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F));

        CubeListBuilder hindLegBuilder = CubeListBuilder.create().texOffs(18, 22)
                .addBox(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F,
                        new net.minecraft.client.model.geom.builders.CubeDeformation(0.5F));
        root.addOrReplaceChild("right_hind_leg", hindLegBuilder, PartPose.offset(-3.0F, 12.0F, 7.0F));
        root.addOrReplaceChild("left_hind_leg", hindLegBuilder, PartPose.offset(3.0F, 12.0F, 7.0F));

        CubeListBuilder frontLegBuilder = CubeListBuilder.create().texOffs(0, 22)
                .addBox(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F,
                        new net.minecraft.client.model.geom.builders.CubeDeformation(0.5F));
        root.addOrReplaceChild("right_front_leg", frontLegBuilder, PartPose.offset(-3.0F, 12.0F, -5.0F));
        root.addOrReplaceChild("left_front_leg", frontLegBuilder, PartPose.offset(3.0F, 12.0F, -5.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(SheepRenderState state) {
        super.setupAnim(state);
        this.head.y = 6.0F + state.headEatPositionScale * 9.0F;
        this.head.xRot = state.headEatAngleScale;
    }
}
