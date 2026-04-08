/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.world.AutoSmelter;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(AbstractFurnaceScreen.class)
public abstract class AbstractFurnaceScreenMixin<T extends AbstractFurnaceScreenHandler> extends HandledScreen<T> implements RecipeBookProvider {
    public AbstractFurnaceScreenMixin(T container, PlayerInventory playerInventory, Text name) {
        super(container, playerInventory, name);
    }

    @Override
    public void handledScreenTick() {
        super.handledScreenTick();

        if (Modules.get().isActive(AutoSmelter.class)) Modules.get().get(AutoSmelter.class).tick(handler);
    }
}
