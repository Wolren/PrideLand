package net.wolren.land.renderer.model;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartNames;
import net.wolren.land.entity.custom.living.MonoColorSheep;

public class RainbowSheepWoolModel<T extends MonoColorSheep.RainbowSheepEntity> extends QuadrupedModel<T> {
    private float headRotationAngleX;

    public RainbowSheepWoolModel(ModelPart root) {
        super(root, false, 8.0F, 4.0F, 2.0F, 2.0F, 24);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(PartNames.HEAD,
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -4.0F, 6.0F, 6.0F, 6.0F,
                        new CubeDeformation(0.6F)), PartPose.offset(0.0F, 6.0F, -8.0F));

        partDefinition.addOrReplaceChild(
                PartNames.BODY,
                CubeListBuilder.create().texOffs(36, 10).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F, new CubeDeformation(1.75F)),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
        );

        CubeListBuilder hindLegModelPartBuilder = CubeListBuilder.create().texOffs(18, 22).addBox(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F));
        partDefinition.addOrReplaceChild(PartNames.RIGHT_HIND_LEG, hindLegModelPartBuilder, PartPose.offset(-3.0F, 12.0F, 7.0F));
        partDefinition.addOrReplaceChild(PartNames.LEFT_HIND_LEG, hindLegModelPartBuilder, PartPose.offset(3.0F, 12.0F, 7.0F));
        CubeListBuilder frontLegModelPartBuilder = CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F));
        partDefinition.addOrReplaceChild(PartNames.RIGHT_FRONT_LEG, frontLegModelPartBuilder, PartPose.offset(-3.0F, 12.0F, -5.0F));
        partDefinition.addOrReplaceChild(PartNames.LEFT_FRONT_LEG, frontLegModelPartBuilder, PartPose.offset(3.0F, 12.0F, -5.0F));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
        head.y = 6.0F + entityIn.getHeadEatPositionScale(partialTick) * 9.0F;
        headRotationAngleX = entityIn.getHeadEatAngleScale(partialTick);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        head.xRot = headRotationAngleX;
    }
}
