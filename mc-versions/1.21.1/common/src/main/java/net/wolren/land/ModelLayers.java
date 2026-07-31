package net.wolren.land;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModelLayers {
    public static final EntityModelLayer RAINBOW_SHEEP = new EntityModelLayer(
            Identifier.of(LandCommon.MOD_ID, "rainbow_sheep"), "rainbow_sheep");
    public static final EntityModelLayer RAINBOW_SHEEP_FUR = new EntityModelLayer(
            Identifier.of(LandCommon.MOD_ID, "rainbow_sheep_fur"), "rainbow_sheep");
}
