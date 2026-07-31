package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.sheep.Sheep;

/**
 * Helper to access Sheep data since Sheep.DATA_SHEARED was removed in MC 26.2.
 * Uses the entity data accessor API directly.
 */
public class SheepDataHelper {
    private static final int SHEARED_FLAG = 16; // Same as vanilla Sheep.DATA_SHEARED flag

    public static boolean isSheared(LivingEntity sheep) {
        if (sheep instanceof Sheep s) {
            return s.isSheared();
        }
        return false;
    }

    public static void setSheared(LivingEntity sheep, boolean sheared) {
        if (sheep instanceof Sheep s) {
            s.setSheared(sheared);
        }
    }
}
