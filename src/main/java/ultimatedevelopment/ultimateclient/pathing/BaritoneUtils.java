/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.pathing;

import baritone.api.BaritoneAPI;

public class BaritoneUtils {
    public static boolean IS_AVAILABLE = false;

    private BaritoneUtils() {
    }

    public static String getPrefix() {
        if (IS_AVAILABLE) {
            return BaritoneAPI.getSettings().prefix.value;
        }

        return "";
    }
}
