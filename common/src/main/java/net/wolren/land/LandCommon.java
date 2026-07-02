package net.wolren.land;

import net.minecraft.world.item.crafting.RecipeType;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandCommon {
    public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static RecipeType<RainbowCuttingRecipe> RAINBOW_CUTTING;

    public static void init() {
        LOGGER.info("Initializing Pride Land common");
    }

    public static void clientInit() {
        LOGGER.info("Initializing Pride Land common client");
    }
}
