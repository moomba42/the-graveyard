package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.world.structures.TGJigsawStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class TGStructureType {
    public static final StructureType<TGJigsawStructure> TG_JIGSAW = register("tg_jigsaw", TGJigsawStructure.CODEC);

    private static <S extends Structure> StructureType<S> register(String path, MapCodec<S> codec) {
        return Registry.register(
                BuiltInRegistries.STRUCTURE_TYPE,
                ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, path),
                () -> codec);
    }
}
