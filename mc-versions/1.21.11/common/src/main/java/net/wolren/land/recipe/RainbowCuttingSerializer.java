package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codec.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class RainbowCuttingSerializer implements RecipeSerializer<RainbowCuttingRecipe> {
    private static final MapCodec<RainbowCuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
        instance.group(
            Identifier.CODEC.optionalFieldOf("group", Identifier.of("")).forGetter(r -> Identifier.of(r.getGroup())),
            Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient()),
            ItemStack.CODEC.fieldOf("result").forGetter(r -> r.result())
        ).apply(instance, (group, ingredient, result) ->
            new RainbowCuttingRecipe(group.getPath(), ingredient, result))
    );

    @Override
    public MapCodec<RainbowCuttingRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, RainbowCuttingRecipe> packetCodec() {
        return PacketCodec.ofStatic(
            (buf, recipe) -> {
                buf.writeString(recipe.getGroup());
                recipe.ingredient().write(buf);
                ItemStack.PACKET_CODEC.encode(buf, recipe.result());
            },
            buf -> {
                String group = buf.readString();
                Ingredient ingredient = Ingredient.fromPacket(buf);
                ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
                return new RainbowCuttingRecipe(group, ingredient, result);
            }
        );
    }
}
