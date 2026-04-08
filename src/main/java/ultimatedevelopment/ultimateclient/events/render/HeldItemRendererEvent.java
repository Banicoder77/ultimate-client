/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.events.render;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Hand;

public class HeldItemRendererEvent {
    private static final HeldItemRendererEvent INSTANCE = new HeldItemRendererEvent();

    public Hand hand;
    public MatrixStack matrix;

    public static HeldItemRendererEvent get(Hand hand, MatrixStack matrices) {
        INSTANCE.hand = hand;
        INSTANCE.matrix = matrices;
        return INSTANCE;
    }
}
