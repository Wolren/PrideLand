package net.wolren.land.renderer.feature;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.custom.CustomElytraItem;

import java.util.HashMap;
import java.util.Map;

public class CustomElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final ResourceLocation defaultElytraTexture;
    public final ElytraModel<T> elytra;
    private final Map<Item, ResourceLocation> elytraTextures;

    public CustomElytraFeatureRenderer(RenderLayerParent<T, M> context, EntityModelSet loader, ResourceLocation defaultElytraTexture) {
        super(context);
        this.defaultElytraTexture = defaultElytraTexture;
        this.elytraTextures = new HashMap<>();
        this.elytraTextures.put(ModItems.RAINBOW_ELYTRA, new ResourceLocation("pride_land:textures/entity/rainbow_elytra.png"));
        this.elytraTextures.put(ModItems.AGENDER_ELYTRA, new ResourceLocation("pride_land:textures/entity/agender_elytra.png"));
        this.elytraTextures.put(ModItems.AROMANTIC_ELYTRA, new ResourceLocation("pride_land:textures/entity/aromantic_elytra.png"));
        this.elytraTextures.put(ModItems.ASEXUAL_ELYTRA, new ResourceLocation("pride_land:textures/entity/asexual_elytra.png"));
        this.elytraTextures.put(ModItems.BISEXUAL_ELYTRA, new ResourceLocation("pride_land:textures/entity/bisexual_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIBOY_ELYTRA, new ResourceLocation("pride_land:textures/entity/demiboy_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIGIRL_ELYTRA, new ResourceLocation("pride_land:textures/entity/demigirl_elytra.png"));
        this.elytraTextures.put(ModItems.DEMISEXUAL_ELYTRA, new ResourceLocation("pride_land:textures/entity/demisexual_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERFLUID_ELYTRA, new ResourceLocation("pride_land:textures/entity/genderfluid_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERQUEER_ELYTRA, new ResourceLocation("pride_land:textures/entity/genderqueer_elytra.png"));
        this.elytraTextures.put(ModItems.LESBIAN_ELYTRA, new ResourceLocation("pride_land:textures/entity/lesbian_elytra.png"));
        this.elytraTextures.put(ModItems.NONBINARY_ELYTRA, new ResourceLocation("pride_land:textures/entity/nonbinary_elytra.png"));
        this.elytraTextures.put(ModItems.PANSEXUAL_ELYTRA, new ResourceLocation("pride_land:textures/entity/pansexual_elytra.png"));
        this.elytraTextures.put(ModItems.POLYSEXUAL_ELYTRA, new ResourceLocation("pride_land:textures/entity/polysexual_elytra.png"));
        this.elytraTextures.put(ModItems.PROGRESS_PRIDE_ELYTRA, new ResourceLocation("pride_land:textures/entity/progress_pride_elytra.png"));
        this.elytraTextures.put(ModItems.TRANS_ELYTRA, new ResourceLocation("pride_land:textures/entity/trans_elytra.png"));

        this.elytra = new ElytraModel<>(loader.bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(
            PoseStack matrixStack, MultiBufferSource vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l
    ) {
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if (itemStack.getItem() instanceof CustomElytraItem) {
            ResourceLocation elytraTexture = this.elytraTextures.getOrDefault(itemStack.getItem(), this.defaultElytraTexture);
            matrixStack.pushPose();
            matrixStack.translate(0.0F, 0.0F, 0.125F);
            this.getParentModel().copyPropertiesTo(this.elytra);
            this.elytra.setupAnim(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorFoilBuffer(
                    vertexConsumerProvider, RenderType.armorCutoutNoCull(elytraTexture), false, itemStack.hasFoil()
            );
            this.elytra.renderToBuffer(matrixStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }
    }
}
