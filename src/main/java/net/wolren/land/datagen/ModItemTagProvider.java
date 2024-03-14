package net.wolren.land.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.item.ModItems;
import net.wolren.land.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.ELYTRA_ITEMS)
                .add(ModItems.RAINBOW_ELYTRA)
                .add(ModItems.AGENDER_ELYTRA)
                .add(ModItems.AROMANTIC_ELYTRA)
                .add(ModItems.ASEXUAL_ELYTRA)
                .add(ModItems.BISEXUAL_ELYTRA)
                .add(ModItems.DEMIBOY_ELYTRA)
                .add(ModItems.DEMIGIRL_ELYTRA)
                .add(ModItems.DEMISEXUAL_ELYTRA)
                .add(ModItems.GENDERFLUID_ELYTRA)
                .add(ModItems.GENDERQUEER_ELYTRA)
                .add(ModItems.LESBIAN_ELYTRA)
                .add(ModItems.NONBINARY_ELYTRA)
                .add(ModItems.PANSEXUAL_ELYTRA)
                .add(ModItems.POLYSEXUAL_ELYTRA)
                .add(ModItems.PROGRESS_PRIDE_ELYTRA)
                .add(ModItems.TRANS_ELYTRA);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RAINBOW_HELMET)
                .add(ModItems.RAINBOW_CHESTPLATE)
                .add(ModItems.RAINBOW_LEGGINGS)
                .add(ModItems.RAINBOW_BOOTS);

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.RAINBOW_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.BOATS)
                .add(ModItems.RAINBOW_BOAT);


        getOrCreateTagBuilder(ItemTags.CHEST_BOATS)
                .add(ModItems.RAINBOW_CHEST_BOAT);
    }
}
