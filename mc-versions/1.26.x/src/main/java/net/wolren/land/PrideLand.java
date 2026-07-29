package net.wolren.land;

import com.mojang.logging.LogUtils;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;
import net.wolren.land.creativetab.ModCreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

/**
 * PrideLand — Main mod entry point for NeoForge 26.X.
 * <p>
 * Inspired by the full PrideLand mod structure from 1.21.11,
 * adapted for NeoForge 26.X with DeferredRegister pattern
 * following the Kaupenjoe NeoForge 26.X course.
 */
@Mod(PrideLand.MOD_ID)
public class PrideLand {
    public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrideLand(IEventBus modEventBus, ModContainer modContainer) {
        // Register deferred registries
        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        // Register NeoForge event bus
        NeoForge.EVENT_BUS.register(this);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, PrideLandConfig.SPEC);
    }
}
