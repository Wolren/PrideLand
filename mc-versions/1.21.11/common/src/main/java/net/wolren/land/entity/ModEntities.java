package net.wolren.land.entity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ModEntities {
    // On Forge, ALL registrations must be deferred to their respective RegisterEvents.
    // Otherwise class loading during ITEM event triggers BLOCK_ENTITY_TYPE registration.
    private static final boolean DEFER = initDefer();

    private static boolean initDefer() {
        try {
            Class.forName("net.minecraftforge.fml.ModList");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static BlockEntityType<RainbowCraftingBlockEntity> RAINBOW_CRAFTING_BLOCK_ENTITY;
    public static EntityType<MonoColorSheep.RainbowSheepEntity> RAINBOW_SHEEP;
    public static BlockEntityType<CustomBedBlockEntity> CUSTOM_BED_BLOCK_ENTITY;

    static {
        if (DEFER) {
            BlockEntityTypeQueue.PENDING.add(() -> {
                RAINBOW_CRAFTING_BLOCK_ENTITY = createCraftingBlockEntity();
            });
        } else {
            RAINBOW_CRAFTING_BLOCK_ENTITY = createCraftingBlockEntity();
        }
    }

    static {
        if (DEFER) {
            EntityTypeQueue.PENDING.add(() -> {
                RAINBOW_SHEEP = createRainbowSheep();
            });
        } else {
            RAINBOW_SHEEP = createRainbowSheep();
        }
    }

    static {
        if (DEFER) {
            BlockEntityTypeQueue.PENDING.add(() -> {
                CUSTOM_BED_BLOCK_ENTITY = createCustomBedBlockEntity();
            });
        } else {
            CUSTOM_BED_BLOCK_ENTITY = createCustomBedBlockEntity();
        }
    }

    private static BlockEntityType<RainbowCraftingBlockEntity> createCraftingBlockEntity() {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(LandCommon.MOD_ID, "rainbow_workstation"),
                new BlockEntityType<>(
                        RainbowCraftingBlockEntity::new,
                        Set.of(ModBlocks.RAINBOW_CRAFTING),
                        null
                ));
    }

    @SuppressWarnings("unchecked")
    private static EntityType<MonoColorSheep.RainbowSheepEntity> createRainbowSheep() {
        return Registry.register(Registries.ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "rainbow_sheep"),
                EntityType.Builder.create(MonoColorSheep.RainbowSheepEntity::new, SpawnGroup.CREATURE)
                        .setDimensions(0.9f, 1.3f).build("rainbow_sheep"));
    }

    private static BlockEntityType<CustomBedBlockEntity> createCustomBedBlockEntity() {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "bed_block"),
                new BlockEntityType<>(
                        CustomBedBlockEntity::new,
                        new HashSet<>(Arrays.asList(
                                ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED,
                                ModBlocks.NONBINARY_BED, ModBlocks.BISEXUAL_BED,
                                ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                                ModBlocks.DEMISEXUAL_BED, ModBlocks.AGENDER_BED,
                                ModBlocks.PROGRESS_PRIDE_BED, ModBlocks.ASEXUAL_BED,
                                ModBlocks.GENDERFLUID_BED, ModBlocks.LESBIAN_BED,
                                ModBlocks.DEMIBOY_BED, ModBlocks.DEMIGIRL_BED,
                                ModBlocks.GENDERQUEER_BED, ModBlocks.POLYSEXUAL_BED
                        )),
                        null
                ));
    }

    public static void registerBlockEntities() {
        LandCommon.LOGGER.info("Registering Entities for " + LandCommon.MOD_ID);
    }
}
