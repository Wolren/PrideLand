package net.wolren.land.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BedBlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.texture.SpriteHolder;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Unit;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity, BedBlockEntityRenderState> {
    private final SpriteHolder materials;
    private final Model.SinglePartModel bedHead;
    private final Model.SinglePartModel bedFoot;

    public CustomBedBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.materials = ctx.spriteHolder();
        this.bedHead = new Model.SinglePartModel(ctx.getLayerModelPart(EntityModelLayers.BED_HEAD), RenderLayer::getEntitySolid);
        this.bedFoot = new Model.SinglePartModel(ctx.getLayerModelPart(EntityModelLayers.BED_FOOT), RenderLayer::getEntitySolid);
    }

    public static TexturedModelData getHeadTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), ModelTransform.NONE);
        modelPartData.addChild(
            EntityModelPartNames.LEFT_LEG,
            ModelPartBuilder.create().uv(50, 6).cuboid(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F),
            ModelTransform.rotation((float) (Math.PI / 2), 0.0F, (float) (Math.PI / 2))
        );
        modelPartData.addChild(
            EntityModelPartNames.RIGHT_LEG,
            ModelPartBuilder.create().uv(50, 18).cuboid(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F),
            ModelTransform.rotation((float) (Math.PI / 2), 0.0F, (float) Math.PI)
        );
        return TexturedModelData.of(modelData, 64, 64);
    }

    public static TexturedModelData getFootTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("main", ModelPartBuilder.create().uv(0, 22).cuboid(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), ModelTransform.NONE);
        modelPartData.addChild(
            EntityModelPartNames.LEFT_LEG,
            ModelPartBuilder.create().uv(50, 0).cuboid(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F),
            ModelTransform.rotation((float) (Math.PI / 2), 0.0F, 0.0F)
        );
        modelPartData.addChild(
            EntityModelPartNames.RIGHT_LEG,
            ModelPartBuilder.create().uv(50, 12).cuboid(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F),
            ModelTransform.rotation((float) (Math.PI / 2), 0.0F, (float) (Math.PI * 3.0 / 2.0))
        );
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public BedBlockEntityRenderState createRenderState() {
        return new BedBlockEntityRenderState();
    }

    @Override
    public void updateRenderState(
        CustomBedBlockEntity blockEntity,
        BedBlockEntityRenderState state,
        float tickDelta,
        Vec3d cameraPos,
        @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay
    ) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickDelta, cameraPos, crumblingOverlay);
        BlockState blockState = blockEntity.getCachedState();
        state.blockState = blockState;
        state.facing = blockState.get(CustomBedBlock.FACING);
        state.headPart = blockState.get(CustomBedBlock.PART) == net.minecraft.block.enums.BedPart.HEAD;
    }

    @Override
    public void render(
        BedBlockEntityRenderState state,
        MatrixStack matrices,
        OrderedRenderCommandQueue queue,
        CameraRenderState cameraState
    ) {
        BlockState blockState = state.blockState;
        if (blockState == null) return;
        SpriteIdentifier spriteIdentifier = BedTextureProvider.getSpriteIdentifierForBed(blockState.getBlock());
        if (spriteIdentifier == null) return;
        this.renderPart(
            matrices,
            queue,
            state.headPart ? this.bedHead : this.bedFoot,
            state.facing,
            spriteIdentifier,
            state.lightmapCoordinates,
            OverlayTexture.DEFAULT_UV,
            false,
            state.crumblingOverlay,
            0
        );
    }

    private void renderPart(
        MatrixStack matrices,
        OrderedRenderCommandQueue queue,
        Model.SinglePartModel model,
        Direction direction,
        SpriteIdentifier spriteId,
        int light,
        int overlay,
        boolean isFoot,
        @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay,
        int i
    ) {
        matrices.push();
        setTransforms(matrices, isFoot, direction);
        queue.submitModel(
            model,
            Unit.INSTANCE,
            matrices,
            spriteId.getRenderLayer(RenderLayer::getEntitySolid),
            light,
            overlay,
            -1,
            this.materials.getSprite(spriteId),
            i,
            crumblingOverlay
        );
        matrices.pop();
    }

    private static void setTransforms(MatrixStack matrices, boolean isFoot, Direction direction) {
        matrices.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));
        matrices.translate(0.5F, 0.5F, 0.5F);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180.0F + direction.getPositiveHorizontalDegrees()));
        matrices.translate(-0.5F, -0.5F, -0.5F);
    }
}
