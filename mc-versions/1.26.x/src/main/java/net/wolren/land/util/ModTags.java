package net.wolren.land.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.wolren.land.PrideLand;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GLASS_BLOCKS = createTag("pride_glass_blocks");
        public static final TagKey<Block> BED_BLOCKS = createTag("pride_beds");
        public static final TagKey<Block> WOOLS = createTag("pride_wools");
        public static final TagKey<Block> CARPETS = createTag("pride_wool_carpets");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ELYTRA_ITEMS = createTag("elytra_items");
        public static final TagKey<Item> RAINBOW_REPAIR = createTag("rainbow_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name));
        }
    }
}
