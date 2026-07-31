package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

import java.util.Optional;

public class RainbowCuttingSerializer implements RecipeSerializer<RainbowCuttingRecipe> {
    private static final Codec<RainbowCuttingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.STRING.optionalFieldOf("group", "").forGetter(RainbowCuttingRecipe::getGroup),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
            ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result)
    ).apply(instance, (group, ingredient, result) -> {
        return new RainbowCuttingRecipe(group, ingredient, result);
    }));

    @Override
    public Codec<RainbowCuttingRecipe> codec() {
        return CODEC;
    }

    @Override
    public RainbowCuttingRecipe read(PacketByteBuf buf) {
        String group = buf.readString();
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new RainbowCuttingRecipe(group, input, output);
    }

    @Override
    public void write(PacketByteBuf buf, RainbowCuttingRecipe recipe) {
        buf.writeString(recipe.getGroup());
        recipe.ingredient.write(buf);
        buf.writeItemStack(recipe.getOutput());
    }
}
