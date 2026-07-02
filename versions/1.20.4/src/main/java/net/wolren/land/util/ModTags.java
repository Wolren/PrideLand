package net.wolren.land.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> GLASS_BLOCKS =
                createTag("pride_glass_blocks");
        public static final TagKey<Block> BED_BLOCKS =
                createTag("pride_glass_blocks");
        public static final TagKey<Block> WOOLS =
                createTag("pride_wools");
        public static final TagKey<Block> CARPETS =
                createTag("pride_wool_carpets");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Land.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ELYTRA_ITEMS =
                createTag("elytra_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Land.MOD_ID, name));
        }
    }
}
