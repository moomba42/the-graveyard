package com.moomba.graveyard.entities.models;

import com.moomba.graveyard.TheGraveyard;
import com.moomba.graveyard.entities.GhoulEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BaseGhoulModel extends GeoModel<GhoulEntity> {

    @Override
    public ResourceLocation getModelResource(GhoulEntity object) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "geo/ghoul.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GhoulEntity object) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "textures/entity/ghoul_skin" + object.getVariant() + ".png");
    }
    @Override
    public ResourceLocation getAnimationResource(GhoulEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "animations/ghoul/ghoul.animation.json");
    }
}
