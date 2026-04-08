/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.packets;

import net.minecraft.network.packet.s2c.play.InventoryS2CPacket;

public class InventoryEvent {
    private static final InventoryEvent INSTANCE = new InventoryEvent();

    public InventoryS2CPacket packet;

    public static InventoryEvent get(InventoryS2CPacket packet) {
        INSTANCE.packet = packet;
        return INSTANCE;
    }
}
