package net.wolren.land.recipe;

import com.google.gson.JsonObject;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.core.NonNullList;

public class RainbowCuttingSerializer implements RecipeSerializer<RainbowCuttingRecipe> {
    private final int DEFAULT_GROUP_MAX = 1;

    @Override
    public RainbowCuttingRecipe fromJson(ResourceLocation id, JsonObject json) {
        String group = GsonHelper.getAsString(json, "group", "");
        Ingredient input = Ingredient.fromJson(GsonHelper.getAsJsonObject(json, "ingredient"));
        ItemStack output = net.minecraft.world.item.crafting.ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        return new RainbowCuttingRecipe(id, group, input, output);
    }

    @Override
    public RainbowCuttingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
        String group = buf.readUtf();
        Ingredient input = Ingredient.fromNetwork(buf);
        ItemStack output = buf.readItem();
        return new RainbowCuttingRecipe(id, group, input, output);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeUtf(recipe.getGroup());
        recipe.getIngredients().get(0).toNetwork(buf);
        buf.writeItem(recipe.getResultItem(null));
    }
}
