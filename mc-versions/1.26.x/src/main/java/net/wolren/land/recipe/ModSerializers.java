package net.wolren.land.recipe;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;

/**
 * Mod recipe serializers.
 * Uses the vanilla stonecutter and shapeless recipe types instead of custom ones.
 * Custom recipe types will be re-enabled once the 26.X API is better understood.
 */
public class ModSerializers {
    public static final DeferredRegister<?> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, PrideLand.MOD_ID);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
