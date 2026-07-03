package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.custom.CustomElytraItem;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class CustomElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    private final Identifier defaultElytraTexture;
    public final ElytraEntityModel<T> elytra;
    private final Map<Item, Identifier> elytraTextures;

    public CustomElytraFeatureRenderer(FeatureRendererContext<T, M> context, EntityModelLoader loader, Identifier defaultElytraTexture) {
        super(context);
        this.defaultElytraTexture = defaultElytraTexture;
        this.elytraTextures = new HashMap<>();
        this.elytraTextures.put(ModItems.RAINBOW_ELYTRA, new Identifier("pride_land:textures/entity/rainbow_elytra.png"));
        this.elytraTextures.put(ModItems.AGENDER_ELYTRA, new Identifier("pride_land:textures/entity/agender_elytra.png"));
        this.elytraTextures.put(ModItems.AROMANTIC_ELYTRA, new Identifier("pride_land:textures/entity/aromantic_elytra.png"));
        this.elytraTextures.put(ModItems.ASEXUAL_ELYTRA, new Identifier("pride_land:textures/entity/asexual_elytra.png"));
        this.elytraTextures.put(ModItems.BISEXUAL_ELYTRA, new Identifier("pride_land:textures/entity/bisexual_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIBOY_ELYTRA, new Identifier("pride_land:textures/entity/demiboy_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIGIRL_ELYTRA, new Identifier("pride_land:textures/entity/demigirl_elytra.png"));
        this.elytraTextures.put(ModItems.DEMISEXUAL_ELYTRA, new Identifier("pride_land:textures/entity/demisexual_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERFLUID_ELYTRA, new Identifier("pride_land:textures/entity/genderfluid_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERQUEER_ELYTRA, new Identifier("pride_land:textures/entity/genderqueer_elytra.png"));
        this.elytraTextures.put(ModItems.LESBIAN_ELYTRA, new Identifier("pride_land:textures/entity/lesbian_elytra.png"));
        this.elytraTextures.put(ModItems.NONBINARY_ELYTRA, new Identifier("pride_land:textures/entity/nonbinary_elytra.png"));
        this.elytraTextures.put(ModItems.PANSEXUAL_ELYTRA, new Identifier("pride_land:textures/entity/pansexual_elytra.png"));
        this.elytraTextures.put(ModItems.POLYSEXUAL_ELYTRA, new Identifier("pride_land:textures/entity/polysexual_elytra.png"));
        this.elytraTextures.put(ModItems.PROGRESS_PRIDE_ELYTRA, new Identifier("pride_land:textures/entity/progress_pride_elytra.png"));
        this.elytraTextures.put(ModItems.TRANS_ELYTRA, new Identifier("pride_land:textures/entity/trans_elytra.png"));

        this.elytra = new ElytraEntityModel<>(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(
            MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l
    ) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.getItem() instanceof CustomElytraItem) {
            Identifier elytraTexture = this.elytraTextures.getOrDefault(itemStack.getItem(), this.defaultElytraTexture);
            matrixStack.push();
            matrixStack.translate(0.0F, 0.0F, 0.125F);
            this.getContextModel().copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getArmorGlintConsumer(
                    vertexConsumerProvider, RenderLayer.getArmorCutoutNoCull(elytraTexture), false, itemStack.hasGlint()
            );
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }
}
