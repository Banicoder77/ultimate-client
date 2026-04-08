/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.renderer.Fonts;
import ultimatedevelopment.ultimateclient.systems.Systems;
import ultimatedevelopment.ultimateclient.systems.friends.Friend;
import ultimatedevelopment.ultimateclient.systems.friends.Friends;
import ultimatedevelopment.ultimateclient.utils.network.Capes;
import ultimatedevelopment.ultimateclient.utils.network.UltimateExecutor;
import net.minecraft.command.CommandSource;

public class ReloadCommand extends Command {
    public ReloadCommand() {
        super("reload", "Reloads many systems.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.executes(context -> {
            warning("Reloading systems, this may take a while.");

            Systems.load();
            Capes.init();
            Fonts.refresh();
            UltimateExecutor.execute(() -> Friends.get().forEach(Friend::updateInfo));

            return SINGLE_SUCCESS;
        });
    }
}
