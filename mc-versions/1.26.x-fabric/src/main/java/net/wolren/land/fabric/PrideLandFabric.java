package net.wolren.land.fabric;

import net.fabricmc.api.ModInitializer;
import net.wolren.land.PrideLand;

public class PrideLandFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PrideLand.init();
    }
}
