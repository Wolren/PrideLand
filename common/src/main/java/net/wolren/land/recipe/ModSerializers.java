package net.wolren.land.recipe;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.wolren.land.LandCommon;

public class ModSerializers {
    public static final RainbowCuttingSerializer RAINBOW_CUTTING_SERIALIZER =
            Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(LandCommon.MOD_ID, "rainbow_cutting"),
                    new RainbowCuttingSerializer());

    public static void registerCuttingSerializers() {
        LandCommon.LOGGER.info("Registering Cutting Serializers for " + LandCommon.MOD_ID);
    }
}
