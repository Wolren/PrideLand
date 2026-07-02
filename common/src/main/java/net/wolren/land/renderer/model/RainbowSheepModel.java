package net.wolren.land.renderer.model;

import net.minecraft.client.model.QuadrupedModel;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartNames;
import net.wolren.land.entity.custom.living.MonoColorSheep;

public class RainbowSheepModel<T extends MonoColorSheep> extends SheepModel<T> {

    public RainbowSheepModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition meshDefinition = QuadrupedModel.createBodyMesh(12, CubeDeformation.NONE);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild(PartNames.HEAD,
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F),
                PartPose.offset(0.0F, 6.0F, -8.0F));
        partDefinition.addOrReplaceChild(PartNames.BODY,
                CubeListBuilder.create().texOffs(36, 10).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
