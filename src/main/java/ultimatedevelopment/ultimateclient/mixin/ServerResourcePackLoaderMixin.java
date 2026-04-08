/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.misc.ServerSpoof;
import net.minecraft.client.resource.server.ServerResourcePackLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerResourcePackLoader.class)
public abstract class ServerResourcePackLoaderMixin {
    @Inject(method = "onReloadSuccess", at = @At("TAIL"))
    private void removeInactivePacksTail(CallbackInfo ci) {
        Modules.get().get(ServerSpoof.class).silentAcceptResourcePack = false;
    }
}
