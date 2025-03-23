package com.moomba.graveyard.entities.renders;

import com.moomba.graveyard.client.TheGraveyardClient;
import com.moomba.graveyard.entities.CorruptedPillager;
import com.moomba.graveyard.entities.models.CorruptedIllagerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class CorruptedPillagerRenderer extends CorruptedIllagerRenderer<CorruptedPillager> {
    private static final ResourceLocation TEXTURE = ResourceLocation.parse("graveyard:textures/entity/corrupted_pillager.png");

    public CorruptedPillagerRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new CorruptedIllagerModel<>(ctx.bakeLayer(TheGraveyardClient.CORRUPTED_ILLAGER_MODEL_LAYER)), 0.5F);
        this.model.getHat().visible = false;
    }

    @Override
    public ResourceLocation getTextureLocation(CorruptedPillager p_114482_) {
        return TEXTURE;
    }
}
