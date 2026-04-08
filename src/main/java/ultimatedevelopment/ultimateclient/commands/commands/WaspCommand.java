/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.commands.arguments.PlayerArgumentType;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.modules.movement.AutoWasp;
import net.minecraft.command.CommandSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class WaspCommand extends Command {
    private static final SimpleCommandExceptionType CANT_WASP_SELF = new SimpleCommandExceptionType(Text.literal("You cannot target yourself!"));

    public WaspCommand() {
        super("wasp", "Sets the auto wasp target.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        AutoWasp wasp = Modules.get().get(AutoWasp.class);

        builder.then(literal("reset").executes(context -> {
            wasp.disable();
            return SINGLE_SUCCESS;
        }));

        builder.then(argument("player", PlayerArgumentType.create()).executes(context -> {
            PlayerEntity player = PlayerArgumentType.get(context);

            if (player == mc.player) throw CANT_WASP_SELF.create();

            wasp.target = player;
            wasp.enable();
            info(player.getName().getString() + " set as target.");
            return SINGLE_SUCCESS;
        }));
    }
}
