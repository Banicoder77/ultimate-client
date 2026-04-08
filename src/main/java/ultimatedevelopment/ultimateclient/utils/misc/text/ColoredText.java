/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.utils.misc.text;

import ultimatedevelopment.ultimateclient.utils.render.color.Color;

/**
 * Encapsulates a string and the color it should have. See {@link TextUtils}
 */
public record ColoredText(String text, Color color) {
}
