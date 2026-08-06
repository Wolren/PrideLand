package net.wolren.land.entity;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.HangingSignBlockEntity;
import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.block.RainbowHangingSignBlockEntity;
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
    public static BlockEntityType<SignBlockEntity> RAINBOW_SIGN_BLOCK_ENTITY;
    public static BlockEntityType<RainbowHangingSignBlockEntity> RAINBOW_HANGING_SIGN_BLOCK_ENTITY;

    // Sign block entity types must be registered AFTER the sign blocks are
    // created (they live in LandFabric.registerRainbowSigns, which runs on
    // the platform initializer), so they use a lazy queue on both loaders.
    private static boolean signEntitiesRegistered = false;

    public static void registerSignBlockEntities() {
        if (signEntitiesRegistered) return;
        signEntitiesRegistered = true;
        RAINBOW_SIGN_BLOCK_ENTITY = createSignBlockEntity();
        RAINBOW_HANGING_SIGN_BLOCK_ENTITY = createHangingSignBlockEntity();
    }

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
                new BlockEntityType<RainbowCraftingBlockEntity>(
                        RainbowCraftingBlockEntity::new,
                        Set.of(ModBlocks.RAINBOW_CRAFTING)
                ));
    }

    @SuppressWarnings("unchecked")
    private static EntityType<MonoColorSheep.RainbowSheepEntity> createRainbowSheep() {
        return Registry.register(Registries.ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "rainbow_sheep"),
                EntityType.Builder.create(MonoColorSheep.RainbowSheepEntity::new, SpawnGroup.CREATURE)
                        .dimensions(0.9f, 1.3f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(LandCommon.MOD_ID, "rainbow_sheep"))));
    }

    private static BlockEntityType<CustomBedBlockEntity> createCustomBedBlockEntity() {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "bed_block"),
                new BlockEntityType<CustomBedBlockEntity>(
                        CustomBedBlockEntity::new,
                        Set.of(ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED,
                        ModBlocks.NONBINARY_BED, ModBlocks.BISEXUAL_BED,
                        ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                        ModBlocks.ASEXUAL_BED, ModBlocks.DEMIBOY_BED,
                        ModBlocks.DEMIGIRL_BED, ModBlocks.DEMISEXUAL_BED,
                        ModBlocks.GENDERFLUID_BED, ModBlocks.GENDERQUEER_BED,
                        ModBlocks.LESBIAN_BED, ModBlocks.PROGRESS_PRIDE_BED,
                        ModBlocks.AGENDER_BED, ModBlocks.POLYSEXUAL_BED)
                ));
    }

    private static BlockEntityType<SignBlockEntity> createSignBlockEntity() {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "rainbow_sign"),
                new BlockEntityType<SignBlockEntity>(
                        (pos, state) -> new SignBlockEntity(RAINBOW_SIGN_BLOCK_ENTITY, pos, state),
                        Set.of(ModBlocks.RAINBOW_STANDING_SIGN, ModBlocks.RAINBOW_WALL_SIGN)
                ));
    }

    private static BlockEntityType<RainbowHangingSignBlockEntity> createHangingSignBlockEntity() {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE,
                Identifier.of(LandCommon.MOD_ID, "rainbow_hanging_sign"),
                new BlockEntityType<RainbowHangingSignBlockEntity>(
                        (pos, state) -> new RainbowHangingSignBlockEntity(RAINBOW_HANGING_SIGN_BLOCK_ENTITY, pos, state),
                        Set.of(ModBlocks.RAINBOW_HANGING_SIGN, ModBlocks.RAINBOW_WALL_HANGING_SIGN)
                ));
    }

    public static void registerBlockEntities() {
        LandCommon.LOGGER.info("Registering Entities for " + LandCommon.MOD_ID);
    }
}
