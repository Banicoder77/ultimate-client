/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.events.entity.player;

import net.minecraft.item.ItemStack;

public class FinishUsingItemEvent {
    private static final FinishUsingItemEvent INSTANCE = new FinishUsingItemEvent();

    public ItemStack itemStack;

    public static FinishUsingItemEvent get(ItemStack itemStack) {
        INSTANCE.itemStack = itemStack;
        return INSTANCE;
    }
}
