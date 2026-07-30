package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.Level;

/**
 * Base sheep for PrideLand. Simplified for 26.X compilation.
 */
public class BaseSheep extends Sheep {

    public BaseSheep(EntityType<? extends Sheep> type, Level worldIn) {
        super(type, worldIn);
    }
}
