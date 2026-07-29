package net.wolren.land.block;

import net.wolren.land.PrideLand;
import net.wolren.land.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

/**
 * PrideLand block registration using NeoForge's DeferredRegister.
 * <p>
 * Pattern inspired by Kaupenjoe NeoForge 26.X course.
 * Full PrideLand block set ported from 1.21.11 common module.
 */
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrideLand.MOD_ID);

    // === Wools (directional blocks as placeholders — real DirectionalBlock requires custom block classes) ===
    public static final DeferredBlock<Block> RAINBOW_WOOL = registerBlock("rainbow_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> TRANS_WOOL = registerBlock("trans_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> NONBINARY_WOOL = registerBlock("nonbinary_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_YELLOW).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> BISEXUAL_WOOL = registerBlock("bisexual_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_PURPLE).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> PANSEXUAL_WOOL = registerBlock("pansexual_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_PINK).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> AROMANTIC_WOOL = registerBlock("aromantic_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_GREEN).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DEMISEXUAL_WOOL = registerBlock("demisexual_wool",
            properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_WHITE).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> AGENDER_WOOL = registerBlock("agender_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_GRAY).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> PROGRESS_PRIDE_WOOL = registerBlock("progress_pride_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_RED).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> ASEXUAL_WOOL = registerBlock("asexual_wool",
            properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_BLACK).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> GENDERFLUID_WOOL = registerBlock("genderfluid_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_PINK).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> LESBIAN_WOOL = registerBlock("lesbian_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_ORANGE).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DEMIBOY_WOOL = registerBlock("demiboy_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_CYAN).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> DEMIGIRL_WOOL = registerBlock("demigirl_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> GENDERQUEER_WOOL = registerBlock("genderqueer_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_LIGHT_GREEN).strength(0.8F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> POLYSEXUAL_WOOL = registerBlock("polysexual_wool",
            properties -> new Block(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.8F).sound(SoundType.WOOL)));

    // === Carpets ===
    public static final DeferredBlock<Block> RAINBOW_CARPET = registerBlock("rainbow_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> TRANS_CARPET = registerBlock("trans_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> NONBINARY_CARPET = registerBlock("nonbinary_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_YELLOW).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> BISEXUAL_CARPET = registerBlock("bisexual_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_PURPLE).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> PANSEXUAL_CARPET = registerBlock("pansexual_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_PINK).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> AROMANTIC_CARPET = registerBlock("aromantic_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_GREEN).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> AGENDER_CARPET = registerBlock("agender_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_GRAY).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> PROGRESS_PRIDE_CARPET = registerBlock("progress_pride_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_RED).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> ASEXUAL_CARPET = registerBlock("asexual_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_BLACK).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> GENDERFLUID_CARPET = registerBlock("genderfluid_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_PINK).strength(0.1F).sound(SoundType.WOOL)));
    public static final DeferredBlock<Block> LESBIAN_CARPET = registerBlock("lesbian_carpet",
            properties -> new CarpetBlock(properties.mapColor(MapColor.COLOR_ORANGE).strength(0.1F).sound(SoundType.WOOL)));

    // === Stained Glass ===
    public static final DeferredBlock<Block> RAINBOW_STAINED_GLASS = registerBlock("rainbow_stained_glass",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> RAINBOW_STAINED_GLASS_PANE = registerBlock("rainbow_stained_glass_pane",
            properties -> new IronBarsBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> TRANS_STAINED_GLASS = registerBlock("trans_stained_glass",
            properties -> new Block(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));
    public static final DeferredBlock<Block> TRANS_STAINED_GLASS_PANE = registerBlock("trans_stained_glass_pane",
            properties -> new IronBarsBlock(properties.mapColor(MapColor.COLOR_LIGHT_BLUE).strength(0.3F).sound(SoundType.GLASS).noOcclusion()));

    // === Planks family ===
    public static final DeferredBlock<Block> RAINBOW_PLANKS = registerBlock("rainbow_planks",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RAINBOW_STAIRS = registerBlock("rainbow_stairs",
            properties -> new StairBlock(RAINBOW_PLANKS.get().defaultBlockState(), properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RAINBOW_SLAB = registerBlock("rainbow_slab",
            properties -> new SlabBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RAINBOW_FENCE = registerBlock("rainbow_fence",
            properties -> new FenceBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RAINBOW_FENCE_GATE = registerBlock("rainbow_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK, properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> RAINBOW_BUTTON = registerBlock("rainbow_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 10, properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.5F).noCollision().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RAINBOW_PRESSURE_PLATE = registerBlock("rainbow_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.5F).pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RAINBOW_DOOR = registerBlock("rainbow_door",
            properties -> new DoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.COLOR_MAGENTA).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final DeferredBlock<Block> RAINBOW_TRAPDOOR = registerBlock("rainbow_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK, properties.mapColor(MapColor.COLOR_MAGENTA).strength(3.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // === Bricks ===
    public static final DeferredBlock<Block> RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAINBOW_BRICK_STAIRS = registerBlock("rainbow_brick_stairs",
            properties -> new StairBlock(RAINBOW_BRICKS.get().defaultBlockState(), properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAINBOW_BRICK_SLAB = registerBlock("rainbow_brick_slab",
            properties -> new SlabBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAINBOW_BRICK_WALL = registerBlock("rainbow_brick_wall",
            properties -> new WallBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 6.0F).sound(SoundType.STONE)));

    // === Concrete & Terracotta ===
    public static final DeferredBlock<Block> RAINBOW_CONCRETE = registerBlock("rainbow_concrete",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(1.8F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RAINBOW_TERRACOTTA = registerBlock("rainbow_terracotta",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(1.25F).sound(SoundType.STONE)));

    // === Crafting ===
    public static final DeferredBlock<Block> RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            properties -> new Block(properties.mapColor(MapColor.COLOR_MAGENTA).strength(3.5F).sound(SoundType.STONE)));

    // === Candle ===
    public static final DeferredBlock<Block> RAINBOW_CANDLE = registerBlock("rainbow_candle",
            properties -> new CandleBlock(properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.1F).sound(SoundType.CANDLE).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // === Beds ===
    public static final DeferredBlock<Block> RAINBOW_BED = registerBlock("rainbow_bed",
            properties -> new BedBlock(DyeColor.MAGENTA, properties.mapColor(MapColor.COLOR_MAGENTA).strength(0.2F).sound(SoundType.WOOD).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // === Registration helpers ===

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
