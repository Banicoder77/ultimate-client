/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.events.ultimate.MouseClickEvent;
import ultimatedevelopment.ultimateclient.events.ultimate.MouseScrollEvent;
import ultimatedevelopment.ultimateclient.utils.misc.input.Input;
import ultimatedevelopment.ultimateclient.utils.misc.input.KeyAction;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.gui.Click;
import net.minecraft.client.input.MouseInput;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

@Mixin(Mouse.class)
public abstract class MouseMixin {
    @Shadow
    public abstract double getScaledX(Window window);

    @Shadow
    public abstract double getScaledY(Window window);

    @Shadow
    @Final
    private MinecraftClient client;

    @Inject(method = "onMouseButton", at = @At("HEAD"), cancellable = true)
    private void onMouseButton(long window, MouseInput mouseInput, int action, CallbackInfo ci) {
        Input.setButtonState(mouseInput.button(), action != GLFW_RELEASE);

        Click click = new Click(getScaledX(client.getWindow()), getScaledY(client.getWindow()), mouseInput);
        if (UltimateClient.EVENT_BUS.post(MouseClickEvent.get(click, KeyAction.get(action))).isCancelled()) ci.cancel();
    }

    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    private void onMouseScroll(long window, double horizontal, double vertical, CallbackInfo info) {
        if (UltimateClient.EVENT_BUS.post(MouseScrollEvent.get(vertical)).isCancelled()) info.cancel();
    }
}
