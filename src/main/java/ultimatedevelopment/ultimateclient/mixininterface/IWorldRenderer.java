/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

import net.minecraft.client.gl.Framebuffer;

public interface IWorldRenderer {
    void meteor$pushEntityOutlineFramebuffer(Framebuffer framebuffer);

    void meteor$popEntityOutlineFramebuffer();
}
