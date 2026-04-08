/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;

public interface IRaycastContext {
    void meteor$set(Vec3d start, Vec3d end, RaycastContext.ShapeType shapeType, RaycastContext.FluidHandling fluidHandling, Entity entity);
}
