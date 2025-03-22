package com.finallion.graveyard.mixin;

import com.finallion.graveyard.blockentities.GravestoneBlockEntity;
import com.finallion.graveyard.client.gui.GravestoneScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(method = "openTextEdit", at = @At(value = "HEAD"), cancellable = true)
    public void openTextEdit(SignBlockEntity signEntity, boolean isFrontText, CallbackInfo info) {
        if (signEntity instanceof GravestoneBlockEntity gravestoneBlockEntity) {
            Minecraft.getInstance().setScreen(new GravestoneScreen(gravestoneBlockEntity, isFrontText, Minecraft.getInstance().isTextFilteringEnabled()));
            info.cancel();
        }
    }
}
