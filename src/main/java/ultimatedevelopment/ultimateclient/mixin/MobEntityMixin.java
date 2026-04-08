/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.movement.EntityControl;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {
    @ModifyReturnValue(method = "hasSaddleEquipped", at = @At("RETURN"))
    private boolean hasSaddleEquipped(boolean original) {
        return Modules.get().get(EntityControl.class).spoofSaddle() || original;
    }
}
