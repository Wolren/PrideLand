package net.wolren.land.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.wolren.land.PrideLand;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.block.custom.RainbowCraftingBlock;
import net.wolren.land.block.custom.RainbowDoorBlock;
import net.wolren.land.block.custom.directional.DirectionalBlock;
import net.wolren.land.block.custom.directional.DirectionalCarpetBlock;
import net.wolren.land.block.custom.directional.DirectionalRainbowConcretePowderBlock;

import java.util.function.Function;

public class ModBlocks {
    // Forge detection - always false on Fabric
    private static final boolean DEFER_BLOCK_ITEMS = false;

    // Candle
    public static final Block RAINBOW_CANDLE = registerBlock("rainbow_candle",
            properties -> new CandleBlock(candle(properties)));

    // Crafting
    public static final Block RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            properties -> new RainbowCraftingBlock(stonecutter(properties)));

    // Wools
    public static final DirectionalBlock RAINBOW_WOOL = (DirectionalBlock) registerBlock("rainbow_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock TRANS_WOOL = (DirectionalBlock) registerBlock("trans_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock NONBINARY_WOOL = (DirectionalBlock) registerBlock("nonbinary_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock BISEXUAL_WOOL = (DirectionalBlock) registerBlock("bisexual_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock PANSEXUAL_WOOL = (DirectionalBlock) registerBlock("pansexual_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock AROMANTIC_WOOL = (DirectionalBlock) registerBlock("aromantic_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock DEMISEXUAL_WOOL = (DirectionalBlock) registerBlock("demisexual_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock AGENDER_WOOL = (DirectionalBlock) registerBlock("agender_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock PROGRESS_PRIDE_WOOL = (DirectionalBlock) registerBlock("progress_pride_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock ASEXUAL_WOOL = (DirectionalBlock) registerBlock("asexual_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock GENDERFLUID_WOOL = (DirectionalBlock) registerBlock("genderfluid_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock LESBIAN_WOOL = (DirectionalBlock) registerBlock("lesbian_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock DEMIBOY_WOOL = (DirectionalBlock) registerBlock("demiboy_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock DEMIGIRL_WOOL = (DirectionalBlock) registerBlock("demigirl_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock GENDERQUEER_WOOL = (DirectionalBlock) registerBlock("genderqueer_wool",
            properties -> new DirectionalBlock(wool(properties)));
    public static final DirectionalBlock POLYSEXUAL_WOOL = (DirectionalBlock) registerBlock("polysexual_wool",
            properties -> new DirectionalBlock(wool(properties)));

    // Carpets
    public static final DirectionalCarpetBlock RAINBOW_CARPET = (DirectionalCarpetBlock) registerBlock("rainbow_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock TRANS_CARPET = (DirectionalCarpetBlock) registerBlock("trans_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock NONBINARY_CARPET = (DirectionalCarpetBlock) registerBlock("nonbinary_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock BISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("bisexual_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock PANSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("pansexual_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock AROMANTIC_CARPET = (DirectionalCarpetBlock) registerBlock("aromantic_carpet",
            properties -> new DirectionalCarpetBlock(carpet(properties)));
    public static final DirectionalCarpetBlock DEMISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("demisexual_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock AGENDER_CARPET = (DirectionalCarpetBlock) registerBlock("agender_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock PROGRESS_PRIDE_CARPET = (DirectionalCarpetBlock) registerBlock("progress_pride_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock ASEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("asexual_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock GENDERFLUID_CARPET = (DirectionalCarpetBlock) registerBlock("genderfluid_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock LESBIAN_CARPET = (DirectionalCarpetBlock) registerBlock("lesbian_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock DEMIBOY_CARPET = (DirectionalCarpetBlock) registerBlock("demiboy_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock DEMIGIRL_CARPET = (DirectionalCarpetBlock) registerBlock("demigirl_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock GENDERQUEER_CARPET = (DirectionalCarpetBlock) registerBlock("genderqueer_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));
    public static final DirectionalCarpetBlock POLYSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("polysexual_carpet",
            properties -> new DirectionalCarpetBlock(wool(properties)));

    // Stained Glass
    public static final Block RAINBOW_STAINED_GLASS = registerBlock("rainbow_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block RAINBOW_STAINED_GLASS_PANE = registerBlock("rainbow_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block TRANS_STAINED_GLASS = registerBlock("trans_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block TRANS_STAINED_GLASS_PANE = registerBlock("trans_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block NONBINARY_STAINED_GLASS = registerBlock("nonbinary_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block NONBINARY_STAINED_GLASS_PANE = registerBlock("nonbinary_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block BISEXUAL_STAINED_GLASS = registerBlock("bisexual_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block BISEXUAL_STAINED_GLASS_PANE = registerBlock("bisexual_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block PANSEXUAL_STAINED_GLASS = registerBlock("pansexual_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block PANSEXUAL_STAINED_GLASS_PANE = registerBlock("pansexual_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block AROMANTIC_STAINED_GLASS = registerBlock("aromantic_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block AROMANTIC_STAINED_GLASS_PANE = registerBlock("aromantic_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block DEMISEXUAL_STAINED_GLASS = registerBlock("demisexual_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block DEMISEXUAL_STAINED_GLASS_PANE = registerBlock("demisexual_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block AGENDER_STAINED_GLASS = registerBlock("agender_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block AGENDER_STAINED_GLASS_PANE = registerBlock("agender_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block PROGRESS_PRIDE_STAINED_GLASS = registerBlock("progress_pride_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block PROGRESS_PRIDE_STAINED_GLASS_PANE = registerBlock("progress_pride_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block ASEXUAL_STAINED_GLASS = registerBlock("asexual_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block ASEXUAL_STAINED_GLASS_PANE = registerBlock("asexual_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block GENDERFLUID_STAINED_GLASS = registerBlock("genderfluid_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block GENDERFLUID_STAINED_GLASS_PANE = registerBlock("genderfluid_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block LESBIAN_STAINED_GLASS = registerBlock("lesbian_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block LESBIAN_STAINED_GLASS_PANE = registerBlock("lesbian_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block DEMIBOY_STAINED_GLASS = registerBlock("demiboy_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block DEMIBOY_STAINED_GLASS_PANE = registerBlock("demiboy_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block DEMIGIRL_STAINED_GLASS = registerBlock("demigirl_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block DEMIGIRL_STAINED_GLASS_PANE = registerBlock("demigirl_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block GENDERQUEER_STAINED_GLASS = registerBlock("genderqueer_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block GENDERQUEER_STAINED_GLASS_PANE = registerBlock("genderqueer_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));
    public static final Block POLYSEXUAL_STAINED_GLASS = registerBlock("polysexual_stained_glass",
            properties -> new Block(glass(properties)));
    public static final Block POLYSEXUAL_STAINED_GLASS_PANE = registerBlock("polysexual_stained_glass_pane",
            properties -> new IronBarsBlock(pane(properties)));

    // Beds
    public static final CustomBedBlock RAINBOW_BED = (CustomBedBlock) registerBlock("rainbow_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock TRANS_BED = (CustomBedBlock) registerBlock("trans_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock NONBINARY_BED = (CustomBedBlock) registerBlock("nonbinary_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock BISEXUAL_BED = (CustomBedBlock) registerBlock("bisexual_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock PANSEXUAL_BED = (CustomBedBlock) registerBlock("pansexual_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock AROMANTIC_BED = (CustomBedBlock) registerBlock("aromantic_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock DEMISEXUAL_BED = (CustomBedBlock) registerBlock("demisexual_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock AGENDER_BED = (CustomBedBlock) registerBlock("agender_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock PROGRESS_PRIDE_BED = (CustomBedBlock) registerBlock("progress_pride_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock ASEXUAL_BED = (CustomBedBlock) registerBlock("asexual_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock GENDERFLUID_BED = (CustomBedBlock) registerBlock("genderfluid_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock LESBIAN_BED = (CustomBedBlock) registerBlock("lesbian_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock DEMIBOY_BED = (CustomBedBlock) registerBlock("demiboy_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock DEMIGIRL_BED = (CustomBedBlock) registerBlock("demigirl_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock GENDERQUEER_BED = (CustomBedBlock) registerBlock("genderqueer_bed",
            properties -> new CustomBedBlock(bed(properties)));
    public static final CustomBedBlock POLYSEXUAL_BED = (CustomBedBlock) registerBlock("polysexual_bed",
            properties -> new CustomBedBlock(bed(properties)));

    // Concrete & Terracotta
    public static final DirectionalBlock RAINBOW_CONCRETE = (DirectionalBlock) registerBlock("rainbow_concrete",
            properties -> new DirectionalBlock(concrete(properties)));
    public static final DirectionalRainbowConcretePowderBlock RAINBOW_CONCRETE_POWDER = (DirectionalRainbowConcretePowderBlock) registerBlock("rainbow_concrete_powder",
            properties -> new DirectionalRainbowConcretePowderBlock(ModBlocks.RAINBOW_CONCRETE, concretePowder(properties)));
    public static final DirectionalBlock RAINBOW_TERRACOTTA = (DirectionalBlock) registerBlock("rainbow_terracotta",
            properties -> new DirectionalBlock(terracotta(properties)));

    // Bricks
    public static final Block RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            properties -> new Block(bricks(properties)));
    public static final StairBlock RAINBOW_BRICK_STAIRS = (StairBlock) registerBlock("rainbow_brick_stairs",
            properties -> new StairBlock(RAINBOW_BRICKS.defaultBlockState(), bricks(properties)));
    public static final SlabBlock RAINBOW_BRICK_SLAB = (SlabBlock) registerBlock("rainbow_brick_slab",
            properties -> new SlabBlock(bricks(properties)));
    public static final WallBlock RAINBOW_BRICK_WALL = (WallBlock) registerBlock("rainbow_brick_wall",
            properties -> new WallBlock(bricks(properties)));

    // Planks & Wood family
    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks",
            properties -> new Block(planks(properties)));
    public static final StairBlock RAINBOW_STAIRS = (StairBlock) registerBlock("rainbow_stairs",
            properties -> new StairBlock(RAINBOW_PLANKS.defaultBlockState(), planks(properties)));
    public static final SlabBlock RAINBOW_SLAB = (SlabBlock) registerBlock("rainbow_slab",
            properties -> new SlabBlock(planks(properties)));
    public static final FenceBlock RAINBOW_FENCE = (FenceBlock) registerBlock("rainbow_fence",
            properties -> new FenceBlock(planks(properties)));
    public static final FenceGateBlock RAINBOW_FENCE_GATE = (FenceGateBlock) registerBlock("rainbow_fence_gate",
            properties -> new FenceGateBlock(WoodType.OAK, planks(properties)));
    public static final ButtonBlock RAINBOW_BUTTON = (ButtonBlock) registerBlock("rainbow_button",
            properties -> new ButtonBlock(BlockSetType.OAK, 10, planks(properties)));
    public static final PressurePlateBlock RAINBOW_PRESSURE_PLATE = (PressurePlateBlock) registerBlock("rainbow_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.OAK, planks(properties)));
    public static final DoorBlock RAINBOW_DOOR = (DoorBlock) registerBlock("rainbow_door",
            properties -> new RainbowDoorBlock(BlockSetType.OAK, planks(properties).noOcclusion()));
    public static final TrapDoorBlock RAINBOW_TRAPDOOR = (TrapDoorBlock) registerBlock("rainbow_trapdoor",
            properties -> new TrapDoorBlock(BlockSetType.OAK, planks(properties).noOcclusion()));

    // Sign blocks - registered here (26.2 model-driven rendering)
    public static final Block RAINBOW_STANDING_SIGN = registerBlockNoItem("rainbow_standing_sign",
            properties -> new StandingSignBlock(WoodType.OAK, sign(properties)));
    public static final Block RAINBOW_WALL_SIGN = registerBlockNoItem("rainbow_wall_sign",
            properties -> new WallSignBlock(WoodType.OAK, sign(properties)));
    public static final Block RAINBOW_HANGING_SIGN = registerBlockNoItem("rainbow_hanging_sign",
            properties -> new CeilingHangingSignBlock(WoodType.OAK, sign(properties)));
    public static final Block RAINBOW_WALL_HANGING_SIGN = registerBlockNoItem("rainbow_wall_hanging_sign",
            properties -> new WallHangingSignBlock(WoodType.OAK, sign(properties)));

    // Registration helpers
    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name))));
        if (!DEFER_BLOCK_ITEMS) {
            registerBlockItem(name, toRegister);
        } else {
            BlockItemQueue.PENDING.add(() -> registerBlockItem(name, toRegister));
        }
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name)))));
    }

    // Registers a block WITHOUT a BlockItem (sign blocks use SignItem/HangingSignItem)
    private static Block registerBlockNoItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, name), toRegister);
    }

    public static void registerModBlocks() {
        PrideLand.LOGGER.info("Registering ModBlocks for " + PrideLand.MOD_ID);
    }

    // Block settings helpers
    private static BlockBehaviour.Properties wool(BlockBehaviour.Properties p) {
        return p.strength(0.8F).sound(SoundType.WOOL);
    }
    private static BlockBehaviour.Properties carpet(BlockBehaviour.Properties p) {
        return p.strength(0.1F).sound(SoundType.WOOL);
    }
    private static BlockBehaviour.Properties glass(BlockBehaviour.Properties p) {
        return p.strength(0.3F).sound(SoundType.GLASS).noOcclusion();
    }
    private static BlockBehaviour.Properties pane(BlockBehaviour.Properties p) {
        return p.strength(0.3F).sound(SoundType.GLASS).noOcclusion();
    }
    private static BlockBehaviour.Properties concrete(BlockBehaviour.Properties p) {
        return p.strength(1.8F).sound(SoundType.STONE);
    }
    private static BlockBehaviour.Properties concretePowder(BlockBehaviour.Properties p) {
        return p.strength(0.5F).sound(SoundType.SAND);
    }
    private static BlockBehaviour.Properties terracotta(BlockBehaviour.Properties p) {
        return p.strength(1.25F).sound(SoundType.STONE);
    }
    private static BlockBehaviour.Properties planks(BlockBehaviour.Properties p) {
        return p.strength(2.0F, 3.0F).sound(SoundType.WOOD);
    }
    private static BlockBehaviour.Properties bricks(BlockBehaviour.Properties p) {
        return p.strength(2.0F, 6.0F).sound(SoundType.STONE);
    }
    private static BlockBehaviour.Properties stonecutter(BlockBehaviour.Properties p) {
        return p.strength(3.5F).sound(SoundType.STONE);
    }
    private static BlockBehaviour.Properties bed(BlockBehaviour.Properties p) {
        return p.strength(0.2F).sound(SoundType.WOOD).noOcclusion();
    }
    private static BlockBehaviour.Properties candle(BlockBehaviour.Properties p) {
        return p.strength(0.1F).sound(SoundType.CANDLE).noOcclusion();
    }
    private static BlockBehaviour.Properties sign(BlockBehaviour.Properties p) {
        return p.strength(1.0F).sound(SoundType.WOOD).noCollision().noOcclusion();
    }
}
