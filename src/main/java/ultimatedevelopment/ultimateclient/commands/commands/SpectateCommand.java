/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.commands.arguments.PlayerArgumentType;
import ultimatedevelopment.ultimateclient.events.ultimate.KeyEvent;
import ultimatedevelopment.ultimateclient.events.ultimate.MouseClickEvent;
import ultimatedevelopment.ultimateclient.utils.misc.input.Input;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.text.Text;

public class SpectateCommand extends Command {

    private final StaticListener shiftListener = new StaticListener();

    public SpectateCommand() {
        super("spectate", "Allows you to spectate nearby players");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("reset").executes(context -> {
            mc.setCameraEntity(mc.player);
            return SINGLE_SUCCESS;
        }));

        builder.then(argument("player", PlayerArgumentType.create()).executes(context -> {
            mc.setCameraEntity(PlayerArgumentType.get(context));
            mc.player.sendMessage(Text.literal("Sneak to un-spectate."), true);
            UltimateClient.EVENT_BUS.subscribe(shiftListener);
            return SINGLE_SUCCESS;
        }));
    }

    private static class StaticListener {
        @EventHandler
        private void onKey(KeyEvent event) {
            if (Input.isPressed(mc.options.sneakKey)) {
                mc.setCameraEntity(mc.player);
                event.cancel();
                UltimateClient.EVENT_BUS.unsubscribe(this);
            }
        }

        @EventHandler
        private void onMouse(MouseClickEvent event) {
            if (Input.isPressed(mc.options.sneakKey)) {
                mc.setCameraEntity(mc.player);
                event.cancel();
                UltimateClient.EVENT_BUS.unsubscribe(this);
            }
        }
    }
}
