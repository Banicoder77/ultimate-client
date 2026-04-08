/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.world;

import net.minecraft.client.network.ServerAddress;
import net.minecraft.client.network.ServerInfo;

public class ServerConnectBeginEvent {
    private static final ServerConnectBeginEvent INSTANCE = new ServerConnectBeginEvent();
    public ServerAddress address;
    public ServerInfo info;

    public static ServerConnectBeginEvent get(ServerAddress address, ServerInfo info) {
        INSTANCE.address = address;
        INSTANCE.info = info;
        return INSTANCE;
    }
}
