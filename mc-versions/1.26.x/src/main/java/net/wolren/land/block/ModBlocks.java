package net.wolren.land.block;

import net.wolren.land.PrideLand;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.block.custom.RainbowCraftingBlock;
import net.wolren.land.block.custom.RainbowDoorBlock;
import net.wolren.land.block.custom.directional.DirectionalBlock;
import net.wolren.land.block.custom.directional.DirectionalCarpetBlock;
import net.wolren.land.block.custom.directional.DirectionalRainbowConcretePowderBlock;
import net.wolren.land.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

/**
 * PrideLand block registration using NeoForge's DeferredRegister.
 * Full PrideLand block set ported from 1.21.11 common module.
 */
public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PrideLand.MOD_ID);

    // === Candle ===
    public static final DeferredBlock<CandleBlock> RAINBOW_CANDLE = registerBlock("rainbow_candle",
            properties -> new CandleBlock(properties));

    // === Crafting ===
    public static final DeferredBlock<RainbowCraftingBlock> RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            properties -> new RainbowCraftingBlock(properties));

    // === Wools (16 directional blocks) ===
    public static final DeferredBlock<DirectionalBlock> RAINBOW_WOOL = registerBlock("rainbow_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> TRANS_WOOL = registerBlock("trans_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> NONBINARY_WOOL = registerBlock("nonbinary_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> BISEXUAL_WOOL = registerBlock("bisexual_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> PANSEXUAL_WOOL = registerBlock("pansexual_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> AROMANTIC_WOOL = registerBlock("aromantic_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> DEMISEXUAL_WOOL = registerBlock("demisexual_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> AGENDER_WOOL = registerBlock("agender_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> PROGRESS_PRIDE_WOOL = registerBlock("progress_pride_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> ASEXUAL_WOOL = registerBlock("asexual_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> GENDERFLUID_WOOL = registerBlock("genderfluid_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> LESBIAN_WOOL = registerBlock("lesbian_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> DEMIBOY_WOOL = registerBlock("demiboy_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> DEMIGIRL_WOOL = registerBlock("demigirl_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> GENDERQUEER_WOOL = registerBlock("genderqueer_wool",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalBlock> POLYSEXUAL_WOOL = registerBlock("polysexual_wool",
            properties -> new DirectionalBlock(properties));

    // === Carpets (11 directional carpets) ===
    public static final DeferredBlock<DirectionalCarpetBlock> RAINBOW_CARPET = registerBlock("rainbow_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> TRANS_CARPET = registerBlock("trans_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> NONBINARY_CARPET = registerBlock("nonbinary_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> BISEXUAL_CARPET = registerBlock("bisexual_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> PANSEXUAL_CARPET = registerBlock("pansexual_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> AROMANTIC_CARPET = registerBlock("aromantic_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> DEMISEXUAL_CARPET = registerBlock("demisexual_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> AGENDER_CARPET = registerBlock("agender_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> PROGRESS_PRIDE_CARPET = registerBlock("progress_pride_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> ASEXUAL_CARPET = registerBlock("asexual_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> GENDERFLUID_CARPET = registerBlock("genderfluid_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> LESBIAN_CARPET = registerBlock("lesbian_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> DEMIBOY_CARPET = registerBlock("demiboy_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> DEMIGIRL_CARPET = registerBlock("demigirl_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> GENDERQUEER_CARPET = registerBlock("genderqueer_carpet",
            properties -> new DirectionalCarpetBlock(properties));
    public static final DeferredBlock<DirectionalCarpetBlock> POLYSEXUAL_CARPET = registerBlock("polysexual_carpet",
            properties -> new DirectionalCarpetBlock(properties));

    // === Stained Glass (16 colors) ===
    public static final DeferredBlock<Block> RAINBOW_STAINED_GLASS = registerBlock("rainbow_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> RAINBOW_STAINED_GLASS_PANE = registerBlock("rainbow_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> TRANS_STAINED_GLASS = registerBlock("trans_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> TRANS_STAINED_GLASS_PANE = registerBlock("trans_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> NONBINARY_STAINED_GLASS = registerBlock("nonbinary_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> NONBINARY_STAINED_GLASS_PANE = registerBlock("nonbinary_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> BISEXUAL_STAINED_GLASS = registerBlock("bisexual_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> BISEXUAL_STAINED_GLASS_PANE = registerBlock("bisexual_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> PANSEXUAL_STAINED_GLASS = registerBlock("pansexual_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> PANSEXUAL_STAINED_GLASS_PANE = registerBlock("pansexual_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> AROMANTIC_STAINED_GLASS = registerBlock("aromantic_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> AROMANTIC_STAINED_GLASS_PANE = registerBlock("aromantic_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> DEMISEXUAL_STAINED_GLASS = registerBlock("demisexual_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> DEMISEXUAL_STAINED_GLASS_PANE = registerBlock("demisexual_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> AGENDER_STAINED_GLASS = registerBlock("agender_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> AGENDER_STAINED_GLASS_PANE = registerBlock("agender_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> PROGRESS_PRIDE_STAINED_GLASS = registerBlock("progress_pride_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> PROGRESS_PRIDE_STAINED_GLASS_PANE = registerBlock("progress_pride_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> ASEXUAL_STAINED_GLASS = registerBlock("asexual_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> ASEXUAL_STAINED_GLASS_PANE = registerBlock("asexual_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> GENDERFLUID_STAINED_GLASS = registerBlock("genderfluid_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> GENDERFLUID_STAINED_GLASS_PANE = registerBlock("genderfluid_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> LESBIAN_STAINED_GLASS = registerBlock("lesbian_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> LESBIAN_STAINED_GLASS_PANE = registerBlock("lesbian_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> DEMIBOY_STAINED_GLASS = registerBlock("demiboy_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> DEMIBOY_STAINED_GLASS_PANE = registerBlock("demiboy_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> DEMIGIRL_STAINED_GLASS = registerBlock("demigirl_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> DEMIGIRL_STAINED_GLASS_PANE = registerBlock("demigirl_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> GENDERQUEER_STAINED_GLASS = registerBlock("genderqueer_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> GENDERQUEER_STAINED_GLASS_PANE = registerBlock("genderqueer_stained_glass_pane",
            properties -> new IronBarsBlock(properties));
    public static final DeferredBlock<Block> POLYSEXUAL_STAINED_GLASS = registerBlock("polysexual_stained_glass",
            properties -> new Block(properties));
    public static final DeferredBlock<IronBarsBlock> POLYSEXUAL_STAINED_GLASS_PANE = registerBlock("polysexual_stained_glass_pane",
            properties -> new IronBarsBlock(properties));

    // === Beds (16 beds) ===
    public static final DeferredBlock<CustomBedBlock> RAINBOW_BED = registerBlock("rainbow_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> TRANS_BED = registerBlock("trans_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> NONBINARY_BED = registerBlock("nonbinary_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> BISEXUAL_BED = registerBlock("bisexual_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> PANSEXUAL_BED = registerBlock("pansexual_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> AROMANTIC_BED = registerBlock("aromantic_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> DEMISEXUAL_BED = registerBlock("demisexual_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> AGENDER_BED = registerBlock("agender_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> PROGRESS_PRIDE_BED = registerBlock("progress_pride_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> ASEXUAL_BED = registerBlock("asexual_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> GENDERFLUID_BED = registerBlock("genderfluid_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> LESBIAN_BED = registerBlock("lesbian_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> DEMIBOY_BED = registerBlock("demiboy_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> DEMIGIRL_BED = registerBlock("demigirl_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> GENDERQUEER_BED = registerBlock("genderqueer_bed",
            properties -> new CustomBedBlock(properties));
    public static final DeferredBlock<CustomBedBlock> POLYSEXUAL_BED = registerBlock("polysexual_bed",
            properties -> new CustomBedBlock(properties));

    // === Concrete & Terracotta ===
    public static final DeferredBlock<DirectionalBlock> RAINBOW_CONCRETE = registerBlock("rainbow_concrete",
            properties -> new DirectionalBlock(properties));
    public static final DeferredBlock<DirectionalRainbowConcretePowderBlock> RAINBOW_CONCRETE_POWDER = registerBlock("rainbow_concrete_powder",
            properties -> new DirectionalRainbowConcretePowderBlock(RAINBOW_CONCRETE.get(), properties));
    public static final DeferredBlock<DirectionalBlock> RAINBOW_TERRACOTTA = registerBlock("rainbow_terracotta",
            properties -> new DirectionalBlock(properties));

    // === Bricks ===
    public static final DeferredBlock<Block> RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            properties -> new Block(properties));
    public static final DeferredBlock<StairBlock> RAINBOW_BRICK_STAIRS = registerBlock("rainbow_brick_stairs",
            properties -> new StairBlock(RAINBOW_BRICKS.get().defaultBlockState(), properties));
    public static final DeferredBlock<SlabBlock> RAINBOW_BRICK_SLAB = registerBlock("rainbow_brick_slab",
            properties -> new SlabBlock(properties));
    public static final DeferredBlock<WallBlock> RAINBOW_BRICK_WALL = registerBlock("rainbow_brick_wall",
            properties -> new WallBlock(properties));

    // === Planks & Wood family ===
    public static final DeferredBlock<Block> RAINBOW_PLANKS = registerBlock("rainbow_planks",
            properties -> new Block(properties));
    public static final DeferredBlock<StairBlock> RAINBOW_STAIRS = registerBlock("rainbow_stairs",
            properties -> new StairBlock(RAINBOW_PLANKS.get().defaultBlockState(), properties));
    public static final DeferredBlock<SlabBlock> RAINBOW_SLAB = registerBlock("rainbow_slab",
            properties -> new SlabBlock(properties));
    public static final DeferredBlock<FenceBlock> RAINBOW_FENCE = registerBlock("rainbow_fence",
            properties -> new FenceBlock(properties));
    public static final DeferredBlock<FenceGateBlock> RAINBOW_FENCE_GATE = registerBlock("rainbow_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK, properties));
    public static final DeferredBlock<ButtonBlock> RAINBOW_BUTTON = registerBlock("rainbow_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 10, properties));
    public static final DeferredBlock<PressurePlateBlock> RAINBOW_PRESSURE_PLATE = registerBlock("rainbow_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, properties));
    public static final DeferredBlock<RainbowDoorBlock> RAINBOW_DOOR = registerBlock("rainbow_door",
            properties -> new RainbowDoorBlock(BlockSetType.OAK, properties));
    public static final DeferredBlock<TrapDoorBlock> RAINBOW_TRAPDOOR = registerBlock("rainbow_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK, properties));

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
