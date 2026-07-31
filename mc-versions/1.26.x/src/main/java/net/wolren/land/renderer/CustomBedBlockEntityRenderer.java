package net.wolren.land.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;

public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity, CustomBedBlockEntityRenderer.State> {

    public CustomBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
    }

    @Override
    public State createRenderState() {
        return new State();
    }

    @Override
    public void extractRenderState(CustomBedBlockEntity blockEntity, State state, float partialTicks,
                                   net.minecraft.world.phys.Vec3 vec3,
                                   net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay crumblingOverlay) {
        state.material = BedTextureProvider.getSpriteIdentifierForBed(blockEntity.getBlockState().getBlock());
        state.direction = blockEntity.getBlockState().getValue(CustomBedBlock.FACING);
        state.bedPart = blockEntity.getBlockState().getValue(CustomBedBlock.PART);
    }

    @Override
    public void submit(State state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        // Bed rendering is handled by the vanilla bed block renderer in MC 26.2
    }

    @Override
    public int getViewDistance() {
        return 256;
    }

    public static class State extends BlockEntityRenderState {
        public Identifier material;
        public Direction direction;
        public net.minecraft.world.level.block.state.properties.BedPart bedPart;
    }
}
