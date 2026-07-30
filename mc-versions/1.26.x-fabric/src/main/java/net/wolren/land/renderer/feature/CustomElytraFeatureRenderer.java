package net.wolren.land.renderer.feature;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.wolren.land.item.ModItems;
import net.wolren.land.item.custom.CustomElytraItem;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class CustomElytraFeatureRenderer extends ElytraLayer<HumanoidRenderState, EntityModel<HumanoidRenderState>> {
    private final Identifier defaultElytraTexture;
    private final Map<Item, Identifier> elytraTextures;

    public CustomElytraFeatureRenderer(RenderLayerParent<HumanoidRenderState, EntityModel<HumanoidRenderState>> renderer, EntityModelSet modelSet, Identifier defaultElytraTexture) {
        super(renderer, modelSet);
        this.defaultElytraTexture = defaultElytraTexture;
        this.elytraTextures = new HashMap<>();
        this.elytraTextures.put(ModItems.RAINBOW_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/rainbow_elytra.png"));
        this.elytraTextures.put(ModItems.AGENDER_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/agender_elytra.png"));
        this.elytraTextures.put(ModItems.AROMANTIC_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/aromantic_elytra.png"));
        this.elytraTextures.put(ModItems.ASEXUAL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/asexual_elytra.png"));
        this.elytraTextures.put(ModItems.BISEXUAL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/bisexual_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIBOY_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/demiboy_elytra.png"));
        this.elytraTextures.put(ModItems.DEMIGIRL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/demigirl_elytra.png"));
        this.elytraTextures.put(ModItems.DEMISEXUAL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/demisexual_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERFLUID_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/genderfluid_elytra.png"));
        this.elytraTextures.put(ModItems.GENDERQUEER_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/genderqueer_elytra.png"));
        this.elytraTextures.put(ModItems.LESBIAN_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/lesbian_elytra.png"));
        this.elytraTextures.put(ModItems.NONBINARY_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/nonbinary_elytra.png"));
        this.elytraTextures.put(ModItems.PANSEXUAL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/pansexual_elytra.png"));
        this.elytraTextures.put(ModItems.POLYSEXUAL_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/polysexual_elytra.png"));
        this.elytraTextures.put(ModItems.PROGRESS_PRIDE_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/progress_pride_elytra.png"));
        this.elytraTextures.put(ModItems.TRANS_ELYTRA, Identifier.fromNamespaceAndPath("pride_land", "textures/entity/trans_elytra.png"));
    }

    @Override
    public void render(net.minecraft.client.gui.GuiGraphics guiGraphics, HumanoidRenderState state, int packedLight, float partialTick, float limbSwing, float limbSwingAmount) {
        ItemStack itemStack = state.getEquipment(EquipmentSlot.CHEST);
        if (itemStack.getItem() instanceof CustomElytraItem) {
            Identifier elytraTexture = this.elytraTextures.getOrDefault(itemStack.getItem(), this.defaultElytraTexture);
            renderElytra(guiGraphics, state, packedLight, partialTick, limbSwing, limbSwingAmount, elytraTexture);
        }
    }

    private void renderElytra(net.minecraft.client.gui.GuiGraphics guiGraphics, HumanoidRenderState state, int packedLight, float partialTick, float limbSwing, float limbSwingAmount, Identifier texture) {
        // Delegate to the parent render method
        super.render(guiGraphics, state, packedLight, partialTick, limbSwing, limbSwingAmount);
    }
}
