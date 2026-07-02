package net.wolren.land.block.fuels;

import net.minecraft.item.ItemConvertible;

import java.util.HashMap;
import java.util.Map;

public class CustomFuelRegistry {
    private static final Map<ItemConvertible, Integer> customFuels = new HashMap<>();

    public static void registerCustomFuel(ItemConvertible fuel, int burnTime) {
        customFuels.put(fuel, burnTime);
    }

    public static Map<ItemConvertible, Integer> getCustomFuels() {
        return customFuels;
    }
}
