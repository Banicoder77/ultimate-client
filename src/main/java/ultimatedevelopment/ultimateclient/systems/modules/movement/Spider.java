/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.systems.modules.movement;

import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.DoubleSetting;
import ultimatedevelopment.ultimateclient.settings.Setting;
import ultimatedevelopment.ultimateclient.settings.SettingGroup;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.math.Vec3d;

public class Spider extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("climb-speed")
        .description("The speed you go up blocks.")
        .defaultValue(0.2)
        .min(0.0)
        .build()
    );

    public Spider() {
        super(Categories.Movement, "spider", "Allows you to climb walls like a spider.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (!mc.player.horizontalCollision) return;

        Vec3d velocity = mc.player.getVelocity();
        if (velocity.y >= 0.2) return;

        mc.player.setVelocity(velocity.x, speed.get(), velocity.z);
    }
}
