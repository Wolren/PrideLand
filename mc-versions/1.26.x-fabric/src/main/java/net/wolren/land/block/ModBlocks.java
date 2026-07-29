package net.wolren.land.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.wolren.land.PrideLand;

import java.util.function.Function;

public class ModBlocks {
    // Rainbow Wool
    public static final Block RAINBOW_WOOL = registerBlock("rainbow_wool",
            properties -> new Block(properties.strength(0.8f).sound(SoundType.WOOL)));

    // Rainbow Planks
    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks",
            properties -> new Block(properties.strength(2.0f, 3.0f).sound(SoundType.WOOD)));

    // Rainbow Bricks
    public static final Block RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            properties -> new Block(properties.strength(2.0f, 6.0f).sound(SoundType.STONE)));

    // Rainbow Stained Glass
    public static final Block RAINBOW_STAINED_GLASS = registerBlock("rainbow_stained_glass",
            properties -> new Block(properties.strength(0.3f).sound(SoundType.GLASS).noOcclusion()));

    // Rainbow Crafting Table
    public static final Block RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            properties -> new Block(properties.strength(3.5f).sound(SoundType.STONE)));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        PrideLand.LOGGER.info("Registering Mod Blocks for " + PrideLand.MOD_ID);
    }
}
