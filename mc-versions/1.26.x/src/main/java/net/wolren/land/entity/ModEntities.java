package net.wolren.land.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.wolren.land.PrideLand;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import net.wolren.land.entity.custom.block.RainbowCraftingBlockEntity;
import net.wolren.land.entity.custom.living.MonoColorSheep;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PrideLand.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.createEntities(PrideLand.MOD_ID);

    public static final ResourceKey<BlockEntityType<?>> RAINBOW_CRAFTING_BLOCK_ENTITY_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE.key(),
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_workstation"));

    public static final Supplier<BlockEntityType<RainbowCraftingBlockEntity>> RAINBOW_CRAFTING_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("rainbow_workstation", () ->
                    new BlockEntityType<>(RainbowCraftingBlockEntity::new, ModBlocks.RAINBOW_CRAFTING.get()));

    public static final ResourceKey<EntityType<?>> RAINBOW_SHEEP_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "rainbow_sheep"));

    public static final Supplier<EntityType<MonoColorSheep.RainbowSheepEntity>> RAINBOW_SHEEP =
            ENTITY_TYPES.register("rainbow_sheep", () ->
                    EntityType.Builder.of(MonoColorSheep.RainbowSheepEntity::new, MobCategory.CREATURE)
                            .sized(0.9f, 1.3f).build(RAINBOW_SHEEP_KEY));

    public static final ResourceKey<BlockEntityType<?>> CUSTOM_BED_BLOCK_ENTITY_KEY = ResourceKey.create(
            BuiltInRegistries.BLOCK_ENTITY_TYPE.key(),
            Identifier.fromNamespaceAndPath(PrideLand.MOD_ID, "bed_block"));

    public static final Supplier<BlockEntityType<CustomBedBlockEntity>> CUSTOM_BED_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("bed_block", () ->
                    new BlockEntityType<>(CustomBedBlockEntity::new,
                            ModBlocks.RAINBOW_BED.get(), ModBlocks.TRANS_BED.get(),
                            ModBlocks.NONBINARY_BED.get(), ModBlocks.BISEXUAL_BED.get(),
                            ModBlocks.PANSEXUAL_BED.get(), ModBlocks.AROMANTIC_BED.get(),
                            ModBlocks.ASEXUAL_BED.get(), ModBlocks.DEMIBOY_BED.get(),
                            ModBlocks.DEMIGIRL_BED.get(), ModBlocks.DEMISEXUAL_BED.get(),
                            ModBlocks.GENDERFLUID_BED.get(), ModBlocks.GENDERQUEER_BED.get(),
                            ModBlocks.LESBIAN_BED.get(), ModBlocks.PROGRESS_PRIDE_BED.get(),
                            ModBlocks.AGENDER_BED.get(), ModBlocks.POLYSEXUAL_BED.get()
                    ));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
        ENTITY_TYPES.register(eventBus);
    }
}
