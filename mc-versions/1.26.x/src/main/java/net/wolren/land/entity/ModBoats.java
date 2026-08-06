package net.wolren.land.entity;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import net.wolren.land.PrideLand;

/**
 * Boat model layer locations for the rainbow boats.
 * Layers are boat/rainbow and chest_boat/rainbow (vanilla 26.2 convention:
 * "boat/<wood>" / "chest_boat/<wood>"); the BoatRenderer derives the entity
 * texture from the layer location: textures/entity/boat/rainbow.png and
 * textures/entity/chest_boat/rainbow.png.
 */
public class ModBoats {
    public static final Identifier RAINBOW_BASE_ID = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow");

    public static final ModelLayerLocation RAINBOW_BOAT_LAYER =
            new ModelLayerLocation(RAINBOW_BASE_ID.withPrefix("boat/"), "main");
    public static final ModelLayerLocation RAINBOW_CHEST_BOAT_LAYER =
            new ModelLayerLocation(RAINBOW_BASE_ID.withPrefix("chest_boat/"), "main");

    private ModBoats() {
    }
}
