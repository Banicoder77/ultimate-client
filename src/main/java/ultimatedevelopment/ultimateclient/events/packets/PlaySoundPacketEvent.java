/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.events.packets;

import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;

public class PlaySoundPacketEvent {

    private static final PlaySoundPacketEvent INSTANCE = new PlaySoundPacketEvent();

    public PlaySoundS2CPacket packet;

    public static PlaySoundPacketEvent get(PlaySoundS2CPacket packet) {
        INSTANCE.packet = packet;
        return INSTANCE;
    }
}
