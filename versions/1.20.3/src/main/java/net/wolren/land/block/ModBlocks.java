package net.wolren.land.block;

import com.terraformersmc.terraform.sign.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
import net.wolren.land.block.custom.*;
import net.wolren.land.block.custom.directional.DirectionalBlock;
import net.wolren.land.block.custom.directional.DirectionalCarpetBlock;
import net.wolren.land.block.custom.directional.DirectionalRainbowConcretePowderBlock;

public class ModBlocks {

    public static final CandleBlock RAINBOW_CANDLE = (CandleBlock) registerBlock("rainbow_candle",
            new CandleBlock(FabricBlockSettings.copyOf(Blocks.CANDLE)));

    public static final Block RAINBOW_CRAFTING = registerBlock("rainbow_crafting",
            new RainbowCraftingBlock(FabricBlockSettings.copyOf(Blocks.STONECUTTER)));




    public static final DirectionalBlock RAINBOW_WOOL = (DirectionalBlock) registerBlock("rainbow_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock TRANS_WOOL = (DirectionalBlock) registerBlock("trans_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock NONBINARY_WOOL = (DirectionalBlock) registerBlock("nonbinary_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock BISEXUAL_WOOL = (DirectionalBlock) registerBlock("bisexual_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock PANSEXUAL_WOOL = (DirectionalBlock) registerBlock("pansexual_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock AROMANTIC_WOOL = (DirectionalBlock) registerBlock("aromantic_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock DEMISEXUAL_WOOL = (DirectionalBlock) registerBlock("demisexual_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL).nonOpaque()));

    public static final DirectionalBlock AGENDER_WOOL = (DirectionalBlock) registerBlock("agender_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock PROGRESS_PRIDE_WOOL = (DirectionalBlock) registerBlock("progress_pride_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL).nonOpaque()));

    public static final DirectionalBlock ASEXUAL_WOOL = (DirectionalBlock) registerBlock("asexual_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock GENDERFLUID_WOOL = (DirectionalBlock) registerBlock("genderfluid_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock LESBIAN_WOOL = (DirectionalBlock) registerBlock("lesbian_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock DEMIBOY_WOOL = (DirectionalBlock) registerBlock("demiboy_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock DEMIGIRL_WOOL = (DirectionalBlock) registerBlock("demigirl_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock GENDERQUEER_WOOL = (DirectionalBlock) registerBlock("genderqueer_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalBlock POLYSEXUAL_WOOL = (DirectionalBlock) registerBlock("polysexual_wool",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));


    public static final DirectionalCarpetBlock RAINBOW_CARPET = (DirectionalCarpetBlock) registerBlock("rainbow_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock TRANS_CARPET = (DirectionalCarpetBlock) registerBlock("trans_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock NONBINARY_CARPET = (DirectionalCarpetBlock) registerBlock("nonbinary_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock BISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("bisexual_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock PANSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("pansexual_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock AROMANTIC_CARPET = (DirectionalCarpetBlock) registerBlock("aromantic_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CARPET).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock DEMISEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("demisexual_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock AGENDER_CARPET = (DirectionalCarpetBlock) registerBlock("agender_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock PROGRESS_PRIDE_CARPET = (DirectionalCarpetBlock) registerBlock("progress_pride_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock ASEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("asexual_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock GENDERFLUID_CARPET = (DirectionalCarpetBlock) registerBlock("genderfluid_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock LESBIAN_CARPET = (DirectionalCarpetBlock) registerBlock("lesbian_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock DEMIBOY_CARPET = (DirectionalCarpetBlock) registerBlock("demiboy_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock DEMIGIRL_CARPET = (DirectionalCarpetBlock) registerBlock("demigirl_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock GENDERQUEER_CARPET = (DirectionalCarpetBlock) registerBlock("genderqueer_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));

    public static final DirectionalCarpetBlock POLYSEXUAL_CARPET = (DirectionalCarpetBlock) registerBlock("polysexual_carpet",
            new DirectionalCarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL).sounds(BlockSoundGroup.WOOL)));





    public static final TintedGlassBlock RAINBOW_STAINED_GLASS = (TintedGlassBlock) registerBlock("rainbow_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock RAINBOW_STAINED_GLASS_PANE = (PaneBlock) registerBlock("rainbow_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock TRANS_STAINED_GLASS = (TintedGlassBlock) registerBlock("trans_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock TRANS_STAINED_GLASS_PANE = (PaneBlock) registerBlock("trans_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock NONBINARY_STAINED_GLASS = (TintedGlassBlock) registerBlock("nonbinary_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock NONBINARY_STAINED_GLASS_PANE = (PaneBlock) registerBlock("nonbinary_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock BISEXUAL_STAINED_GLASS = (TintedGlassBlock) registerBlock("bisexual_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock BISEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("bisexual_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock PANSEXUAL_STAINED_GLASS = (TintedGlassBlock) registerBlock("pansexual_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock PANSEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("pansexual_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock AROMANTIC_STAINED_GLASS = (TintedGlassBlock) registerBlock("aromantic_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock AROMANTIC_STAINED_GLASS_PANE = (PaneBlock) registerBlock("aromantic_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock DEMISEXUAL_STAINED_GLASS = (TintedGlassBlock) registerBlock("demisexual_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock DEMISEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demisexual_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock AGENDER_STAINED_GLASS = (TintedGlassBlock) registerBlock("agender_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock AGENDER_STAINED_GLASS_PANE = (PaneBlock) registerBlock("agender_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock PROGRESS_PRIDE_STAINED_GLASS = (TintedGlassBlock) registerBlock("progress_pride_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock PROGRESS_PRIDE_STAINED_GLASS_PANE = (PaneBlock) registerBlock("progress_pride_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock ASEXUAL_STAINED_GLASS = (TintedGlassBlock) registerBlock("asexual_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock ASEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("asexual_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock GENDERFLUID_STAINED_GLASS = (TintedGlassBlock) registerBlock("genderfluid_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock GENDERFLUID_STAINED_GLASS_PANE = (PaneBlock) registerBlock("genderfluid_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock LESBIAN_STAINED_GLASS = (TintedGlassBlock) registerBlock("lesbian_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock LESBIAN_STAINED_GLASS_PANE = (PaneBlock) registerBlock("lesbian_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock DEMIBOY_STAINED_GLASS = (TintedGlassBlock) registerBlock("demiboy_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock DEMIBOY_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demiboy_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock DEMIGIRL_STAINED_GLASS = (TintedGlassBlock) registerBlock("demigirl_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock DEMIGIRL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("demigirl_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock GENDERQUEER_STAINED_GLASS = (TintedGlassBlock) registerBlock("genderqueer_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock GENDERQUEER_STAINED_GLASS_PANE = (PaneBlock) registerBlock("genderqueer_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final TintedGlassBlock POLYSEXUAL_STAINED_GLASS = (TintedGlassBlock) registerBlock("polysexual_stained_glass",
            new TintedGlassBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));

    public static final PaneBlock POLYSEXUAL_STAINED_GLASS_PANE = (PaneBlock) registerBlock("polysexual_stained_glass_pane",
            new PaneBlock(FabricBlockSettings.copyOf(Blocks.GLASS).sounds(BlockSoundGroup.GLASS)));





    public static final CustomBedBlock RAINBOW_BED = (CustomBedBlock) registerBlock("rainbow_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock TRANS_BED = (CustomBedBlock)registerBlock("trans_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock NONBINARY_BED = (CustomBedBlock) registerBlock("nonbinary_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock BISEXUAL_BED = (CustomBedBlock) registerBlock("bisexual_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock PANSEXUAL_BED = (CustomBedBlock) registerBlock("pansexual_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock AROMANTIC_BED = (CustomBedBlock) registerBlock("aromantic_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock DEMISEXUAL_BED = (CustomBedBlock) registerBlock("demisexual_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock AGENDER_BED = (CustomBedBlock) registerBlock("agender_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock PROGRESS_PRIDE_BED = (CustomBedBlock) registerBlock("progress_pride_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock ASEXUAL_BED = (CustomBedBlock) registerBlock("asexual_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock GENDERFLUID_BED = (CustomBedBlock) registerBlock("genderfluid_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock LESBIAN_BED = (CustomBedBlock)registerBlock("lesbian_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock DEMIBOY_BED = (CustomBedBlock) registerBlock("demiboy_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock DEMIGIRL_BED = (CustomBedBlock) registerBlock("demigirl_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock GENDERQUEER_BED = (CustomBedBlock) registerBlock("genderqueer_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));
    public static final CustomBedBlock POLYSEXUAL_BED = (CustomBedBlock) registerBlock("polysexual_bed", new CustomBedBlock(FabricBlockSettings.copyOf(Blocks.WHITE_BED).nonOpaque()));





    public static final DirectionalBlock RAINBOW_CONCRETE = (DirectionalBlock) registerBlock("rainbow_concrete",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE).sounds(BlockSoundGroup.STONE)));

    public static final DirectionalRainbowConcretePowderBlock RAINBOW_CONCRETE_POWDER = (DirectionalRainbowConcretePowderBlock) registerBlock("rainbow_concrete_powder",
            new DirectionalRainbowConcretePowderBlock(ModBlocks.RAINBOW_CONCRETE, FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE_POWDER).sounds(BlockSoundGroup.SAND)));

    public static final DirectionalBlock RAINBOW_TERRACOTTA = (DirectionalBlock) registerBlock("rainbow_terracotta",
            new DirectionalBlock(FabricBlockSettings.copyOf(Blocks.WHITE_TERRACOTTA).sounds(BlockSoundGroup.STONE)));

    public static final Block RAINBOW_BRICKS = registerBlock("rainbow_bricks",
            new Block(FabricBlockSettings.copyOf(Blocks.BRICKS)));

    public static final StairsBlock RAINBOW_BRICK_STAIRS = (StairsBlock) registerBlock("rainbow_brick_stairs",
            new StairsBlock(ModBlocks.RAINBOW_BRICKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BRICK_STAIRS)));

    public static final SlabBlock RAINBOW_BRICK_SLAB = (SlabBlock) registerBlock("rainbow_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.BRICK_SLAB)));

    public static final WallBlock RAINBOW_BRICK_WALL = (WallBlock) registerBlock("rainbow_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.BRICK_WALL)));





    public static final Block RAINBOW_PLANKS = registerBlock("rainbow_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final StairsBlock RAINBOW_STAIRS = (StairsBlock) registerBlock("rainbow_stairs",
            new StairsBlock(ModBlocks.RAINBOW_PLANKS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).burnable()));

    public static final SlabBlock RAINBOW_SLAB = (SlabBlock) registerBlock("rainbow_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_SLAB)));

    public static final FenceBlock RAINBOW_FENCE = (FenceBlock) registerBlock("rainbow_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_FENCE)));

    public static final FenceGateBlock RAINBOW_FENCE_GATE = (FenceGateBlock) registerBlock("rainbow_fence_gate",
            new FenceGateBlock(WoodType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_FENCE_GATE)));

    public static final ButtonBlock RAINBOW_BUTTON = (ButtonBlock) registerBlock("rainbow_button",
            new ButtonBlock(BlockSetType.OAK, 10, FabricBlockSettings.copyOf(Blocks.OAK_BUTTON)));

    public static final PressurePlateBlock RAINBOW_PRESSURE_PLATE = (PressurePlateBlock) registerBlock("rainbow_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK,
                    FabricBlockSettings.copyOf(Blocks.OAK_PRESSURE_PLATE)));

    public static final DoorBlock RAINBOW_DOOR = (DoorBlock) registerBlock("rainbow_door",
            new DoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_DOOR).nonOpaque()));

    public static final TrapdoorBlock RAINBOW_TRAPDOOR = (TrapdoorBlock) registerBlock("rainbow_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, FabricBlockSettings.copyOf(Blocks.OAK_TRAPDOOR).nonOpaque()));





    public static final Identifier RAINBOW_SIGN_TEXTURE = new Identifier(Land.MOD_ID, "entity/signs/rainbow");
    public static final Identifier RAINBOW_HANGING_SIGN_TEXTURE = new Identifier(Land.MOD_ID, "entity/signs/hanging/rainbow");
    public static final Identifier RAINBOW_HANGING_GUI_SIGN_TEXTURE = new Identifier(Land.MOD_ID, "textures/gui/hanging_signs/rainbow");
    public static final Block RAINBOW_STANDING_SIGN = Registry.register(
            Registries.BLOCK, new Identifier(Land.MOD_ID, "rainbow_standing_sign"),
            new TerraformSignBlock(RAINBOW_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_SIGN)));
    public static final Block RAINBOW_WALL_SIGN = Registry.register(
            Registries.BLOCK, new Identifier(Land.MOD_ID, "rainbow_wall_sign"),
            new TerraformWallSignBlock(RAINBOW_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_SIGN)));
    public static final Block RAINBOW_HANGING_SIGN = Registry.register(
            Registries.BLOCK, new Identifier(Land.MOD_ID, "rainbow_hanging_sign"),
            new TerraformHangingSignBlock(RAINBOW_HANGING_SIGN_TEXTURE, RAINBOW_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_HANGING_SIGN)));
    public static final Block RAINBOW_WALL_HANGING_SIGN = Registry.register(
            Registries.BLOCK, new Identifier(Land.MOD_ID, "rainbow_wall_hanging_sign"),
            new TerraformWallHangingSignBlock(RAINBOW_HANGING_SIGN_TEXTURE, RAINBOW_HANGING_GUI_SIGN_TEXTURE, FabricBlockSettings.copyOf(Blocks.OAK_WALL_HANGING_SIGN)));

    public static final BlockFamily RAINBOW_FAMILY = BlockFamilies.register(ModBlocks.RAINBOW_PLANKS)
            .sign(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Land.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Land.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Land.LOGGER.info("Registering Mod Blocks for " + Land.MOD_ID);
    }
}
