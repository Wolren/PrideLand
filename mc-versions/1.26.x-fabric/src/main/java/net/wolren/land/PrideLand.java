package net.wolren.land;

import net.minecraft.world.item.crafting.RecipeType;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModCreativeModeTabs;
import net.wolren.land.item.ModItems;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideLand {
    public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static RecipeType<RainbowCuttingRecipe> RAINBOW_CUTTING = new RecipeType<RainbowCuttingRecipe>() {};

    public static void init() {
        LOGGER.info("Initializing Pride Land 26.X");

        ModCreativeModeTabs.registerCreativeModeTabs();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }

    public static void clientInit() {
        LOGGER.info("Initializing Pride Land 26.X client");
    }
}
