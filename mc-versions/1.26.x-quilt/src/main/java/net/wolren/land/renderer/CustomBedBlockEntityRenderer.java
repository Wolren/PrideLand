package net.wolren.land.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.sprite.SpriteGetter;
import net.minecraft.client.resources.model.sprite.SpriteId;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.phys.Vec3;
import net.wolren.land.ModelLayers;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;

@Environment(EnvType.CLIENT)
public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity, CustomBedBlockEntityRenderer.State> {

    private final ModelPart bedHead;
    private final ModelPart bedFoot;
    private final SpriteGetter sprites;

    public CustomBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.bedHead = ctx.bakeLayer(ModelLayers.CUSTOM_BED_HEAD);
        this.bedFoot = ctx.bakeLayer(ModelLayers.CUSTOM_BED_FOOT);
        this.sprites = ctx.sprites();
    }

    public static LayerDefinition getHeadTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 1.5707964F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 18).addBox(-16.0F, 6.0F, 0.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, (float) Math.PI));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition getFootTexturedModelData() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("main", CubeListBuilder.create().texOffs(0, 22).addBox(0.0F, 0.0F, 0.0F, 16.0F, 16.0F, 6.0F), PartPose.ZERO);
        partDefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(50, 12).addBox(-16.0F, 6.0F, -16.0F, 3.0F, 3.0F, 3.0F), PartPose.rotation(1.5707964F, 0.0F, 4.712389F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public State createRenderState() {
        return new State();
    }

    @Override
    public void extractRenderState(CustomBedBlockEntity blockEntity, State state, float partialTicks,
                                   Vec3 vec3,
                                   ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        state.material = BedTextureProvider.getSpriteIdentifierForBed(blockEntity.getBlockState().getBlock());
        state.direction = blockEntity.getBlockState().getValue(CustomBedBlock.FACING);
        state.bedPart = blockEntity.getBlockState().getValue(CustomBedBlock.PART);
    }

    @Override
    public void submit(State state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        ModelPart part = state.bedPart == BedPart.HEAD ? this.bedHead : this.bedFoot;
        boolean isFoot = state.bedPart == BedPart.FOOT;
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.5625F, isFoot ? -1.0F : 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + state.direction.toYRot()));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
        SpriteId spriteId = new SpriteId(TextureAtlas.LOCATION_BLOCKS, state.material);
        TextureAtlasSprite sprite = this.sprites.get(spriteId);
        submitNodeCollector.submitModelPart(part, poseStack,
                RenderTypes.entitySolid(TextureAtlas.LOCATION_BLOCKS),
                state.lightCoords, OverlayTexture.NO_OVERLAY, sprite);
        poseStack.popPose();
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

    public static class State extends BlockEntityRenderState {
        public Identifier material;
        public net.minecraft.core.Direction direction;
        public BedPart bedPart;
    }
}
