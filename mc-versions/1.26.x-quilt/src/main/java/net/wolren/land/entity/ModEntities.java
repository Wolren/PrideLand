package net.wolren.land.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;

import java.util.Set;

public class ModEntities {
    private static final boolean DEFER = false; // Always false on Fabric

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
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_workstation"),
                new BlockEntityType<>(RainbowCraftingBlockEntity::new,
                        Set.of(ModBlocks.RAINBOW_CRAFTING)));
    }

    @SuppressWarnings("unchecked")
    private static EntityType<MonoColorSheep.RainbowSheepEntity> createRainbowSheep() {
        Identifier id = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep");
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id,
                EntityType.Builder.of(MonoColorSheep.RainbowSheepEntity::new, MobCategory.CREATURE)
                        .sized(0.9f, 1.3f).build(ResourceKey.create(Registries.ENTITY_TYPE, id)));
    }

    private static BlockEntityType<CustomBedBlockEntity> createCustomBedBlockEntity() {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "bed_block"),
                new BlockEntityType<>(CustomBedBlockEntity::new,
                        Set.of(ModBlocks.RAINBOW_BED, ModBlocks.TRANS_BED,
                                ModBlocks.NONBINARY_BED, ModBlocks.BISEXUAL_BED,
                                ModBlocks.PANSEXUAL_BED, ModBlocks.AROMANTIC_BED,
                                ModBlocks.ASEXUAL_BED, ModBlocks.DEMIBOY_BED,
                                ModBlocks.DEMIGIRL_BED, ModBlocks.DEMISEXUAL_BED,
                                ModBlocks.GENDERFLUID_BED, ModBlocks.GENDERQUEER_BED,
                                ModBlocks.LESBIAN_BED, ModBlocks.PROGRESS_PRIDE_BED,
                                ModBlocks.AGENDER_BED, ModBlocks.POLYSEXUAL_BED)));
    }

    public static void registerBlockEntities() {
        PrideLand.LOGGER.info("Registering Entities for " + PrideLand.MOD_ID);
    }
}
