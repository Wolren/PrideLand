package net.wolren.land.recipe;

import net.minecraft.recipe.SingleStackRecipe;

public class RainbowCuttingSerializer extends SingleStackRecipe.Serializer<RainbowCuttingRecipe> {
    public RainbowCuttingSerializer() {
        super(RainbowCuttingRecipe::new);
    }
}
