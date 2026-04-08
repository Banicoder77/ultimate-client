/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.mixininterface.ISimpleOption;
import net.minecraft.command.CommandSource;

public class FovCommand extends Command {
    public FovCommand() {
        super("fov", "Changes your fov.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("fov", IntegerArgumentType.integer(1, 180)).executes(context -> {
            ((ISimpleOption) (Object) mc.options.getFov()).meteor$set(context.getArgument("fov", Integer.class));
            return SINGLE_SUCCESS;
        }));
    }
}
