package net.wolren.land.recipe;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;
import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Mod recipe serializers. Registers the rainbow cutting serializer and
 * the vanilla crafting recipe types used by the datapack recipes.
 */
public class ModSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, PrideLand.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<RainbowCuttingRecipe>> RAINBOW_CUTTING =
            SERIALIZERS.register("rainbow_cutting", () -> RainbowCuttingRecipe.SERIALIZER);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
