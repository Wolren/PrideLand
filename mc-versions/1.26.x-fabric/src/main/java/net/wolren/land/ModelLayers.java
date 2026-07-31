package net.wolren.land;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModelLayers {
    public static final ModelLayerLocation RAINBOW_SHEEP = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep"), "rainbow_sheep");
    public static final ModelLayerLocation RAINBOW_SHEEP_FUR = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep_fur"), "rainbow_sheep");
}
