package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.collection.DefaultedList;

public class RainbowDyeSerializer implements RecipeSerializer<RainbowDyeRecipe> {
    private static final MapCodec<RainbowDyeRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(RainbowDyeRecipe::getGroup),
            ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result),
            Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(r -> r.ingredients)
    ).apply(instance, (group, result, ingredients) -> {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.addAll(ingredients);
        return new RainbowDyeRecipe(group, result, list);
    }));

    @Override
    public MapCodec<RainbowDyeRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, RainbowDyeRecipe> packetCodec() {
        return new PacketCodec<RegistryByteBuf, RainbowDyeRecipe>() {
            @Override
            public RainbowDyeRecipe decode(RegistryByteBuf buf) {
                String group = buf.readString();
                int i = buf.readVarInt();
                DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(i, Ingredient.EMPTY);
                for (int j = 0; j < ingredients.size(); j++) {
                    ingredients.set(j, Ingredient.PACKET_CODEC.decode(buf));
                }
                ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
                return new RainbowDyeRecipe(group, output, ingredients);
            }

            @Override
            public void encode(RegistryByteBuf buf, RainbowDyeRecipe recipe) {
                buf.writeString(recipe.getGroup());
                DefaultedList<Ingredient> ingredients = recipe.getIngredients();
                buf.writeVarInt(ingredients.size());
                for (Ingredient ingredient : ingredients) {
                    Ingredient.PACKET_CODEC.encode(buf, ingredient);
                }
                ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
            }
        };
    }
}
