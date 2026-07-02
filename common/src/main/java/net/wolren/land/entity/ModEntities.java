package net.wolren.land.entity;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ModEntities {
    public static final BlockEntityType<RainbowCraftingBlockEntity> RAINBOW_CRAFTING_BLOCK_ENTITY =
            Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(LandCommon.MOD_ID, "rainbow_workstation"),
                    new BlockEntityType<>(
                            RainbowCraftingBlockEntity::new,
                            Set.of(ModBlocks.RAINBOW_CRAFTING),
                            null
                    ));

    public static final EntityType<MonoColorSheep.RainbowSheepEntity> RAINBOW_SHEEP = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(LandCommon.MOD_ID, "rainbow_sheep"),
            EntityType.Builder.of(MonoColorSheep.RainbowSheepEntity::new, MobCategory.CREATURE)
                    .sized(0.9f, 1.3f).build("rainbow_sheep")
    );

    public static final BlockEntityType<CustomBedBlockEntity> CUSTOM_BED_BLOCK_ENTITY = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE,
            new ResourceLocation(LandCommon.MOD_ID, "bed_block"),
            new BlockEntityType<>(
                    CustomBedBlockEntity::new,
                    new HashSet<>(Arrays.asList(
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
                    )),
                    null
            )
    );

    public static void registerBlockEntities() {
        LandCommon.LOGGER.info("Registering Entities for " + LandCommon.MOD_ID);
    }
}
