package net.wolren.land.mixin;

import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(RenderLayers.class)
public interface RenderLayersAccessor {
    @Accessor("BLOCKS")
    static Map<Block, RenderLayer> prideLand$getBlocks() {
        throw new AssertionError();
    }
}
