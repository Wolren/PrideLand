package net.wolren.land.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.util.BedTextureProvider;

@Environment(EnvType.CLIENT)
public class CustomBedBlockEntityRenderer implements BlockEntityRenderer<CustomBedBlockEntity> {
    private final net.minecraft.client.renderer.blockentity.BedRenderer bedRenderer;

    public CustomBedBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.bedRenderer = new net.minecraft.client.renderer.blockentity.BedRenderer(ctx);
    }

    @Override
    public void render(CustomBedBlockEntity blockEntity, float partialTick, net.minecraft.client.renderer.MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Material material = BedTextureProvider.getSpriteIdentifierForBed(blockEntity.getBlockState().getBlock());
        if (material == null) return;
        // Delegate to vanilla bed renderer with our material
        // Note: We use the vanilla BedRenderer but customize the sprite
        this.bedRenderer.render(blockEntity, partialTick, bufferSource, packedLight, packedOverlay);
    }

    @Override
    public int getViewDistance() {
        return 256;
    }
}
