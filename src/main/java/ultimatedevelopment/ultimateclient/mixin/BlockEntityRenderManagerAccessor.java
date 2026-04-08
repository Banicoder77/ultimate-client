/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import net.minecraft.client.render.block.entity.BlockEntityRenderManager;
import net.minecraft.client.texture.SpriteHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BlockEntityRenderManager.class)
public interface BlockEntityRenderManagerAccessor {
    @Accessor("spriteHolder")
    SpriteHolder getSpriteHolder();
}
