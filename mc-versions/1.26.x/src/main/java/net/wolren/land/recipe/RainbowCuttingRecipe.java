package net.wolren.land.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;

/**
 * Rainbow cutting recipe for the Rainbow Crafting Station.
 * A stonecutter-style single-input recipe: material + rainbow dye -> rainbow item.
 */
public class RainbowCuttingRecipe extends StonecutterRecipe {
    public static final MapCodec<RainbowCuttingRecipe> MAP_CODEC =
            simpleMapCodec(RainbowCuttingRecipe::new);
    public static final StreamCodec<RegistryFriendlyByteBuf, RainbowCuttingRecipe> STREAM_CODEC =
            simpleStreamCodec(RainbowCuttingRecipe::new);
    public static final RecipeSerializer<RainbowCuttingRecipe> SERIALIZER =
            new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

    public RainbowCuttingRecipe(Recipe.CommonInfo commonInfo, Ingredient ingredient, ItemStackTemplate result) {
        super(commonInfo, ingredient, result);
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.input().test(input.item());
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecipeType<StonecutterRecipe> getType() {
        return (RecipeType<StonecutterRecipe>) (RecipeType<?>) ModRecipeTypes.RAINBOW_CUTTING.get();
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecipeSerializer<StonecutterRecipe> getSerializer() {
        return (RecipeSerializer<StonecutterRecipe>) (RecipeSerializer<?>) SERIALIZER;
    }

    public ItemStack getOutput() {
        return this.result().create();
    }
}
