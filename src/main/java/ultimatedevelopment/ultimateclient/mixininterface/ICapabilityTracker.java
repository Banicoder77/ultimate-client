/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

public interface ICapabilityTracker {
    boolean meteor$get();

    void meteor$set(boolean state);
}
