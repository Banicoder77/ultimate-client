/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.events.world.PlaySoundEvent;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.misc.SoundBlocker;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.sound.TickableSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
    @Shadow
    public abstract void stop(SoundInstance sound);

    @Inject(method = "play(Lnet/minecraft/client/sound/SoundInstance;)Lnet/minecraft/client/sound/SoundSystem$PlayResult;", at = @At("HEAD"), cancellable = true)
    private void onPlay(SoundInstance soundInstance, CallbackInfoReturnable<SoundSystem.PlayResult> cir) {
        PlaySoundEvent event = UltimateClient.EVENT_BUS.post(PlaySoundEvent.get(soundInstance));

        if (event.isCancelled()) cir.cancel();
    }

    @Inject(method = "tick()V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/TickableSoundInstance;tick()V", ordinal = 0))
    private void onTick(CallbackInfo ci, @Local TickableSoundInstance tickableSoundInstance) {
        if (Modules.get().get(SoundBlocker.class).shouldBlock(tickableSoundInstance)) stop(tickableSoundInstance);
    }
}
