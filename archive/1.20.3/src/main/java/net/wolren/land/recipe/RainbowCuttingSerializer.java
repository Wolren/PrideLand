package net.wolren.land.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;

public class RainbowCuttingSerializer extends CuttingRecipe.Serializer<RainbowCuttingRecipe> {
    protected RainbowCuttingSerializer(CuttingRecipe.RecipeFactory<RainbowCuttingRecipe> recipeFactory) {
        super(recipeFactory);
    }

    @Override
    public RainbowCuttingRecipe read(PacketByteBuf buf) {
        String group = buf.readString();
        Ingredient ingredient = Ingredient.fromPacket(buf);
        ItemStack result = buf.readItemStack();
        return new RainbowCuttingRecipe(group, ingredient, result);
    }

    @Override
    public void write(PacketByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeString(recipe.getGroup());
        recipe.getIngredient().write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
