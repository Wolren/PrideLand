package net.wolren.land.block;

import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.BlockItemQueue;
import net.wolren.land.block.custom.CustomBedBlock;
import net.wolren.land.block.custom.RainbowCraftingBlock;
import net.wolren.land.block.custom.RainbowDoorBlock;
import net.wolren.land.block.custom.directional.DirectionalBlock;
import net.wolren.land.block.custom.directional.DirectionalCarpetBlock;
import net.wolren.land.block.custom.directional.DirectionalRainbowConcretePowderBlock;

public class ModBlocks {
    // Forge detection: defer block item registration to ITEM RegisterEvent
    private static final boolean DEFER_BLOCK_ITEMS = initDefer();

    private static boolean initDefer() {
        try {
            Class.forName("net.minecraftforge.fml.ModList");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

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
    public static final TransparentBlock RAINBOW_STAINED_GLASS = (TransparentBlock) registerBlock("rainbow_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock RAINBOW_STAINED_GLASS_PANE = (PaneBlock) registerBlock("rainbow_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock TRANS_STAINED_GLASS = (TransparentBlock) registerBlock("trans_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock TRANS_STAINED_GLASS_PANE = (PaneBlock) registerBlock("trans_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock NONBINARY_STAINED_GLASS = (TransparentBlock) registerBlock("nonbinary_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock NONBINARY_STAINED_GLASS_PANE = (PaneBlock) registerBlock("nonbinary_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock BISEXUAL_STAINED_GLASS = (TransparentBlock) registerBlock("bisexual_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock BISEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("bisexual_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock PANSEXUAL_STAINED_GLASS = (TransparentBlock) registerBlock("pansexual_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock PANSEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("pansexual_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock AROMANTIC_STAINED_GLASS = (TransparentBlock) registerBlock("aromantic_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock AROMANTIC_STAINED_GLASS_PANE = (PaneBlock) registerBlock("aromantic_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock DEMISEXUAL_STAINED_GLASS = (TransparentBlock) registerBlock("demisexual_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock DEMISEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demisexual_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock AGENDER_STAINED_GLASS = (TransparentBlock) registerBlock("agender_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock AGENDER_STAINED_GLASS_PANE = (PaneBlock) registerBlock("agender_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock PROGRESS_PRIDE_STAINED_GLASS = (TransparentBlock) registerBlock("progress_pride_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock PROGRESS_PRIDE_STAINED_GLASS_PANE = (PaneBlock) registerBlock("progress_pride_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock ASEXUAL_STAINED_GLASS = (TransparentBlock) registerBlock("asexual_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock ASEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("asexual_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock GENDERFLUID_STAINED_GLASS = (TransparentBlock) registerBlock("genderfluid_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock GENDERFLUID_STAINED_GLASS_PANE = (PaneBlock) registerBlock("genderfluid_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock LESBIAN_STAINED_GLASS = (TransparentBlock) registerBlock("lesbian_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock LESBIAN_STAINED_GLASS_PANE = (PaneBlock) registerBlock("lesbian_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock DEMIBOY_STAINED_GLASS = (TransparentBlock) registerBlock("demiboy_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock DEMIBOY_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demiboy_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock DEMIGIRL_STAINED_GLASS = (TransparentBlock) registerBlock("demigirl_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock DEMIGIRL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demigirl_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock GENDERQUEER_STAINED_GLASS = (TransparentBlock) registerBlock("genderqueer_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock GENDERQUEER_STAINED_GLASS_PANE = (PaneBlock) registerBlock("genderqueer_stained_glass_pane",
            new PaneBlock(pane()));
    public static final TransparentBlock POLYSEXUAL_STAINED_GLASS = (TransparentBlock) registerBlock("polysexual_stained_glass",
            new StainedGlassBlock(null, glass()));
    public static final PaneBlock POLYSEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("polysexual_stained_glass_pane",
            new PaneBlock(pane()));

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
    public static final StairsBlock RAINBOW_BRICK_STAIRS = (StairsBlock) registerBlock("rainbow_brick_stairs",
            new StairsBlock(ModBlocks.RAINBOW_BRICKS.getDefaultState(), bricks()));
    public static final SlabBlock RAINBOW_BRICK_SLAB = (SlabBlock) registerBlock("rainbow_brick_slab",
            new SlabBlock(bricks()));
    public static final WallBlock RAINBOW_BRICK_WALL = (WallBlock) registerBlock("rainbow_brick_wall",
            new WallBlock(bricks()));

    // Planks & Wood family
    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks",
            new Block(planks()));
    public static final StairsBlock RAINBOW_STAIRS = (StairsBlock) registerBlock("rainbow_stairs",
            new StairsBlock(ModBlocks.RAINBOW_PLANKS.getDefaultState(), planks()));
    public static final SlabBlock RAINBOW_SLAB = (SlabBlock) registerBlock("rainbow_slab",
            new SlabBlock(planks()));
    public static final FenceBlock RAINBOW_FENCE = (FenceBlock) registerBlock("rainbow_fence",
            new FenceBlock(planks()));
    public static final FenceGateBlock RAINBOW_FENCE_GATE = (FenceGateBlock) registerBlock("rainbow_fence_gate",
            new FenceGateBlock(planks(), WoodType.OAK));
    public static final ButtonBlock RAINBOW_BUTTON = (ButtonBlock) registerBlock("rainbow_button",
            new ButtonBlock(planks(), BlockSetType.OAK, 10, false));
    public static final PressurePlateBlock RAINBOW_PRESSURE_PLATE = (PressurePlateBlock) registerBlock("rainbow_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, planks(), BlockSetType.OAK));
    // nonOpaque() is required for doors and trapdoors: without it the block is treated as a
    // full opaque cube for occlusion culling, causing xray artifacts where adjacent block
    // faces are incorrectly hidden (for trapdoors) and drop issues (for doors).
    // Vanilla DoorBlock/TrapdoorBlock constructors call nonOpaque() internally in standard
    // mappings, but the Forge+Yarn+Architectury transformer may strip this call.
    public static final DoorBlock RAINBOW_DOOR = (DoorBlock) registerBlock("rainbow_door",
            new RainbowDoorBlock(BlockSetType.OAK, planks().nonOpaque()));
    public static final TrapdoorBlock RAINBOW_TRAPDOOR = (TrapdoorBlock) registerBlock("rainbow_trapdoor",
            new TrapdoorBlock(planks().nonOpaque(), BlockSetType.OAK));

    // Block family for data gen
    public static final BlockFamily RAINBOW_FAMILY = BlockFamilies.register(ModBlocks.RAINBOW_PLANKS)
            .group("wooden").unlockCriterionName("has_planks").build();

// Sign blocks — set by platform-specific modules (Terraform on Fabric, vanilla on Forge)
    public static Block RAINBOW_STANDING_SIGN = null;
    public static Block RAINBOW_WALL_SIGN = null;
    public static Block RAINBOW_HANGING_SIGN = null;
    public static Block RAINBOW_WALL_HANGING_SIGN = null;

    // Registration helpers
    private static Block registerBlock(String name, Block block) {
        if (DEFER_BLOCK_ITEMS) {
            BlockItemQueue.PENDING.add(() -> registerBlockItem(name, block));
        } else {
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, new Identifier(LandCommon.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(LandCommon.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        LandCommon.LOGGER.info("Registering ModBlocks for " + LandCommon.MOD_ID);
    }

    // Block settings helpers - vanilla-compatible (no Fabric/Forge deps)
    private static Block.Settings wool() {
        return Block.Settings.create().strength(0.8F).sounds(BlockSoundGroup.WOOL);
    }

    private static Block.Settings carpet() {
        return Block.Settings.create().strength(0.1F).sounds(BlockSoundGroup.WOOL);
    }

    private static Block.Settings glass() {
        return Block.Settings.create().strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque();
    }

    private static Block.Settings pane() {
        return Block.Settings.create().strength(0.3F).sounds(BlockSoundGroup.GLASS).nonOpaque();
    }

    private static Block.Settings concrete() {
        return Block.Settings.create().strength(1.8F).sounds(BlockSoundGroup.STONE);
    }

    private static Block.Settings concretePowder() {
        return Block.Settings.create().strength(0.5F).sounds(BlockSoundGroup.SAND);
    }

    private static Block.Settings terracotta() {
        return Block.Settings.create().strength(1.25F).sounds(BlockSoundGroup.STONE);
    }

    private static Block.Settings planks() {
        return Block.Settings.create().strength(2.0F, 3.0F).sounds(BlockSoundGroup.WOOD);
    }

    private static Block.Settings bricks() {
        return Block.Settings.create().strength(2.0F, 6.0F).sounds(BlockSoundGroup.STONE);
    }

    private static Block.Settings stonecutter() {
        return Block.Settings.create().strength(3.5F).sounds(BlockSoundGroup.STONE);
    }

    private static Block.Settings bed() {
        return Block.Settings.create().strength(0.2F).sounds(BlockSoundGroup.WOOD).nonOpaque();
    }

    private static Block.Settings candle() {
        return Block.Settings.create().strength(0.1F).sounds(BlockSoundGroup.CANDLE).nonOpaque();
    }
}
