package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class RainbowCuttingSerializer extends RecipeSerializer<RainbowCuttingRecipe> {
    public static final MapCodec<RainbowCuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    com.mojang.serialization.Codec.STRING.optionalFieldOf("group", "").forGetter(RainbowCuttingRecipe::getGroup),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(RainbowCuttingRecipe::getIngredient),
                    ItemStack.CODEC.fieldOf("result").forGetter(RainbowCuttingRecipe::getResult)
            ).apply(instance, RainbowCuttingRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, RainbowCuttingRecipe> STREAM_CODEC = StreamCodec.of(
            RainbowCuttingSerializer::write, RainbowCuttingSerializer::read
    );

    private static RainbowCuttingRecipe read(RegistryFriendlyByteBuf buf) {
        String group = buf.readUtf();
        Ingredient ingredient = Ingredient.CONTENT_STREAM_CODEC.decode(buf);
        ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
        return new RainbowCuttingRecipe(group, ingredient, result);
    }

    private static void write(RegistryFriendlyByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeUtf(recipe.getGroup());
        Ingredient.CONTENT_STREAM_CODEC.encode(buf, recipe.getIngredient());
        ItemStack.STREAM_CODEC.encode(buf, recipe.getResult());
    }

    public RainbowCuttingSerializer() {
        super(CODEC, STREAM_CODEC);
    }
}
