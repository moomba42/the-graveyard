package com.moomba.graveyard.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;

import java.util.Objects;

public abstract class CarvingRecipe implements Recipe<SingleRecipeInput> {
    public final Ingredient ingredient;
    public final ItemStack result;
    private final RecipeType<?> type;
    private final RecipeSerializer<?> serializer;
    protected final String group;

    public CarvingRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, String group, Ingredient ingredient, ItemStack result) {
        this.type = type;
        this.serializer = serializer;
        this.group = group;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input, HolderLookup.Provider registries) {
        return this.result.copy();
    }

    public static class Serializer<T extends CarvingRecipe> implements RecipeSerializer<T> {
        final Factory<T> factory;
        private final MapCodec<T> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

        protected Serializer(Factory<T> factory) {
            this.factory = factory;
            this.codec = RecordCodecBuilder.mapCodec(instance -> {
                Objects.requireNonNull(factory);
                return instance.group(
                        Codec.STRING.optionalFieldOf("group", "").forGetter((recipe) -> recipe.group),
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter((recipe) -> recipe.ingredient),
                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter((recipe) -> recipe.result)
                ).apply(instance, factory::create);
            });
            Objects.requireNonNull(factory);
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, (recipe) -> recipe.group,
                    Ingredient.CONTENTS_STREAM_CODEC, (recipe) -> recipe.ingredient,
                    ItemStack.STREAM_CODEC, (recipe) -> recipe.result,
                    factory::create);
        }

        public MapCodec<T> codec() {
            return this.codec;
        }

        public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
            return this.streamCodec;
        }
    }

    public interface Factory<T extends CarvingRecipe> {
        T create(String var1, Ingredient var2, ItemStack var3);
    }
}
