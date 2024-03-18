package net.wolren.land.entity.custom.living;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.wolren.land.entity.EntityVariantManager;

public class BaseSheep extends SheepEntity {
    private final EntityVariantManager<BaseSheep> variantManager;

    public BaseSheep(EntityType<? extends SheepEntity> type, World worldIn) {
        super(type, worldIn);
        variantManager = new EntityVariantManager<>();
    }

    @Override
    public BaseSheep createChild(ServerWorld serverWorld, PassiveEntity other) {
        return variantManager.getChild(this, other).create(serverWorld);
    }
}
