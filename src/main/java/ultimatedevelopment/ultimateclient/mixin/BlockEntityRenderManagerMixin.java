/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.events.render.RenderBlockEntityEvent;
import net.minecraft.client.render.block.entity.BlockEntityRenderManager;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntityRenderManager.class)
public abstract class BlockEntityRenderManagerMixin {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private <S extends BlockEntityRenderState> void onRenderEntity(S renderState, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState arg, CallbackInfo ci) {
        RenderBlockEntityEvent event = UltimateClient.EVENT_BUS.post(RenderBlockEntityEvent.get(renderState));
        if (event.isCancelled()) ci.cancel();
    }
}
