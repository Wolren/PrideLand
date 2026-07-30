package net.wolren.land.fabric.entity;

import net.minecraft.resources.Identifier;
import net.wolren.land.PrideLand;

public class ModBoats {
    public static final Identifier RAINBOW_BOAT_ID = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_boat");
    public static final Identifier RAINBOW_CHEST_BOAT_ID = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_chest_boat");

    public static void registerBoats() {
        PrideLand.LOGGER.info("Registering Boats for " + PrideLand.MOD_ID);
    }
}
