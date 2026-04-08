/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.modintegration;

import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.render.Fullbright;
import ultimatedevelopment.ultimateclient.systems.modules.render.Xray;

import java.util.function.BooleanSupplier;

/*
 * Hook for BadOptimizations mod compatibility.
 * Signals when the lightmap needs to be updated due to Fullbright or Xray state changes.
 */
public class BadOptimizationsHook implements BooleanSupplier {
    private int lastState;

    @Override
    public boolean getAsBoolean() {
        Modules m = Modules.get();
        if (m == null) return false;

        int state = (m.get(Fullbright.class).getGamma() ? 1 : 0) | (m.isActive(Xray.class) ? 2 : 0);
        boolean changed = state != lastState;
        lastState = state;
        return changed;
    }
}
