/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.ultimate;

import ultimatedevelopment.ultimateclient.events.Cancellable;
import ultimatedevelopment.ultimateclient.utils.misc.input.KeyAction;
import net.minecraft.client.input.KeyInput;

public class KeyEvent extends Cancellable {
    private static final KeyEvent INSTANCE = new KeyEvent();

    public KeyInput input;
    public KeyAction action;

    public static KeyEvent get(KeyInput input, KeyAction action) {
        INSTANCE.setCancelled(false);
        INSTANCE.input = input;
        INSTANCE.action = action;
        return INSTANCE;
    }

    public int key() {
        return INSTANCE.input.key();
    }

    public int modifiers() {
        return INSTANCE.input.modifiers();
    }
}
