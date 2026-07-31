package net.wolren.land.screen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;

public class ModScreenHandlers {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, PrideLand.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<?>> RAINBOW_CRAFTING_MENU =
            MENUS.register("rainbow_workstation", () -> new MenuType<>(
                    (syncId, inventory) -> new RainbowCraftingScreenHandler(syncId, inventory),
                    FeatureFlags.DEFAULT_FLAGS));

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
