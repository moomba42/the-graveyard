package com.finallion.graveyard.entities.models;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.entities.FallingCorpse;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FallingCorpseModel extends GeoModel<FallingCorpse> {

    @Override
    public ResourceLocation getModelResource(FallingCorpse object) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "geo/falling_corpse.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FallingCorpse object) {
        return ResourceLocation.withDefaultNamespace("textures/entity/skeleton/stray.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FallingCorpse animatable) {
        return ResourceLocation.fromNamespaceAndPath(TheGraveyard.MOD_ID, "animations/falling_corpse/falling_corpse.animation.json");
    }
}
