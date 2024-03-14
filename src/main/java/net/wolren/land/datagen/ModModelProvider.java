package net.wolren.land.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.BedPart;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerGlassPane(ModBlocks.RAINBOW_STAINED_GLASS, ModBlocks.RAINBOW_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.TRANS_STAINED_GLASS, ModBlocks.TRANS_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.NONBINARY_STAINED_GLASS, ModBlocks.NONBINARY_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.BISEXUAL_STAINED_GLASS, ModBlocks.BISEXUAL_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.PANSEXUAL_STAINED_GLASS, ModBlocks.PANSEXUAL_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.AROMANTIC_STAINED_GLASS, ModBlocks.AROMANTIC_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.DEMISEXUAL_STAINED_GLASS, ModBlocks.DEMISEXUAL_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.AGENDER_STAINED_GLASS, ModBlocks.AGENDER_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.PROGRESS_PRIDE_STAINED_GLASS, ModBlocks.PROGRESS_PRIDE_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.ASEXUAL_STAINED_GLASS, ModBlocks.ASEXUAL_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GENDERFLUID_STAINED_GLASS, ModBlocks.GENDERFLUID_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.LESBIAN_STAINED_GLASS, ModBlocks.LESBIAN_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.DEMIBOY_STAINED_GLASS, ModBlocks.DEMIBOY_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.DEMIGIRL_STAINED_GLASS, ModBlocks.DEMIGIRL_STAINED_GLASS_PANE);
        blockStateModelGenerator.registerGlassPane(ModBlocks.GENDERQUEER_STAINED_GLASS, ModBlocks.GENDERQUEER_STAINED_GLASS_PANE);

        blockStateModelGenerator.registerCandle(ModBlocks.RAINBOW_CANDLE, Blocks.CANDLE_CAKE);

        BlockStateModelGenerator.BlockTexturePool rainbow_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAINBOW_PLANKS);
        rainbow_pool.family(ModBlocks.RAINBOW_FAMILY);
        rainbow_pool.stairs(ModBlocks.RAINBOW_STAIRS);
        rainbow_pool.slab(ModBlocks.RAINBOW_SLAB);
        rainbow_pool.button(ModBlocks.RAINBOW_BUTTON);
        rainbow_pool.pressurePlate(ModBlocks.RAINBOW_PRESSURE_PLATE);
        rainbow_pool.fence(ModBlocks.RAINBOW_FENCE);
        rainbow_pool.fenceGate(ModBlocks.RAINBOW_FENCE_GATE);

        blockStateModelGenerator.registerHangingSign(ModBlocks.RAINBOW_PLANKS, ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN);

        BlockStateModelGenerator.BlockTexturePool rainbow_bricks_pool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAINBOW_BRICKS);
        rainbow_bricks_pool.stairs(ModBlocks.RAINBOW_BRICK_STAIRS);
        rainbow_bricks_pool.slab(ModBlocks.RAINBOW_BRICK_SLAB);
        rainbow_bricks_pool.wall(ModBlocks.RAINBOW_BRICK_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.RAINBOW_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.RAINBOW_TRAPDOOR);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAINBOW_DYE, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAINBOW_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AGENDER_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.AROMANTIC_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASEXUAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BISEXUAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMIBOY_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMIGIRL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEMISEXUAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GENDERFLUID_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.GENDERQUEER_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.LESBIAN_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.NONBINARY_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANSEXUAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.POLYSEXUAL_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PROGRESS_PRIDE_ELYTRA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TRANS_ELYTRA, Models.GENERATED);

        itemModelGenerator.registerArmor(ModItems.RAINBOW_HELMET);
        itemModelGenerator.registerArmor(ModItems.RAINBOW_CHESTPLATE);
        itemModelGenerator.registerArmor(ModItems.RAINBOW_LEGGINGS);
        itemModelGenerator.registerArmor(ModItems.RAINBOW_BOOTS);

        itemModelGenerator.register(ModItems.RAINBOW_AXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_HOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_PICKAXE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_SHOVEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_SWORD, Models.GENERATED);

        itemModelGenerator.register(ModItems.RAINBOW_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_CHEST_BOAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAINBOW_SHEEP_SPAWN_EGG, Models.GENERATED);
    }
}