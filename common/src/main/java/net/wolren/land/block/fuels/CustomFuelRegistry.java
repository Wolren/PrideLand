package net.wolren.land.block.fuels;

import net.minecraft.world.level.ItemLike;

import java.util.HashMap;
import java.util.Map;

public class CustomFuelRegistry {
    private static final Map<ItemLike, Integer> customFuels = new HashMap<>();

    public static void registerCustomFuel(ItemLike fuel, int burnTime) {
        customFuels.put(fuel, burnTime);
    }

    public static Map<ItemLike, Integer> getCustomFuels() {
        return customFuels;
    }
}
