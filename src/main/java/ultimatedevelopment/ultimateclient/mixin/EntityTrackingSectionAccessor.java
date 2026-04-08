/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import net.minecraft.util.collection.TypeFilterableList;
import net.minecraft.world.entity.EntityTrackingSection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(EntityTrackingSection.class)
public interface EntityTrackingSectionAccessor {
    @Accessor("collection")
    <T> TypeFilterableList<T> meteor$getCollection();
}
