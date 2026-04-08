/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixininterface;

import net.minecraft.client.gl.Framebuffer;

public interface IWorldRenderer {
    void meteor$pushEntityOutlineFramebuffer(Framebuffer framebuffer);

    void meteor$popEntityOutlineFramebuffer();
}
