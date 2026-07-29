package net.wolren.land.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RainbowDyeSerializer implements RecipeSerializer<RainbowDyeRecipe> {
    private static final MapCodec<RainbowDyeRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.getGroup()),
                    CraftingRecipeCategory.CODEC.fieldOf("category").orElse(CraftingRecipeCategory.MISC)
                            .forGetter(recipe -> recipe.getCategory()),
                    ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.getResult()),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(recipe -> recipe.getIngredients())
            ).apply(instance, RainbowDyeRecipe::new)
    );

    public static final PacketCodec<RegistryByteBuf, RainbowDyeRecipe> PACKET_CODEC = PacketCodec.ofStatic(
            RainbowDyeSerializer::write, RainbowDyeSerializer::read
    );

    private static RainbowDyeRecipe read(RegistryByteBuf buf) {
        String group = buf.readString();
        CraftingRecipeCategory category = buf.readEnumConstant(CraftingRecipeCategory.class);
        ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
        int size = buf.readVarInt();
        List<Ingredient> ingredients = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.PACKET_CODEC.decode(buf));
        }
        return new RainbowDyeRecipe(group, category, result, ingredients);
    }

    private static void write(RegistryByteBuf buf, RainbowDyeRecipe recipe) {
        buf.writeString(recipe.getGroup());
        buf.writeEnumConstant(recipe.getCategory());
        ItemStack.PACKET_CODEC.encode(buf, recipe.getResult());
        List<Ingredient> ingredients = recipe.getIngredients();
        buf.writeVarInt(ingredients.size());
        for (Ingredient ingredient : ingredients) {
            Ingredient.PACKET_CODEC.encode(buf, ingredient);
        }
    }

    @Override
    public MapCodec<RainbowDyeRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, RainbowDyeRecipe> packetCodec() {
        return PACKET_CODEC;
    }
}
