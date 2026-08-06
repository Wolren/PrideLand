package net.wolren.land;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModelLayers {
    public static final ModelLayerLocation RAINBOW_SHEEP = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep"), "rainbow_sheep");
    public static final ModelLayerLocation RAINBOW_SHEEP_FUR = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep_fur"), "rainbow_sheep");
    public static final ModelLayerLocation CUSTOM_BED_HEAD = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "custom_bed_head"), "custom_bed_head");
    public static final ModelLayerLocation CUSTOM_BED_FOOT = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "custom_bed_foot"), "custom_bed_foot");
}
