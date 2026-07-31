package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class RainbowCuttingSerializer {
    public static final MapCodec<RainbowCuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    RainbowCuttingRecipe.CommonInfo.MAP_CODEC.fieldOf("common_info").forGetter(RainbowCuttingRecipe::commonInfo),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(RainbowCuttingRecipe::input),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(RainbowCuttingRecipe::resultTemplate)
            ).apply(instance, RainbowCuttingRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, RainbowCuttingRecipe> STREAM_CODEC = StreamCodec.of(
            RainbowCuttingSerializer::write, RainbowCuttingSerializer::read
    );

    public static final RecipeSerializer<RainbowCuttingRecipe> INSTANCE = new RecipeSerializer<>(CODEC, STREAM_CODEC);

    private static RainbowCuttingRecipe read(RegistryFriendlyByteBuf buf) {
        String group = buf.readUtf();
        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
        ItemStackTemplate result = ItemStackTemplate.STREAM_CODEC.decode(buf);
        return new RainbowCuttingRecipe(new RainbowCuttingRecipe.CommonInfo(group), ingredient, result);
    }

    private static void write(RegistryFriendlyByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeUtf(recipe.group());
        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.input());
        ItemStackTemplate.STREAM_CODEC.encode(buf, recipe.resultTemplate());
    }

    private RainbowCuttingSerializer() {}
}
