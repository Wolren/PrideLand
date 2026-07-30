package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.wolren.land.block.ModBlocks;

/**
 * Mono-color sheep that drops a specific pride wool.
 * Simplified for 26.X compilation.
 */
public class MonoColorSheep extends BaseSheep {
    private final ItemStack wool;

    public MonoColorSheep(EntityType<? extends BaseSheep> type, Level world, ItemStack wool) {
        super(type, world);
        this.wool = wool;
    }

    public ItemStack getWool() {
        return wool;
    }

    public static class RainbowSheepEntity extends MonoColorSheep {
        public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, Level world) {
            super(type, world, new ItemStack(ModBlocks.RAINBOW_WOOL));
        }
    }
}
