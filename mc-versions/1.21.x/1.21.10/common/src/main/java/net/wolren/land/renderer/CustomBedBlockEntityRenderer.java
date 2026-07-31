package net.wolren.land.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BedBlockEntityRenderState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity, BedBlockEntityRenderState> {
    private final Model.SinglePartModel bedHead;
    private final Model.SinglePartModel bedFoot;

    public CustomBedBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        Function<Identifier, RenderLayer> layerFactory = id -> RenderLayer.getEntityCutoutNoCull(id);
        this.bedHead = new Model.SinglePartModel(ctx.getLayerModelPart(EntityModelLayers.BED_HEAD), layerFactory);
        this.bedFoot = new Model.SinglePartModel(ctx.getLayerModelPart(EntityModelLayers.BED_FOOT), layerFactory);
    }

    public static TexturedModelData getHeadTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 6.0f), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(50, 6).cuboid(0.0f, 6.0f, 0.0f, 3.0f, 3.0f, 3.0f), ModelTransform.rotation(1.5707964f, 0.0f, 1.5707964f));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(50, 18).cuboid(-16.0f, 6.0f, 0.0f, 3.0f, 3.0f, 3.0f), ModelTransform.rotation(1.5707964f, 0.0f, (float)Math.PI));
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static TexturedModelData getFootTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 22).cuboid(0.0f, 0.0f, 0.0f, 16.0f, 16.0f, 6.0f), ModelTransform.NONE);
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(50, 0).cuboid(0.0f, 6.0f, -16.0f, 3.0f, 3.0f, 3.0f), ModelTransform.rotation(1.5707964f, 0.0f, 0.0f));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(50, 12).cuboid(-16.0f, 6.0f, -16.0f, 3.0f, 3.0f, 3.0f), ModelTransform.rotation(1.5707964f, 0.0f, 4.712389f));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public BedBlockEntityRenderState createRenderState() {
        return new BedBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(CustomBedBlockEntity blockEntity, BedBlockEntityRenderState state, float tickDelta, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderState.updateBlockEntityRenderState(blockEntity, state, crumblingOverlay);
        BlockState blockState = blockEntity.getCachedState();
        state.facing = blockState.get(CustomBedBlock.FACING);
        state.headPart = blockState.get(CustomBedBlock.PART) == net.minecraft.block.enums.BedPart.HEAD;
    }

    @Override
    public void render(BedBlockEntityRenderState state, MatrixStack matrices, net.minecraft.client.render.command.OrderedRenderCommandQueue queue, net.minecraft.client.render.state.CameraRenderState cameraState) {
        SpriteIdentifier spriteIdentifier = BedTextureProvider.getSpriteIdentifierForBed(state.blockState.getBlock());
        if (spriteIdentifier == null) return;

        Model.SinglePartModel part = state.headPart ? this.bedHead : this.bedFoot;
        RenderLayer renderLayer = spriteIdentifier.getRenderLayer(id -> RenderLayer.getEntityCutoutNoCull(id));
        int light = state.lightmapCoordinates;

        matrices.push();
        matrices.translate(0.0f, 0.5625f, !state.headPart ? -1.0f : 0.0f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0f));
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0f + Direction.getHorizontalDegreesOrThrow(state.facing)));
        matrices.translate(-0.5f, -0.5f, -0.5f);

        queue.submitModel(part, Unit.INSTANCE, matrices, renderLayer, light, 0, 0, state.crumblingOverlay);
        matrices.pop();
    }
}
