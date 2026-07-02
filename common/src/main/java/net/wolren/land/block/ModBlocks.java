package net.wolren.land.block;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.wolren.land.LandCommon;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.block.custom.RainbowCraftingBlock;
import net.wolren.land.block.custom.directional.DirectionalBlock;
import net.wolren.land.block.custom.directional.DirectionalCarpetBlock;
import net.wolren.land.block.custom.directional.DirectionalRainbowConcretePowderBlock;

public class ModBlocks {

    // Candle
    public static final CandleBlock RAINBOW_CANDLE = (CandleBlock) registerBlock("rainbow_candle",
            new CandleBlock(candle()));

    // Crafting
    public static final Block RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            new RainbowCraftingBlock(stonecutter()));

    // Wools
    public static final DirectionalBlock RAINBOW_WOOL = (DirectionalBlock) registerBlock("rainbow_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock TRANS_WOOL = (DirectionalBlock) registerBlock("trans_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock NONBINARY_WOOL = (DirectionalBlock) registerBlock("nonbinary_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock BISEXUAL_WOOL = (DirectionalBlock) registerBlock("bisexual_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock PANSEXUAL_WOOL = (DirectionalBlock) registerBlock("pansexual_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock AROMANTIC_WOOL = (DirectionalBlock) registerBlock("aromantic_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock DEMISEXUAL_WOOL = (DirectionalBlock) registerBlock("demisexual_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock AGENDER_WOOL = (DirectionalBlock) registerBlock("agender_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock PROGRESS_PRIDE_WOOL = (DirectionalBlock) registerBlock("progress_pride_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock ASEXUAL_WOOL = (DirectionalBlock) registerBlock("asexual_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock GENDERFLUID_WOOL = (DirectionalBlock) registerBlock("genderfluid_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock LESBIAN_WOOL = (DirectionalBlock) registerBlock("lesbian_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock DEMIBOY_WOOL = (DirectionalBlock) registerBlock("demiboy_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock DEMIGIRL_WOOL = (DirectionalBlock) registerBlock("demigirl_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock GENDERQUEER_WOOL = (DirectionalBlock) registerBlock("genderqueer_wool",
            new DirectionalBlock(wool()));
    public static final DirectionalBlock POLYSEXUAL_WOOL = (DirectionalBlock) registerBlock("polysexual_wool",
            new DirectionalBlock(wool()));

    // Carpets
    public static final DirectionalCarpetBlock RAINBOW_CARPET = (DirectionalCarpetBlock) registerBlock("rainbow_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock TRANS_CARPET = (DirectionalCarpetBlock) registerBlock("trans_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock NONBINARY_CARPET = (DirectionalCarpetBlock) registerBlock("nonbinary_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock BISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("bisexual_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock PANSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("pansexual_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock AROMANTIC_CARPET = (DirectionalCarpetBlock) registerBlock("aromantic_carpet",
            new DirectionalCarpetBlock(carpet()));
    public static final DirectionalCarpetBlock DEMISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("demisexual_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock AGENDER_CARPET = (DirectionalCarpetBlock) registerBlock("agender_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock PROGRESS_PRIDE_CARPET = (DirectionalCarpetBlock) registerBlock("progress_pride_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock ASEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("asexual_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock GENDERFLUID_CARPET = (DirectionalCarpetBlock) registerBlock("genderfluid_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock LESBIAN_CARPET = (DirectionalCarpetBlock) registerBlock("lesbian_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock DEMIBOY_CARPET = (DirectionalCarpetBlock) registerBlock("demiboy_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock DEMIGIRL_CARPET = (DirectionalCarpetBlock) registerBlock("demigirl_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock GENDERQUEER_CARPET = (DirectionalCarpetBlock) registerBlock("genderqueer_carpet",
            new DirectionalCarpetBlock(wool()));
    public static final DirectionalCarpetBlock POLYSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("polysexual_carpet",
            new DirectionalCarpetBlock(wool()));

    // Stained Glass
    public static final GlassBlock RAINBOW_STAINED_GLASS = (GlassBlock) registerBlock("rainbow_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock RAINBOW_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("rainbow_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock TRANS_STAINED_GLASS = (GlassBlock) registerBlock("trans_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock TRANS_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("trans_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock NONBINARY_STAINED_GLASS = (GlassBlock) registerBlock("nonbinary_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock NONBINARY_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("nonbinary_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock BISEXUAL_STAINED_GLASS = (GlassBlock) registerBlock("bisexual_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock BISEXUAL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("bisexual_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock PANSEXUAL_STAINED_GLASS = (GlassBlock) registerBlock("pansexual_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock PANSEXUAL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("pansexual_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock AROMANTIC_STAINED_GLASS = (GlassBlock) registerBlock("aromantic_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock AROMANTIC_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("aromantic_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock DEMISEXUAL_STAINED_GLASS = (GlassBlock) registerBlock("demisexual_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock DEMISEXUAL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("demisexual_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock AGENDER_STAINED_GLASS = (GlassBlock) registerBlock("agender_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock AGENDER_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("agender_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock PROGRESS_PRIDE_STAINED_GLASS = (GlassBlock) registerBlock("progress_pride_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock PROGRESS_PRIDE_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("progress_pride_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock ASEXUAL_STAINED_GLASS = (GlassBlock) registerBlock("asexual_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock ASEXUAL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("asexual_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock GENDERFLUID_STAINED_GLASS = (GlassBlock) registerBlock("genderfluid_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock GENDERFLUID_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("genderfluid_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock LESBIAN_STAINED_GLASS = (GlassBlock) registerBlock("lesbian_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock LESBIAN_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("lesbian_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock DEMIBOY_STAINED_GLASS = (GlassBlock) registerBlock("demiboy_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock DEMIBOY_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("demiboy_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock DEMIGIRL_STAINED_GLASS = (GlassBlock) registerBlock("demigirl_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock DEMIGIRL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("demigirl_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock GENDERQUEER_STAINED_GLASS = (GlassBlock) registerBlock("genderqueer_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock GENDERQUEER_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("genderqueer_stained_glass_pane",
            new IronBarsBlock(pane()));
    public static final GlassBlock POLYSEXUAL_STAINED_GLASS = (GlassBlock) registerBlock("polysexual_stained_glass",
            new GlassBlock(glass()));
    public static final IronBarsBlock POLYSEXUAL_STAINED_GLASS_PANE = (IronBarsBlock) registerBlock("polysexual_stained_glass_pane",
            new IronBarsBlock(pane()));

    // Beds
    public static final CustomBedBlock RAINBOW_BED = (CustomBedBlock) registerBlock("rainbow_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock TRANS_BED = (CustomBedBlock) registerBlock("trans_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock NONBINARY_BED = (CustomBedBlock) registerBlock("nonbinary_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock BISEXUAL_BED = (CustomBedBlock) registerBlock("bisexual_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock PANSEXUAL_BED = (CustomBedBlock) registerBlock("pansexual_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock AROMANTIC_BED = (CustomBedBlock) registerBlock("aromantic_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock DEMISEXUAL_BED = (CustomBedBlock) registerBlock("demisexual_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock AGENDER_BED = (CustomBedBlock) registerBlock("agender_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock PROGRESS_PRIDE_BED = (CustomBedBlock) registerBlock("progress_pride_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock ASEXUAL_BED = (CustomBedBlock) registerBlock("asexual_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock GENDERFLUID_BED = (CustomBedBlock) registerBlock("genderfluid_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock LESBIAN_BED = (CustomBedBlock) registerBlock("lesbian_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock DEMIBOY_BED = (CustomBedBlock) registerBlock("demiboy_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock DEMIGIRL_BED = (CustomBedBlock) registerBlock("demigirl_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock GENDERQUEER_BED = (CustomBedBlock) registerBlock("genderqueer_bed", new CustomBedBlock(bed()));
    public static final CustomBedBlock POLYSEXUAL_BED = (CustomBedBlock) registerBlock("polysexual_bed", new CustomBedBlock(bed()));

    // Concrete & Terracotta
    public static final DirectionalBlock RAINBOW_CONCRETE = (DirectionalBlock) registerBlock("rainbow_concrete",
            new DirectionalBlock(concrete()));
    public static final DirectionalRainbowConcretePowderBlock RAINBOW_CONCRETE_POWDER = (DirectionalRainbowConcretePowderBlock) registerBlock("rainbow_concrete_powder",
            new DirectionalRainbowConcretePowderBlock(ModBlocks.RAINBOW_CONCRETE, concretePowder()));
    public static final DirectionalBlock RAINBOW_TERRACOTTA = (DirectionalBlock) registerBlock("rainbow_terracotta",
            new DirectionalBlock(terracotta()));

    // Bricks
    public static final Block RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            new Block(bricks()));
    public static final StairBlock RAINBOW_BRICK_STAIRS = (StairBlock) registerBlock("rainbow_brick_stairs",
            new StairBlock(ModBlocks.RAINBOW_BRICKS.defaultBlockState(), bricks()));
    public static final SlabBlock RAINBOW_BRICK_SLAB = (SlabBlock) registerBlock("rainbow_brick_slab",
            new SlabBlock(bricks()));
    public static final WallBlock RAINBOW_BRICK_WALL = (WallBlock) registerBlock("rainbow_brick_wall",
            new WallBlock(bricks()));

    // Planks & Wood family
    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks",
            new Block(planks()));
    public static final StairBlock RAINBOW_STAIRS = (StairBlock) registerBlock("rainbow_stairs",
            new StairBlock(ModBlocks.RAINBOW_PLANKS.defaultBlockState(), planks()));
    public static final SlabBlock RAINBOW_SLAB = (SlabBlock) registerBlock("rainbow_slab",
            new SlabBlock(planks()));
    public static final FenceBlock RAINBOW_FENCE = (FenceBlock) registerBlock("rainbow_fence",
            new FenceBlock(planks()));
    public static final FenceGateBlock RAINBOW_FENCE_GATE = (FenceGateBlock) registerBlock("rainbow_fence_gate",
            new FenceGateBlock(planks(), WoodType.OAK));
    public static final ButtonBlock RAINBOW_BUTTON = (ButtonBlock) registerBlock("rainbow_button",
            new ButtonBlock(planks(), BlockSetType.OAK, 10, true));
    public static final PressurePlateBlock RAINBOW_PRESSURE_PLATE = (PressurePlateBlock) registerBlock("rainbow_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, planks(), BlockSetType.OAK));
    public static final DoorBlock RAINBOW_DOOR = (DoorBlock) registerBlock("rainbow_door",
            new DoorBlock(planks(), BlockSetType.OAK));
    public static final TrapDoorBlock RAINBOW_TRAPDOOR = (TrapDoorBlock) registerBlock("rainbow_trapdoor",
            new TrapDoorBlock(planks(), BlockSetType.OAK));

    // Block family for data gen
    public static final BlockFamily RAINBOW_FAMILY = new BlockFamily.Builder(ModBlocks.RAINBOW_PLANKS)
            .recipeGroupPrefix("wooden").recipeUnlockedBy("has_planks").getFamily();

    // Sign blocks - removed from common due to Terraform API dependency.
    // These are registered in the fabric module. Null here for datagen compat.
    public static final Block RAINBOW_STANDING_SIGN = null;
    public static final Block RAINBOW_WALL_SIGN = null;
    public static final Block RAINBOW_HANGING_SIGN = null;
    public static final Block RAINBOW_WALL_HANGING_SIGN = null;

    // Registration helpers
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(LandCommon.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(LandCommon.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        LandCommon.LOGGER.info("Registering ModBlocks for " + LandCommon.MOD_ID);
    }

    // Block settings helpers - vanilla-compatible (no Fabric/Forge deps)
    private static BlockBehaviour.Properties wool() {
        return BlockBehaviour.Properties.of().strength(0.8F).sound(SoundType.WOOL);
    }

    private static BlockBehaviour.Properties carpet() {
        return BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.WOOL);
    }

    private static BlockBehaviour.Properties glass() {
        return BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion();
    }

    private static BlockBehaviour.Properties pane() {
        return BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion();
    }

    private static BlockBehaviour.Properties concrete() {
        return BlockBehaviour.Properties.of().strength(1.8F).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties concretePowder() {
        return BlockBehaviour.Properties.of().strength(0.5F).sound(SoundType.SAND);
    }

    private static BlockBehaviour.Properties terracotta() {
        return BlockBehaviour.Properties.of().strength(1.25F).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties planks() {
        return BlockBehaviour.Properties.of().strength(2.0F, 3.0F).sound(SoundType.WOOD);
    }

    private static BlockBehaviour.Properties bricks() {
        return BlockBehaviour.Properties.of().strength(2.0F, 6.0F).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties stonecutter() {
        return BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.STONE);
    }

    private static BlockBehaviour.Properties bed() {
        return BlockBehaviour.Properties.of().strength(0.2F).sound(SoundType.WOOD).noOcclusion();
    }

    private static BlockBehaviour.Properties candle() {
        return BlockBehaviour.Properties.of().strength(0.1F).sound(SoundType.CANDLE).noOcclusion();
    }
}
