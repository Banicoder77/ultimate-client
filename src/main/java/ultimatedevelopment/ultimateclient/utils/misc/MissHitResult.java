/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.utils.misc;

import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

public class MissHitResult extends HitResult {
    public static final MissHitResult INSTANCE = new MissHitResult();

    private MissHitResult() {
        super(new Vec3d(0, 0, 0));
    }

    @Override
    public Type getType() {
        return Type.MISS;
    }
}
