package net.wolren.land;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * PrideLand configuration via NeoForge config system.
 */
public class PrideLandConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    static {
        BUILDER.push("general");
        // Add config values here
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
