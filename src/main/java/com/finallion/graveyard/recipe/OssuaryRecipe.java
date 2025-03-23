package com.finallion.graveyard.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

public class OssuaryRecipe extends CarvingRecipe {

    public OssuaryRecipe(String group, Ingredient ingredient, ItemStack stack) {
        super(TGRecipeTypes.OSSUARY_CARVING.get(), TGRecipeTypes.OSSUARY_CARVING_SERIALIZER.get(), group, ingredient, stack);
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level) {
        return this.ingredient.test(singleRecipeInput.getItem(0));
    }

    // TODO: Not used anywhere, reintroduce if necessary or delete
//    @Override
//    public ItemStack getToastSymbol() {
//        return new ItemStack(TGBlocks.LEANING_SKELETON.get());
//    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
