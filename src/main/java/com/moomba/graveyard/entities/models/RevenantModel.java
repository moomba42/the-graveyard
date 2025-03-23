package com.moomba.graveyard.entities.models;

import com.moomba.graveyard.TheGraveyard;
import com.moomba.graveyard.entities.RevenantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RevenantModel extends GeoModel<RevenantEntity> {

    @Override
    public ResourceLocation getModelResource(RevenantEntity object) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "geo/revenant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RevenantEntity object) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "textures/entity/revenant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RevenantEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "animations/revenant/revenant.animation.json");
    }

}
