/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.utils.entity.simulator;

import net.minecraft.util.hit.HitResult;

public class SimulationStep {
    public static final SimulationStep MISS = new SimulationStep(true);

    public boolean shouldStop;
    public HitResult[] hitResults;

    public SimulationStep(boolean stop, HitResult... hitResults) {
        this.shouldStop = stop;
        this.hitResults = hitResults;
    }
}
