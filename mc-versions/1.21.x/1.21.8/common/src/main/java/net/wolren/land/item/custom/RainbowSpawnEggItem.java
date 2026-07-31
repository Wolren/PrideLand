package net.wolren.land.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.wolren.land.entity.ModEntities;

public class RainbowSpawnEggItem extends SpawnEggItem {
    public RainbowSpawnEggItem(Settings settings) {
        super(ModEntities.RAINBOW_SHEEP, settings);
    }

    /**
     * On Forge, items are registered during the ITEM RegisterEvent which fires
     * BEFORE the ENTITY_TYPE RegisterEvent. The entity type reference passed to
     * the super constructor is null at construction time. This override ensures
     * getRequiredFeatures() uses the canonical field (populated by the time any
     * gameplay code accesses it) instead of the constructor parameter.
     */
    @Override
    public FeatureSet getRequiredFeatures() {
        return ModEntities.RAINBOW_SHEEP.getRequiredFeatures();
    }
}
