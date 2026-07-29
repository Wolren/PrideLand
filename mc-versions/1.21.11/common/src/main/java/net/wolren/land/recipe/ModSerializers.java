package net.wolren.land.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.recipe.RainbowCuttingSerializer;
import net.wolren.land.recipe.RainbowDyeSerializer;

public class ModSerializers {
    public static final RainbowCuttingSerializer RAINBOW_CUTTING_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(LandCommon.MOD_ID, "rainbow_cutting"),
                    new RainbowCuttingSerializer());

    public static final RainbowDyeSerializer RAINBOW_DYE_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(LandCommon.MOD_ID, "rainbow_dye"),
                    new RainbowDyeSerializer());

    public static void registerCuttingSerializers() {
        LandCommon.LOGGER.info("Registering Cutting Serializers for " + LandCommon.MOD_ID);
    }
}
