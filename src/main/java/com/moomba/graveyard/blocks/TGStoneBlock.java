package com.moomba.graveyard.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class TGStoneBlock extends Block {

    private final Supplier<Block> clickedBlock;

    public TGStoneBlock(Supplier<Block> clickedBlock, Properties settings) {
        super(settings);
        this.clickedBlock = clickedBlock;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(clickedBlock.get());
    }


}
