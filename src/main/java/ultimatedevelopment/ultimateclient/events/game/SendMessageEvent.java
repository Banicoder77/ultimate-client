/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.events.game;

import ultimatedevelopment.ultimateclient.events.Cancellable;

public class SendMessageEvent extends Cancellable {
    private static final SendMessageEvent INSTANCE = new SendMessageEvent();

    public String message;

    public static SendMessageEvent get(String message) {
        INSTANCE.setCancelled(false);
        INSTANCE.message = message;
        return INSTANCE;
    }
}


