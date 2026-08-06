package net.wolren.land.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, PrideLand.MOD_ID);

    public static final DeferredHolder<RecipeType<?>, RecipeType<RainbowCuttingRecipe>> RAINBOW_CUTTING =
            RECIPE_TYPES.register("rainbow_cutting", () -> new RecipeType<>() {
            });

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
