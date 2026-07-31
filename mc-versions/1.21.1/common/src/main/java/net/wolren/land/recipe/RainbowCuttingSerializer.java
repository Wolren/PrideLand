package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

public class RainbowCuttingSerializer implements RecipeSerializer<RainbowCuttingRecipe> {
    private static final MapCodec<RainbowCuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(RainbowCuttingRecipe::getGroup),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
            ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result)
    ).apply(instance, (group, ingredient, result) -> {
        return new RainbowCuttingRecipe(group, ingredient, result);
    }));

    @Override
    public MapCodec<RainbowCuttingRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, RainbowCuttingRecipe> packetCodec() {
        return new PacketCodec<RegistryByteBuf, RainbowCuttingRecipe>() {
            @Override
            public RainbowCuttingRecipe decode(RegistryByteBuf buf) {
                String group = buf.readString();
                Ingredient input = Ingredient.PACKET_CODEC.decode(buf);
                ItemStack output = ItemStack.PACKET_CODEC.decode(buf);
                return new RainbowCuttingRecipe(group, input, output);
            }

            @Override
            public void encode(RegistryByteBuf buf, RainbowCuttingRecipe recipe) {
                buf.writeString(recipe.getGroup());
                Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);
                ItemStack.PACKET_CODEC.encode(buf, recipe.result);
            }
        };
    }
}
