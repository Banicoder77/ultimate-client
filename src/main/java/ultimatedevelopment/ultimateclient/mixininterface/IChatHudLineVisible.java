/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

public interface IChatHudLineVisible extends IChatHudLine {
    boolean meteor$isStartOfEntry();
    void meteor$setStartOfEntry(boolean start);
}
