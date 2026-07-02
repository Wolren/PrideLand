package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.wolren.land.entity.EntityVariantManager;

public class BaseSheep extends Sheep {
    private final EntityVariantManager<BaseSheep> variantManager;

    public BaseSheep(EntityType<? extends Sheep> type, Level worldIn) {
        super(type, worldIn);
        variantManager = new EntityVariantManager<>();
    }

    @Override
    public BaseSheep getBreedOffspring(ServerLevel serverWorld, AgeableMob other) {
        return variantManager.getChild(this, other).create(serverWorld);
    }
}
