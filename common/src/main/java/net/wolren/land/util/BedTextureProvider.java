package net.wolren.land.util;

import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.wolren.land.LandCommon;
import net.wolren.land.block.ModBlocks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BedTextureProvider {
    public static final List<Block> BEDS = Arrays.asList(
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
    );

    private static final Map<String, Integer> BED_INDEX_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BEDS.size(); i++) {
            String toPut = BEDS.get(i).getDescriptionId();
            BED_INDEX_MAP.put(extractBedName(toPut), i);
        }
    }

    public static final ResourceLocation BEDS_ATLAS = new ResourceLocation("textures/atlas/beds.png");

    public static final Material[] BED_TEXTURES = BEDS.stream()
            .map(bedBlock -> {
                ResourceLocation bedTextureId = new ResourceLocation(LandCommon.MOD_ID, "entity/bed/" + extractBedName(bedBlock.getDescriptionId()));
                return new Material(BEDS_ATLAS, bedTextureId);
            })
            .toArray(Material[]::new);

    public static Material getSpriteIdentifierForBed(Block bedBlock) {
        Integer index = BED_INDEX_MAP.get(extractBedName(bedBlock.getDescriptionId()));
        return index != null ? BED_TEXTURES[index] : null;
    }

    public static String extractBedName(String translationKey) {
        String prefix = "block.pride_land.";
        if (translationKey.startsWith(prefix)) {
            return translationKey.substring(prefix.length());
        }
        return translationKey;
    }
}
