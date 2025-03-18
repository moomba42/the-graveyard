package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.blockentities.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class TGTileEntities {

    public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, TheGraveyard.MOD_ID);

    public static final DeferredHolder<BlockEntityType<OssuaryBlockEntity>, BlockEntityType<OssuaryBlockEntity>> OSSUARY_BLOCK_ENTITY = register("ossuary_block_entity", () -> BlockEntityType.Builder.of(OssuaryBlockEntity::new,
            TGBlocks.OSSUARY.get()).build(null));

    public static final DeferredHolder<BlockEntityType<GravestoneBlockEntity>, BlockEntityType<GravestoneBlockEntity>> GRAVESTONE_BLOCK_ENTITY = register("gravestone_block_entity", () -> BlockEntityType.Builder.of(GravestoneBlockEntity::new,
            TGBlocks.GRAVESTONE.get(),
            TGBlocks.DEEPSLATE_GRAVESTONE.get(),
            TGBlocks.MOSSY_COBBLESTONE_GRAVESTONE.get(),
            TGBlocks.COBBLESTONE_GRAVESTONE.get(),
            TGBlocks.BLACKSTONE_GRAVESTONE.get(),
            TGBlocks.CRACKED_BLACKSTONE_GRAVESTONE.get(),
            TGBlocks.STONE_BRICKS_GRAVESTONE.get(),
            TGBlocks.MOSSY_STONE_BRICKS_GRAVESTONE.get(),
            TGBlocks.BRICKS_GRAVESTONE.get(),
            TGBlocks.QUARTZ_BRICKS_GRAVESTONE.get(),
            TGBlocks.RED_SANDSTONE_GRAVESTONE.get(),
            TGBlocks.SANDSTONE_GRAVESTONE.get(),
            TGBlocks.GILDED_BLACKSTONE_GRAVESTONE.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<UrnBlockEntity>, BlockEntityType<UrnBlockEntity>> URN_BLOCK_ENTITY = register("urn_block_entity", () -> BlockEntityType.Builder.of(UrnBlockEntity::new,  TGBlocks.BLACK_URN.get(),
            TGBlocks.BLUE_URN.get(),
            TGBlocks.LIGHT_BLUE_URN.get(),
            TGBlocks.CYAN_URN.get(),
            TGBlocks.BROWN_URN.get(),
            TGBlocks.GRAY_URN.get(),
            TGBlocks.LIGHT_GRAY_URN.get(),
            TGBlocks.PURPLE_URN.get(),
            TGBlocks.MAGENTA_URN.get(),
            TGBlocks.PINK_URN.get(),
            TGBlocks.RED_URN.get(),
            TGBlocks.YELLOW_URN.get(),
            TGBlocks.ORANGE_URN.get(),
            TGBlocks.GREEN_URN.get(),
            TGBlocks.LIME_URN.get(),
            TGBlocks.WHITE_URN.get()).build(null));

    public static final DeferredHolder<BlockEntityType<SarcophagusBlockEntity>, BlockEntityType<SarcophagusBlockEntity>> SARCOPHAGUS_BLOCK_ENTITY = register("sarcophagus_block_entity", () -> BlockEntityType.Builder.of(SarcophagusBlockEntity::new,
            TGBlocks.SARCOPHAGUS.get(),
            TGBlocks.OAK_COFFIN.get(),
            TGBlocks.DARK_OAK_COFFIN.get(),
            TGBlocks.ACACIA_COFFIN.get(),
            TGBlocks.JUNGLE_COFFIN.get(),
            TGBlocks.BIRCH_COFFIN.get(),
            TGBlocks.CRIMSON_COFFIN.get(),
            TGBlocks.WARPED_COFFIN.get(),
            TGBlocks.SPRUCE_COFFIN.get(),
            TGBlocks.MANGROVE_COFFIN.get(),
            TGBlocks.BAMBOO_COFFIN.get(),
            TGBlocks.CHERRY_COFFIN.get()
    ).build(null));

    public static final DeferredHolder<BlockEntityType<BrazierBlockEntity>, BlockEntityType<BrazierBlockEntity>> BRAZIER_BLOCK_ENTITY = register("brazier_block_entity", () -> BlockEntityType.Builder.of(BrazierBlockEntity::new,
            TGBlocks.SOUL_FIRE_BRAZIER.get(),
            TGBlocks.FIRE_BRAZIER.get()).build(null));

    private static <T extends BlockEntityType<?>> DeferredHolder<BlockEntityType<?>, T> register(String name, Supplier<T> tileEntity) {
        return TILE_ENTITIES.register(name, tileEntity);
    }



}
