/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.systems.modules.player;

import com.llamalad7.mixinextras.sugar.ref.LocalFloatRef;
import ultimatedevelopment.ultimateclient.mixin.ClientPlayNetworkHandlerMixin;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @see ClientPlayNetworkHandlerMixin#onPlayerPositionLookHead(PlayerPositionLookS2CPacket, CallbackInfo, LocalFloatRef, LocalFloatRef)
 */
public class NoRotate extends Module {
    public NoRotate() {
        super(Categories.Player, "no-rotate", "Attempts to block rotations sent from server to client.");
    }
}
