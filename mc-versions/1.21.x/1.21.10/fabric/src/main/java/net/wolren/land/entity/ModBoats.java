package net.wolren.land.entity;

import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;

public class ModBoats {
    public static final Identifier RAINBOW_BOAT_ID = Identifier.of(LandCommon.MOD_ID, "rainbow");
    public static final Identifier RAINBOW_CHEST_BOAT_ID = Identifier.of(LandCommon.MOD_ID, "rainbow");

    public static void registerBoats() {
        LandCommon.LOGGER.info("Registering Boats for " + LandCommon.MOD_ID);
        // Boats are now data-driven via TerraformBoatData
        // Item registration happens in LandFabric.java via TerraformBoatItemHelper
    }
}