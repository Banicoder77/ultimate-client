/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
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
