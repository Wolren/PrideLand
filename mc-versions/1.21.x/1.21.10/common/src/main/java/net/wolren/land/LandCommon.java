package net.wolren.land;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.recipe.RecipeType;
import net.wolren.land.recipe.RainbowCuttingRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandCommon {
    public static final String MOD_ID = "pride_land";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @SuppressWarnings("unchecked")
    public static RecipeType<RainbowCuttingRecipe> RAINBOW_CUTTING = (RecipeType<RainbowCuttingRecipe>) (RecipeType<?>) RecipeType.STONECUTTING;

    public static void init() {
        LOGGER.info("Initializing Pride Land common");
    }

    public static void clientInit() {
        LOGGER.info("Initializing Pride Land common client");
    }

    public static DefaultAttributeContainer.Builder createRainbowSheepAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 8.0D)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.23D);
    }
}
