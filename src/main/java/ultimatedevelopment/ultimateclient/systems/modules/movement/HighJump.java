/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.systems.modules.movement;

import ultimatedevelopment.ultimateclient.events.entity.player.JumpVelocityMultiplierEvent;
import ultimatedevelopment.ultimateclient.settings.DoubleSetting;
import ultimatedevelopment.ultimateclient.settings.Setting;
import ultimatedevelopment.ultimateclient.settings.SettingGroup;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class HighJump extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> multiplier = sgGeneral.add(new DoubleSetting.Builder()
        .name("jump-multiplier")
        .description("Jump height multiplier.")
        .defaultValue(1)
        .min(0)
        .build()
    );

    public HighJump() {
        super(Categories.Movement, "high-jump", "Makes you jump higher than normal.");
    }

    @EventHandler
    private void onJumpVelocityMultiplier(JumpVelocityMultiplierEvent event) {
        event.multiplier *= multiplier.get();
    }
}
