package net.wolren.land.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;

public class ModEntities {
    public static final BlockEntityType<RainbowCraftingBlockEntity> RAINBOW_CRAFTING_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Land.MOD_ID, "rainbow_workstation"),
                    FabricBlockEntityTypeBuilder.create(RainbowCraftingBlockEntity::new,
                            ModBlocks.RAINBOW_CRAFTING).build());
    public static final EntityType<MonoColorSheep.RainbowSheepEntity> RAINBOW_SHEEP = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(Land.MOD_ID, "rainbow_sheep"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MonoColorSheep.RainbowSheepEntity::new).dimensions(EntityDimensions.fixed(0.9f, 1.3f)).build()
    );

    public static final BlockEntityType<CustomBedBlockEntity> CUSTOM_BED_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(Land.MOD_ID, "bed_block"),
            FabricBlockEntityTypeBuilder.create(CustomBedBlockEntity::new,
                    ModBlocks.RAINBOW_BED,
                    ModBlocks.TRANS_BED,
                    ModBlocks.NONBINARY_BED,
                    ModBlocks.BISEXUAL_BED,
                    ModBlocks.PANSEXUAL_BED,
                    ModBlocks.AROMANTIC_BED,
                    ModBlocks.DEMISEXUAL_BED,
                    ModBlocks.AGENDER_BED,
                    ModBlocks.PROGRESS_PRIDE_BED,
                    ModBlocks.ASEXUAL_BED,
                    ModBlocks.GENDERFLUID_BED,
                    ModBlocks.LESBIAN_BED,
                    ModBlocks.DEMIBOY_BED,
                    ModBlocks.DEMIGIRL_BED,
                    ModBlocks.GENDERQUEER_BED,
                    ModBlocks.POLYSEXUAL_BED
            ).build()
    );

    public static void registerBlockEntities() {
        Land.LOGGER.info("Registering Entities for " + Land.MOD_ID);
    }
}