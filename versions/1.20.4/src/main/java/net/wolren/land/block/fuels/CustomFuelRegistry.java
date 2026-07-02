package net.wolren.land.block.fuels;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;

import java.util.HashMap;
import java.util.Map;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.ItemConvertible;
import net.wolren.land.block.ModBlocks;

import java.util.HashMap;
import java.util.Map;

public class CustomFuelRegistry {
    private static final Map<ItemConvertible, Integer> customFuels = new HashMap<>();

    public static void registerCustomFuel(ItemConvertible fuel, int burnTime) {
        customFuels.put(fuel, burnTime);
    }

    public static void linkCustomFuels() {
        for (Map.Entry<ItemConvertible, Integer> entry : customFuels.entrySet()) {
            ItemConvertible fuelItem = entry.getKey();
            int customBurnTime = entry.getValue();
            FuelRegistry.INSTANCE.add(fuelItem, customBurnTime);
        }
    }
}

