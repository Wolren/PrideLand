package net.wolren.land.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;

public class ModSerializers {
    public static final RainbowCuttingSerializer RAINBOW_CUTTING_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(LandCommon.MOD_ID, "rainbow_cutting"),
                    new RainbowCuttingSerializer());

    public static void registerCuttingSerializers() {
        LandCommon.LOGGER.info("Registering Cutting Serializers for " + LandCommon.MOD_ID);
    }
}
