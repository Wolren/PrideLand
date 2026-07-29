package net.wolren.land.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;

public class RainbowDyeSerializer implements RecipeSerializer<RainbowDyeRecipe> {
    @Override
    public RainbowDyeRecipe read(Identifier id, JsonObject json) {
        String group = JsonHelper.getString(json, "group", "");
        DefaultedList<Ingredient> ingredients = readIngredients(JsonHelper.getArray(json, "ingredients"));
        ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "result"));
        return new RainbowDyeRecipe(id, group, output, ingredients);
    }

    private static DefaultedList<Ingredient> readIngredients(JsonArray json) {
        DefaultedList<Ingredient> ingredients = DefaultedList.of();
        for (int i = 0; i < json.size(); i++) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i));
            if (!ingredient.isEmpty()) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    @Override
    public RainbowDyeRecipe read(Identifier id, PacketByteBuf buf) {
        String group = buf.readString();
        int i = buf.readVarInt();
        DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(i, Ingredient.EMPTY);
        for (int j = 0; j < ingredients.size(); j++) {
            ingredients.set(j, Ingredient.fromPacket(buf));
        }
        ItemStack output = buf.readItemStack();
        return new RainbowDyeRecipe(id, group, output, ingredients);
    }

    @Override
    public void write(PacketByteBuf buf, RainbowDyeRecipe recipe) {
        buf.writeString(recipe.getGroup());
        DefaultedList<Ingredient> ingredients = recipe.getIngredients();
        buf.writeVarInt(ingredients.size());
        for (Ingredient ingredient : ingredients) {
            ingredient.write(buf);
        }
        buf.writeItemStack(recipe.getOutput(null));
    }
}
