package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.ArrayList;
import java.util.List;

public class RainbowDyeSerializer extends RecipeSerializer<RainbowDyeRecipe> {
    private static final MapCodec<RainbowDyeRecipe> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    com.mojang.serialization.Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.getGroup()),
                    CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC)
                            .forGetter(recipe -> recipe.getCategory()),
                    ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.getResult()),
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(recipe -> recipe.getIngredients())
            ).apply(instance, RainbowDyeRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, RainbowDyeRecipe> PACKET_CODEC = StreamCodec.of(
            RainbowDyeSerializer::write, RainbowDyeSerializer::read
    );

    private static RainbowDyeRecipe read(RegistryFriendlyByteBuf buf) {
        String group = buf.readUtf();
        CraftingBookCategory category = buf.readEnum(CraftingBookCategory.class);
        ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
        int size = buf.readVarInt();
        List<Ingredient> ingredients = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ingredients.add(Ingredient.CONTENT_STREAM_CODEC.decode(buf));
        }
        return new RainbowDyeRecipe(group, category, result, ingredients);
    }

    private static void write(RegistryFriendlyByteBuf buf, RainbowDyeRecipe recipe) {
        buf.writeUtf(recipe.getGroup());
        buf.writeEnum(recipe.getCategory());
        ItemStack.STREAM_CODEC.encode(buf, recipe.getResult());
        List<Ingredient> ingredients = recipe.getIngredients();
        buf.writeVarInt(ingredients.size());
        for (Ingredient ingredient : ingredients) {
            Ingredient.CONTENT_STREAM_CODEC.encode(buf, ingredient);
        }
    }

    public RainbowDyeSerializer() {
        super(CODEC, PACKET_CODEC);
    }
}
