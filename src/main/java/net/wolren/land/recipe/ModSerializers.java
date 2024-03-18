package net.wolren.land.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;

public class ModSerializers {
    public static final RainbowCuttingSerializer RAINBOW_CUTTING_SERIALIZER =
            Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Land.MOD_ID, "rainbow_cutting"),
                    new RainbowCuttingSerializer(RainbowCuttingRecipe::new));

    public static void registerCuttingSerializers() {
        Land.LOGGER.info("Registering Cutting Serializers for " + Land.MOD_ID);
    }
}
