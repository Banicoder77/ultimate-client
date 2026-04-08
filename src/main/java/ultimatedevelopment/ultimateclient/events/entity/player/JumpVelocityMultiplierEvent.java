/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.entity.player;

public class JumpVelocityMultiplierEvent {
    private static final JumpVelocityMultiplierEvent INSTANCE = new JumpVelocityMultiplierEvent();

    public float multiplier = 1;

    public static JumpVelocityMultiplierEvent get() {
        INSTANCE.multiplier = 1;
        return INSTANCE;
    }
}
