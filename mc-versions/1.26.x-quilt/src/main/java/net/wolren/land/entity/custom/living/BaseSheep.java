package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.sheep.Sheep;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.wolren.land.entity.EntityVariantManager;

public class BaseSheep extends Sheep {
    private final EntityVariantManager<BaseSheep> variantManager;

    public BaseSheep(EntityType<? extends Sheep> type, Level worldIn) {
        super(type, worldIn);
        variantManager = new EntityVariantManager<>();
    }

    public BaseSheep getBreedOffspring(ServerLevelAccessor level, AgeableMob otherParent) {
        return variantManager.getChild(this, (Sheep) otherParent).create(level.getLevel(), EntitySpawnReason.BREEDING);
    }
}
