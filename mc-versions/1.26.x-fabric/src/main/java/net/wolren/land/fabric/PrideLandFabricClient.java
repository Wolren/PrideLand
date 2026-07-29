package net.wolren.land.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.wolren.land.PrideLand;

public class PrideLandFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PrideLand.clientInit();
    }
}
