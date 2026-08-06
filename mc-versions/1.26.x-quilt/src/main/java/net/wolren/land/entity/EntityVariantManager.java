package net.wolren.land.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.sheep.Sheep;

public class EntityVariantManager<T extends Sheep> {

    @SuppressWarnings("unchecked")
    public EntityType<T> getChild(Sheep parent1, Sheep parent2) {
        if (parent1.getRandom().nextInt(100) > 50) {
            return (EntityType<T>) parent2.getType();
        }
        return (EntityType<T>) parent1.getType();
    }
}
