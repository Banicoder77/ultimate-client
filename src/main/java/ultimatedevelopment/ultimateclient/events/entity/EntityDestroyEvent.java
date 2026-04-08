/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.events.entity;

import net.minecraft.entity.Entity;

public class EntityDestroyEvent {
    private static final EntityDestroyEvent INSTANCE = new EntityDestroyEvent();

    public Entity entity;

    public static EntityDestroyEvent get(Entity entity) {
        INSTANCE.entity = entity;
        return INSTANCE;
    }
}
