package net.wolren.land;

import net.minecraft.client.model.geom.EntityModelLayer;
import net.minecraft.resources.Identifier;

public class ModelLayers {
    public static final EntityModelLayer RAINBOW_SHEEP = new EntityModelLayer(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep"), "rainbow_sheep");
    public static final EntityModelLayer RAINBOW_SHEEP_FUR = new EntityModelLayer(
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep_fur"), "rainbow_sheep");
}
