/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.mixin;

import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.world.AutoBrewer;
import net.minecraft.client.gui.screen.ingame.BrewingStandScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.BrewingStandScreenHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BrewingStandScreen.class)
public abstract class BrewingStandScreenMixin extends HandledScreen<BrewingStandScreenHandler> {
    public BrewingStandScreenMixin(BrewingStandScreenHandler container, PlayerInventory playerInventory, Text name) {
        super(container, playerInventory, name);
    }

    @Override
    public void handledScreenTick() {
        super.handledScreenTick();

        if (Modules.get().isActive(AutoBrewer.class)) Modules.get().get(AutoBrewer.class).tick(handler);
    }

    @Override
    public void close() {
        if (Modules.get().isActive(AutoBrewer.class)) Modules.get().get(AutoBrewer.class).onBrewingStandClose();

        super.close();
    }
}
