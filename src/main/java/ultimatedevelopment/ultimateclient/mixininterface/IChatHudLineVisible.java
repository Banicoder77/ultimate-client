/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

public interface IChatHudLineVisible extends IChatHudLine {
    boolean meteor$isStartOfEntry();
    void meteor$setStartOfEntry(boolean start);
}
