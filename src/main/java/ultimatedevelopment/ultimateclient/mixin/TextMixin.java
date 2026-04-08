/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.mixininterface.IText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Text.class)
public interface TextMixin extends IText {
    @Override
    default void meteor$invalidateCache() {}
}
