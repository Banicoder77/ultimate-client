/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import com.mojang.blaze3d.opengl.GlStateManager;
import ultimatedevelopment.ultimateclient.mixininterface.ICapabilityTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GlStateManager.CapabilityTracker.class)
public abstract class CapabilityTrackerMixin implements ICapabilityTracker {
    @Shadow
    private boolean state;

    @Shadow
    public abstract void setState(boolean state);

    @Override
    public boolean meteor$get() {
        return state;
    }

    @Override
    public void meteor$set(boolean state) {
        setState(state);
    }
}
