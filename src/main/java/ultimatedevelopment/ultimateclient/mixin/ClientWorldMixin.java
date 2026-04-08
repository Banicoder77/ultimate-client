/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.events.entity.EntityAddedEvent;
import ultimatedevelopment.ultimateclient.events.entity.EntityRemovedEvent;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.render.NoRender;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(ClientWorld.class)
public abstract class ClientWorldMixin {
    @Shadow @Nullable public abstract Entity getEntityById(int id);

    @Inject(method = "addEntity", at = @At("TAIL"))
    private void onAddEntity(Entity entity, CallbackInfo info) {
        if (entity != null) UltimateClient.EVENT_BUS.post(EntityAddedEvent.get(entity));
    }

    @Inject(method = "removeEntity", at = @At("HEAD"))
    private void onRemoveEntity(int entityId, Entity.RemovalReason removalReason, CallbackInfo info) {
        if (getEntityById(entityId) != null) UltimateClient.EVENT_BUS.post(EntityRemovedEvent.get(getEntityById(entityId)));
    }

    @ModifyArgs(method = "doRandomBlockDisplayTicks", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;randomBlockDisplayTick(IIIILnet/minecraft/util/math/random/Random;Lnet/minecraft/block/Block;Lnet/minecraft/util/math/BlockPos$Mutable;)V"))
    private void doRandomBlockDisplayTicks(Args args) {
        if (Modules.get().get(NoRender.class).noBarrierInvis()) {
            args.set(5, Blocks.BARRIER);
        }
    }

    @Inject(method = "addBlockBreakParticles", at = @At("HEAD"), cancellable = true)
    private void onAddBlockBreakParticles(BlockPos blockPos, BlockState state, CallbackInfo info) {
        if (Modules.get().get(NoRender.class).noBlockBreakParticles()) info.cancel();
    }

    @Inject(method = "spawnBlockBreakingParticle", at = @At("HEAD"), cancellable = true)
    private void onAddBlockBreakingParticles(BlockPos blockPos, Direction direction, CallbackInfo info) {
        if (Modules.get().get(NoRender.class).noBlockBreakParticles()) info.cancel();
    }
}
