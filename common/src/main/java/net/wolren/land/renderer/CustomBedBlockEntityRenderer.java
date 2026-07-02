package net.wolren.land.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartNames;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;

public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity> {
    private final ModelPart bedHead;
    private final ModelPart bedFoot;

    public CustomBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.bedHead = ctx.bakeLayer(ModelLayers.BED_HEAD);
        this.bedFoot = ctx.bakeLayer(ModelLayers.BED_FOOT);
    }

    public static LayerDefinition getHeadTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 6.0f), PartPose.ZERO);
        partDefinition.addOrReplaceChild(PartNames.LEFT_LEG, CubeListBuilder.create().texOffs(50, 6).addBox(0.0f, 6.0f, 0.0f, 3.0f, 3.0f, 3.0f), PartPose.rotation(1.5707964f, 0.0f, 1.5707964f));
        partDefinition.addOrReplaceChild(PartNames.RIGHT_LEG, CubeListBuilder.create().texOffs(50, 18).addBox(-16.0f, 6.0f, 0.0f, 3.0f, 3.0f, 3.0f), PartPose.rotation(1.5707964f, 0.0f, (float)Math.PI));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition getFootTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 6.0f), PartPose.ZERO);
        partDefinition.addOrReplaceChild(PartNames.LEFT_LEG, CubeListBuilder.create().texOffs(50, 0).addBox(0.0f, 6.0f, -16.0f, 3.0f, 3.0f, 3.0f), PartPose.rotation(1.5707964f, 0.0f, 0.0f));
        partDefinition.addOrReplaceChild(PartNames.RIGHT_LEG, CubeListBuilder.create().texOffs(50, 12).addBox(-16.0f, 6.0f, -16.0f, 3.0f, 3.0f, 3.0f), PartPose.rotation(1.5707964f, 0.0f, 4.712389f));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void render(CustomBedBlockEntity customBedBlockEntity, float f, PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, int j) {
        Material spriteIdentifier = BedTextureProvider.getSpriteIdentifierForBed(customBedBlockEntity.getBlockState().getBlock());
        Level world2 = customBedBlockEntity.getLevel();
        if (world2 != null) {
            BlockState blockState = customBedBlockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<CustomBedBlockEntity> propertySource = DoubleBlockCombiner.combineWithNeigbour(ModEntities.CUSTOM_BED_BLOCK_ENTITY, CustomBedBlock::getBedPart, CustomBedBlock::getOppositePartDirection, ChestBlock.FACING, blockState, world2, customBedBlockEntity.getBlockPos(), (world, pos) -> false);
            int k = propertySource.apply(new BrightnessCombiner<>()).get(i);
            this.renderPart(matrixStack, vertexConsumerProvider, blockState.getValue(CustomBedBlock.PART) == BedPart.HEAD ? this.bedHead : this.bedFoot, blockState.getValue(CustomBedBlock.FACING), spriteIdentifier, k, j, false);
        } else {
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedHead, Direction.SOUTH, spriteIdentifier, i, j, false);
            this.renderPart(matrixStack, vertexConsumerProvider, this.bedFoot, Direction.SOUTH, spriteIdentifier, i, j, true);
        }
    }

    private void renderPart(PoseStack matrices, MultiBufferSource vertexConsumers, ModelPart part, Direction direction, Material sprite, int light, int overlay, boolean isFoot) {
        matrices.pushPose();
        matrices.translate(0.0f, 0.5625f, isFoot ? -1.0f : 0.0f);
        matrices.mulPose(Axis.XP.rotationDegrees(90.0f));
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.mulPose(Axis.ZP.rotationDegrees(180.0f + direction.toYRot()));
        matrices.translate(-0.5f, -0.5f, -0.5f);
        VertexConsumer vertexConsumer = sprite.buffer(vertexConsumers, RenderType::entitySolid);
        part.render(matrices, vertexConsumer, light, overlay);
        matrices.popPose();
    }
}
