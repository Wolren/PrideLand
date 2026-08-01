package net.wolren.land;

import com.mojang.logging.LogUtils;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.creativetab.ModCreativeModeTabs;
import net.wolren.land.entity.ModEntities;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.ModSerializers;
import net.wolren.land.screen.ModScreenHandlers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

/**
 * PrideLand — Main mod entry point for NeoForge 26.X.
 * Full PrideLand implementation ported from 1.21.11 common module.
 */
@Mod(PrideLand.MOD_ID)
public class PrideLand {
    public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LogUtils.getLogger();

    public PrideLand(IEventBus modEventBus, ModContainer modContainer) {
        ModCreativeModeTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSerializers.register(modEventBus);
        ModScreenHandlers.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, PrideLandConfig.SPEC);
    }
}
