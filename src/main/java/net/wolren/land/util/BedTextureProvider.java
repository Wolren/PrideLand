package net.wolren.land.util;

import net.minecraft.block.Block;
import net.minecraft.client.render.block.entity.BedBlockEntityRenderer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.wolren.land.Land;
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
            String toPut = BEDS.get(i).getTranslationKey();
            BED_INDEX_MAP.put(extractBedName(toPut), i);
        }
    }

    public static final Identifier BEDS_ATLAS_TEXTURE = new Identifier("textures/atlas/beds.png");

    public static final SpriteIdentifier[] BED_TEXTURES = BEDS.stream()
            .map(bedBlock -> {
                Identifier bedTextureId = new Identifier(Land.MOD_ID, "entity/bed/" + extractBedName(bedBlock.getTranslationKey()));
                return new SpriteIdentifier(BEDS_ATLAS_TEXTURE, bedTextureId);
            })
            .toArray(SpriteIdentifier[]::new);

    public static SpriteIdentifier getSpriteIdentifierForBed(Block bedBlock) {
        Integer index = BED_INDEX_MAP.get(extractBedName(bedBlock.getTranslationKey()));
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