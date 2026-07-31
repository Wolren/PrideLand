package net.wolren.land.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.RecipeBookCategories;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import net.minecraft.world.level.Level;

public class RainbowCuttingRecipe extends StonecutterRecipe {
    private final String group;
    private final ItemStackTemplate resultTemplate;
    private final CommonInfo commonInfo;

    public RainbowCuttingRecipe(CommonInfo commonInfo, Ingredient ingredient, ItemStackTemplate result) {
        super(commonInfo.toRecipeCommonInfo(), ingredient, result);
        this.group = commonInfo.group;
        this.resultTemplate = result;
        this.commonInfo = commonInfo;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecipeSerializer<StonecutterRecipe> getSerializer() {
        return (RecipeSerializer<StonecutterRecipe>)(RecipeSerializer<?>) ModSerializers.RAINBOW_CUTTING_SERIALIZER;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RecipeType<StonecutterRecipe> getType() {
        return (RecipeType<StonecutterRecipe>)(RecipeType<?>) net.wolren.land.PrideLand.RAINBOW_CUTTING;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(this.input());
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.STONECUTTER;
    }

    @Override
    public String group() {
        return this.group;
    }

    public CommonInfo commonInfo() {
        return this.commonInfo;
    }

    public ItemStackTemplate resultTemplate() {
        return this.resultTemplate;
    }

    public ItemStack getResult() {
        return this.result().create();
    }

    public Ingredient getIngredient() {
        return this.input();
    }

    public static class CommonInfo {
        public final String group;

        public CommonInfo(String group) {
            this.group = group;
        }

        public static final com.mojang.serialization.MapCodec<CommonInfo> MAP_CODEC = com.mojang.serialization.codecs.RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                        com.mojang.serialization.Codec.STRING.optionalFieldOf("group", "").forGetter(info -> info.group)
                ).apply(instance, CommonInfo::new)
        );

        public net.minecraft.world.item.crafting.Recipe.CommonInfo toRecipeCommonInfo() {
            return new net.minecraft.world.item.crafting.Recipe.CommonInfo(true);
        }
    }
}
