/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.renderer.UltimateRenderPipelines;
import net.minecraft.client.gl.ShaderLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShaderLoader.class)
public abstract class ShaderLoaderMixin {
    @Inject(method = "apply(Lnet/minecraft/client/gl/ShaderLoader$Definitions;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("TAIL"))
    private void meteor$reloadPipelines(CallbackInfo info) {
        UltimateRenderPipelines.precompile();
    }
}
