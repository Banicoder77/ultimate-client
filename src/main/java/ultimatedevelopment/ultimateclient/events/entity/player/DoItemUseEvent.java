/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.entity.player;

import ultimatedevelopment.ultimateclient.events.Cancellable;

/**
 * Some of our other injections coming from {@link net.minecraft.client.MinecraftClient#doItemUse()}
 * (e.g. InteractItemEvent) are called twice because the method loops over the Mainhand and the Offhand. This event is
 * only called once, before any interaction logic is called.
 */
public class DoItemUseEvent extends Cancellable {
    private static final DoItemUseEvent INSTANCE = new DoItemUseEvent();

    public static DoItemUseEvent get() {
        return INSTANCE;
    }
}
