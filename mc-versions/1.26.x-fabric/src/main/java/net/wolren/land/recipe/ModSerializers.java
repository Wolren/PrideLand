package net.wolren.land.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.wolren.land.PrideLand;

public class ModSerializers {
    public static final net.minecraft.world.item.crafting.RecipeSerializer<RainbowCuttingRecipe> RAINBOW_CUTTING_SERIALIZER =
            Registry.register(
                    BuiltInRegistries.RECIPE_SERIALIZER,
                    Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_cutting").toString(),
                    RainbowCuttingSerializer.INSTANCE);

    public static final net.minecraft.world.item.crafting.RecipeSerializer<RainbowDyeRecipe> RAINBOW_DYE_SERIALIZER =
            Registry.register(
                    BuiltInRegistries.RECIPE_SERIALIZER,
                    Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_dye").toString(),
                    RainbowDyeSerializer.INSTANCE);

    public static void registerCuttingSerializers() {
        PrideLand.LOGGER.info("Registering Cutting Serializers for " + PrideLand.MOD_ID);
    }
}
