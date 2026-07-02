package net.wolren.land.forge;

import net.wolren.land.LandCommon;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod("pride_land")
public class LandForge {
    public LandForge() {
        var modBus = FMLJavaModLoadingContext.get().getModEventBus();

        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);

        LandCommon.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LandCommon.LOGGER.info("Forge common setup");
    }

    private void clientSetup(FMLClientSetupEvent event) {
        LandCommon.clientInit();
    }
}
