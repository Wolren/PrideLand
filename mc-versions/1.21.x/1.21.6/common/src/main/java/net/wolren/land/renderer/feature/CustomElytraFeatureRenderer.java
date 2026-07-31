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
import net.minecraft.client.render.entity.model.LoadedEntityModels;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
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
public class CustomElytraFeatureRenderer extends FeatureRenderer<BipedEntityRenderState, EntityModel<? super BipedEntityRenderState>> {
    private final Identifier defaultElytraTexture;
    public final ElytraEntityModel elytra;
    private final Map<Item, Identifier> elytraTextures;

    public CustomElytraFeatureRenderer(FeatureRendererContext<BipedEntityRenderState, EntityModel<? super BipedEntityRenderState>> context, LoadedEntityModels loader, Identifier defaultElytraTexture) {
        super(context);
        this.defaultElytraTexture = defaultElytraTexture;
        this.elytraTextures = new HashMap<>();
        this.elytraTextures.put(ModItems.RAINBOW_ELYTRA, Identifier.of("pride_land:textures/entity/rainbow_elytra.png"));
        this.elytraTextures.put(ModItems.AGENDER_ELYTRA, Identifier.of("pride_land:textures/entity/agender_elytra.png"));
        this.elytraTextures.put(ModItems.AROMANTIC_ELYTRA, Identifier.of("pride_land:textures/entity/aromantic_elytra.png"));
        this.elytraTextures.put(ModItems.ASEXUAL_ELYTRA, Identifier.of("pride_land:textures/entity/asexual_elytra.png"));
        this.elytraTextures.put(ModItems.BISEXUAL_ELYTRA, Identifier.of("pride_land:textures/entity/bisexual_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIBOY_ELYTRA, Identifier.of("pride_land:textures/entity/demiboy_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIGIRL_ELYTRA, Identifier.of("pride_land:textures/entity/demigirl_elytra.png"));
        this.elytraTextures.put(ModItems.DEMISEXUAL_ELYTRA, Identifier.of("pride_land:textures/entity/demisexual_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERFLUID_ELYTRA, Identifier.of("pride_land:textures/entity/genderfluid_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERQUEER_ELYTRA, Identifier.of("pride_land:textures/entity/genderqueer_elytra.png"));
        this.elytraTextures.put(ModItems.LESBIAN_ELYTRA, Identifier.of("pride_land:textures/entity/lesbian_elytra.png"));
        this.elytraTextures.put(ModItems.NONBINARY_ELYTRA, Identifier.of("pride_land:textures/entity/nonbinary_elytra.png"));
        this.elytraTextures.put(ModItems.PANSEXUAL_ELYTRA, Identifier.of("pride_land:textures/entity/pansexual_elytra.png"));
        this.elytraTextures.put(ModItems.POLYSEXUAL_ELYTRA, Identifier.of("pride_land:textures/entity/polysexual_elytra.png"));
        this.elytraTextures.put(ModItems.PROGRESS_PRIDE_ELYTRA, Identifier.of("pride_land:textures/entity/progress_pride_elytra.png"));
        this.elytraTextures.put(ModItems.TRANS_ELYTRA, Identifier.of("pride_land:textures/entity/trans_elytra.png"));

        this.elytra = new ElytraEntityModel(loader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, BipedEntityRenderState state, float limbAngle, float limbDistance) {
        ItemStack itemStack = state.equippedChestStack;
        if (itemStack.getItem() instanceof CustomElytraItem) {
            Identifier elytraTexture = this.elytraTextures.getOrDefault(itemStack.getItem(), this.defaultElytraTexture);
            matrices.push();
            matrices.translate(0.0F, 0.0F, 0.125F);
            render(this.elytra, elytraTexture, matrices, vertexConsumers, light, state, -1);
            matrices.pop();
        }
    }
}
