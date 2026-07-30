package net.wolren.land.recipe;

import net.minecraft.world.item.crafting.SingleItemRecipe;

public class RainbowCuttingSerializer extends SingleItemRecipe.Serializer<RainbowCuttingRecipe> {
    public RainbowCuttingSerializer() {
        super(RainbowCuttingRecipe::new);
    }
}
