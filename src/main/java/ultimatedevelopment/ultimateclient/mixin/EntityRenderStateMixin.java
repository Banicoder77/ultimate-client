/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.mixininterface.IEntityRenderState;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(EntityRenderState.class)
public abstract class EntityRenderStateMixin implements IEntityRenderState {
    @Unique
    private Entity entity;

    @Override
    @Nullable(value = "EntityCulling mod can prevent the code that sets the entity from running")
    public Entity meteor$getEntity() {
        return entity;
    }

    @Override
    public void meteor$setEntity(Entity entity) {
        this.entity = entity;
    }
}
