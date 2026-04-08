/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import ultimatedevelopment.ultimateclient.renderer.MeshUniforms;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.misc.InventoryTweaks;
import ultimatedevelopment.ultimateclient.utils.render.postprocess.ChamsShader;
import ultimatedevelopment.ultimateclient.utils.render.postprocess.OutlineUniforms;
import ultimatedevelopment.ultimateclient.utils.render.postprocess.PostProcessShader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static ultimatedevelopment.ultimateclient.UltimateClient.mc;

@Mixin(RenderSystem.class)
public abstract class RenderSystemMixin {
    @Inject(method = "flipFrame", at = @At("TAIL"))
    private static void meteor$flipFrame(CallbackInfo info) {
        MeshUniforms.flipFrame();
        PostProcessShader.flipFrame();
        ChamsShader.flipFrame();
        OutlineUniforms.flipFrame();

        if (Modules.get() == null || mc.player == null) return;
        if (Modules.get().get(InventoryTweaks.class).frameInput()) ((MinecraftClientAccessor) mc).meteor$handleInputEvents();
    }
}
