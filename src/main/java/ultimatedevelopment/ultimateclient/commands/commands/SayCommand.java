/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.commands.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import ultimatedevelopment.ultimateclient.commands.Command;
import ultimatedevelopment.ultimateclient.mixin.ClientPlayNetworkHandlerAccessor;
import ultimatedevelopment.ultimateclient.utils.misc.UltimateStarscript;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.command.CommandSource;
import net.minecraft.network.encryption.NetworkEncryptionUtils;
import net.minecraft.network.message.LastSeenMessagesCollector;
import net.minecraft.network.message.MessageBody;
import net.minecraft.network.message.MessageSignatureData;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import org.meteordev.starscript.Script;

import java.time.Instant;

public class SayCommand extends Command {
    public SayCommand() {
        super("say", "Sends messages in chat.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("message", StringArgumentType.greedyString()).executes(context -> {
            String msg = context.getArgument("message", String.class);
            Script script = UltimateStarscript.compile(msg);

            if (script != null) {
                String message = UltimateStarscript.run(script);

                if (message != null) {
                    Instant instant = Instant.now();
                    long l = NetworkEncryptionUtils.SecureRandomUtil.nextLong();
                    ClientPlayNetworkHandler handler = mc.getNetworkHandler();
                    LastSeenMessagesCollector.LastSeenMessages lastSeenMessages = ((ClientPlayNetworkHandlerAccessor) handler).meteor$getLastSeenMessagesCollector().collect();
                    MessageSignatureData messageSignatureData = ((ClientPlayNetworkHandlerAccessor) handler).meteor$getMessagePacker().pack(new MessageBody(message, instant, l, lastSeenMessages.lastSeen()));
                    handler.sendPacket(new ChatMessageC2SPacket(message, instant, l, messageSignatureData, lastSeenMessages.update()));
                }
            }

            return SINGLE_SUCCESS;
        }));
    }
}
