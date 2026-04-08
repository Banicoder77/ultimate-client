/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.commands.arguments.ModuleArgumentType;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import net.minecraft.command.CommandSource;

public class BindCommand extends Command {
    public BindCommand() {
        super("bind", "Binds a specified module to the next pressed key.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("module", ModuleArgumentType.create()).executes(context -> {
            Module module = context.getArgument("module", Module.class);
            Modules.get().setModuleToBind(module);
            Modules.get().awaitKeyRelease();
            module.info("Press a key to bind the module to.");
            return SINGLE_SUCCESS;
        }));
    }
}
