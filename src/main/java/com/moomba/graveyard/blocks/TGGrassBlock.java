package com.moomba.graveyard.blocks;


import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class TGGrassBlock extends GrassBlock {


    public TGGrassBlock(Properties settings) {
        super(settings);
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(Items.GRASS_BLOCK);
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if (ItemAbilities.SHOVEL_FLATTEN == itemAbility) {
            return Blocks.DIRT_PATH.defaultBlockState();
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
