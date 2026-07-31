package net.wolren.land.util;

import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.wolren.land.PrideLand;
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

    private static final Map<String, Identifier> BED_TEXTURE_MAP = new HashMap<>();

    static {
        for (Block bedBlock : BEDS) {
            Identifier textureId = Identifier.fromNamespaceAndPath(PrideLand.MOD_ID,
                    "entity/bed/" + extractBedName(bedBlock.getDescriptionId()));
            BED_TEXTURE_MAP.put(extractBedName(bedBlock.getDescriptionId()), textureId);
        }
    }

    public static Identifier getSpriteIdentifierForBed(Block bedBlock) {
        return BED_TEXTURE_MAP.get(extractBedName(bedBlock.getDescriptionId()));
    }

    public static String extractBedName(String translationKey) {
        String prefix = "block.pride_land.";
        if (translationKey.startsWith(prefix)) {
            return translationKey.substring(prefix.length());
        }
        return translationKey;
    }
}
