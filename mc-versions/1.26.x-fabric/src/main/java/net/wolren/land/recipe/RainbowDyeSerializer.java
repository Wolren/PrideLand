package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class RainbowDyeSerializer {
    public static final MapCodec<RainbowDyeRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    CraftingRecipe.CraftingBookInfo.MAP_CODEC.fieldOf("book_info").forGetter(RainbowDyeRecipe::getBookInfo),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(RainbowDyeRecipe::getResultTemplate),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(RainbowDyeRecipe::getIngredients)
            ).apply(instance, RainbowDyeRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, RainbowDyeRecipe> PACKET_CODEC = StreamCodec.of(
            RainbowDyeSerializer::write, RainbowDyeSerializer::read
    );

    public static final RecipeSerializer<RainbowDyeRecipe> INSTANCE = new RecipeSerializer<>(CODEC, PACKET_CODEC);

    private static RainbowDyeRecipe read(RegistryFriendlyByteBuf buf) {
        CraftingRecipe.CraftingBookInfo bookInfo = CraftingRecipe.CraftingBookInfo.STREAM_CODEC.decode(buf);
        ItemStackTemplate result = ItemStackTemplate.STREAM_CODEC.decode(buf);
        int size = buf.readVarInt();
        List<Ingredient> ingredients = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
        }
        return new RainbowDyeRecipe(bookInfo, result, ingredients);
    }

    private static void write(RegistryFriendlyByteBuf buf, RainbowDyeRecipe recipe) {
        CraftingRecipe.CraftingBookInfo.STREAM_CODEC.encode(buf, recipe.getBookInfo());
        ItemStackTemplate.STREAM_CODEC.encode(buf, recipe.getResultTemplate());
        List<Ingredient> ingredients = recipe.getIngredients();
        buf.writeVarInt(ingredients.size());
        for (Ingredient ingredient : ingredients) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
        }
    }

    private RainbowDyeSerializer() {}
}
