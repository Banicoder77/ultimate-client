/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.entity.player;

import ultimatedevelopment.ultimateclient.events.Cancellable;
import net.minecraft.entity.Entity;
import net.minecraft.util.Hand;

public class InteractEntityEvent extends Cancellable {
    private static final InteractEntityEvent INSTANCE = new InteractEntityEvent();

    public Entity entity;
    public Hand hand;

    public static InteractEntityEvent get(Entity entity, Hand hand) {
        INSTANCE.setCancelled(false);
        INSTANCE.entity = entity;
        INSTANCE.hand = hand;
        return INSTANCE;
    }
}
