package com.moomba.graveyard.blockentities.models;

import com.moomba.graveyard.TheGraveyard;
import com.moomba.graveyard.blockentities.BrazierBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BrazierModel extends GeoModel<BrazierBlockEntity> {
    @Override
    public ResourceLocation getAnimationResource(BrazierBlockEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID,"animations/brazier.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(BrazierBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "geo/brazier.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BrazierBlockEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "textures/block/brazier.png");
    }
}
