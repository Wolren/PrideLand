package net.wolren.land.util;

import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.resources.ResourceLocation;
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

    private static final Map<String, Integer> BED_INDEX_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BEDS.size(); i++) {
            String toPut = BEDS.get(i).getDescriptionId();
            BED_INDEX_MAP.put(extractBedName(toPut), i);
        }
    }

    public static final ResourceLocation BEDS_ATLAS_TEXTURE = ResourceLocation.withDefaultNamespace("textures/atlas/beds.png");

    public static ResourceLocation getBedTexture(Block bedBlock) {
        String descId = bedBlock.getDescriptionId();
        String name = extractBedName(descId);
        return ResourceLocation.fromNamespaceAndPath(PrideLand.MOD_ID, "entity/bed/" + name);
    }

    public static String extractBedName(String translationKey) {
        String prefix = "block.pride_land.";
        if (translationKey.startsWith(prefix)) {
            return translationKey.substring(prefix.length());
        }
        return translationKey;
    }
}
