package net.wolren.land.renderer.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.SheepRenderState;

@Environment(EnvType.CLIENT)
public class RainbowSheepModel extends net.minecraft.client.model.SheepModel<SheepRenderState> {

    public RainbowSheepModel(ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = SheepModel.createBodyMesh();
        PartDefinition root = meshDefinition.getRoot();

        root.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, -6.0F, 6.0F, 6.0F, 8.0F),
                PartPose.offset(0.0F, 6.0F, -8.0F));
        root.addOrReplaceChild("body",
                CubeListBuilder.create().texOffs(36, 10).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 16.0F, 6.0F),
                PartPose.offsetAndRotation(0.0F, 5.0F, 2.0F, (float) (Math.PI / 2), 0.0F, 0.0F));

        return LayerDefinition.create(meshDefinition, 64, 32);
    }
}
