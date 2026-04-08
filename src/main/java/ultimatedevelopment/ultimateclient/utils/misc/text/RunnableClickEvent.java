/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.utils.misc.text;

/**
 * Allows arbitrary code execution in a click event
 */
public class RunnableClickEvent extends UltimateClickEvent {
    public final Runnable runnable;

    public RunnableClickEvent(Runnable runnable) {
        super(null); // Should ensure no vanilla code is triggered, and only we handle it
        this.runnable = runnable;
    }
}
