package net.wolren.land.recipe;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class RainbowCuttingSerializer implements RecipeSerializer<RainbowCuttingRecipe> {
    private final int DEFAULT_GROUP_MAX = 1;

    @Override
    public RainbowCuttingRecipe read(Identifier id, JsonObject json) {
        String group = JsonHelper.getString(json, "group", "");
        Ingredient input = Ingredient.fromJson(JsonHelper.getObject(json, "ingredient"));
        ItemStack output = net.minecraft.recipe.ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
        return new RainbowCuttingRecipe(id, group, input, output);
    }

    @Override
    public RainbowCuttingRecipe read(Identifier id, PacketByteBuf buf) {
        String group = buf.readString();
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new RainbowCuttingRecipe(id, group, input, output);
    }

    @Override
    public void write(PacketByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeString(recipe.getGroup());
        recipe.getIngredients().get(0).write(buf);
        buf.writeItemStack(recipe.getOutput(null));
    }
}
