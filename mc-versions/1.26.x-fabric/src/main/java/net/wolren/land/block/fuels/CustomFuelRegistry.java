package net.wolren.land.block.fuels;

import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public class CustomFuelRegistry {
    private static final Map<Item, Integer> customFuels = new HashMap<>();

    public static void registerCustomFuel(Item fuel, int burnTime) {
        customFuels.put(fuel, burnTime);
    }

    public static Map<Item, Integer> getCustomFuels() {
        return customFuels;
    }
}
