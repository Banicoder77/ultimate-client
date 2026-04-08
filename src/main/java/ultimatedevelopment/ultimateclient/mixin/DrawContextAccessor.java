/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.render.state.GuiRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DrawContext.class)
public interface DrawContextAccessor {
    @Accessor("state")
    GuiRenderState getState();

    @Accessor("scissorStack")
    DrawContext.ScissorStack getScissorStack();
}
