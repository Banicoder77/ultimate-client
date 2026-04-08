/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.world;

import java.net.InetSocketAddress;

public class ServerConnectEndEvent {
    private static final ServerConnectEndEvent INSTANCE = new ServerConnectEndEvent();
    public InetSocketAddress address;

    public static ServerConnectEndEvent get(InetSocketAddress address) {
        INSTANCE.address = address;
        return INSTANCE;
    }
}
