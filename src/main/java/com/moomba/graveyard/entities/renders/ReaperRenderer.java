package com.moomba.graveyard.entities.renders;


import com.moomba.graveyard.entities.ReaperEntity;
import com.moomba.graveyard.entities.models.ReaperModel;
import com.moomba.graveyard.entities.renders.features.ReaperEyesFeatureRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;


public class ReaperRenderer extends GeoEntityRenderer<ReaperEntity> {

    public ReaperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ReaperModel());
        this.addRenderLayer(new ReaperEyesFeatureRenderer(this));
        this.shadowRadius = 0.7F;
    }


    // stops the vanilla death animation
    @Override
    protected float getDeathMaxRotation(ReaperEntity entityLivingBaseIn) {
        return 0.0F;
    }

}

