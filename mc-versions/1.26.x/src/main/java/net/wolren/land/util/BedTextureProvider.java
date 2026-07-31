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
            ModBlocks.RAINBOW_BED.get(),
            ModBlocks.TRANS_BED.get(),
            ModBlocks.NONBINARY_BED.get(),
            ModBlocks.BISEXUAL_BED.get(),
            ModBlocks.PANSEXUAL_BED.get(),
            ModBlocks.AROMANTIC_BED.get(),
            ModBlocks.DEMISEXUAL_BED.get(),
            ModBlocks.AGENDER_BED.get(),
            ModBlocks.PROGRESS_PRIDE_BED.get(),
            ModBlocks.ASEXUAL_BED.get(),
            ModBlocks.GENDERFLUID_BED.get(),
            ModBlocks.LESBIAN_BED.get(),
            ModBlocks.DEMIBOY_BED.get(),
            ModBlocks.DEMIGIRL_BED.get(),
            ModBlocks.GENDERQUEER_BED.get(),
            ModBlocks.POLYSEXUAL_BED.get()
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
