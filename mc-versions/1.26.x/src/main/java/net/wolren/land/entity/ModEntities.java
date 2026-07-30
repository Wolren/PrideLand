package net.wolren.land.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;

public class ModEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PrideLand.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, PrideLand.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RainbowCraftingBlockEntity>> RAINBOW_CRAFTING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("rainbow_workstation", () ->
                    new BlockEntityType<>(RainbowCraftingBlockEntity::new, Set.of(ModBlocks.RAINBOW_CRAFTING.get()), null));

    public static final DeferredHolder<EntityType<?>, EntityType<MonoColorSheep.RainbowSheepEntity>> RAINBOW_SHEEP =
            ENTITY_TYPES.register("rainbow_sheep", () ->
                    EntityType.Builder.of(MonoColorSheep.RainbowSheepEntity::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.3f).build("rainbow_sheep"));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CustomBedBlockEntity>> CUSTOM_BED_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("bed_block", () ->
                    new BlockEntityType<>(CustomBedBlockEntity::new,
                            Set.of(
                            ModBlocks.RAINBOW_BED.get(), ModBlocks.TRANS_BED.get(),
                            ModBlocks.NONBINARY_BED.get(), ModBlocks.BISEXUAL_BED.get(),
                            ModBlocks.PANSEXUAL_BED.get(), ModBlocks.AROMANTIC_BED.get(),
                            ModBlocks.ASEXUAL_BED.get(), ModBlocks.DEMIBOY_BED.get(),
                            ModBlocks.DEMIGIRL_BED.get(), ModBlocks.DEMISEXUAL_BED.get(),
                            ModBlocks.GENDERFLUID_BED.get(), ModBlocks.GENDERQUEER_BED.get(),
                            ModBlocks.LESBIAN_BED.get(), ModBlocks.PROGRESS_PRIDE_BED.get(),
                            ModBlocks.AGENDER_BED.get(), ModBlocks.POLYSEXUAL_BED.get()
                    ), null));

    private static final class Set {
        @SafeVarargs
        static <T> java.util.Set<T> of(T... items) {
            return java.util.Set.of(items);
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
        ENTITY_TYPES.register(eventBus);
    }
}
