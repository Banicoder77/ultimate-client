/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.events.ultimate;

import ultimatedevelopment.ultimateclient.events.Cancellable;

public class CharTypedEvent extends Cancellable {
    private static final CharTypedEvent INSTANCE = new CharTypedEvent();

    public char c;

    public static CharTypedEvent get(char c) {
        INSTANCE.setCancelled(false);
        INSTANCE.c = c;
        return INSTANCE;
    }
}
