/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.systems.modules.player;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.settings.DoubleSetting;
import ultimatedevelopment.ultimateclient.settings.Setting;
import ultimatedevelopment.ultimateclient.settings.SettingGroup;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.utils.Utils;

public class Reach extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Double> blockReach = sgGeneral.add(new DoubleSetting.Builder()
        .name("extra-block-reach")
        .description("The distance to add to your block reach.")
        .sliderMax(1)
        .build()
    );

    private final Setting<Double> entityReach = sgGeneral.add(new DoubleSetting.Builder()
        .name("extra-entity-reach")
        .description("The distance to add to your entity reach.")
        .sliderMax(1)
        .build()
    );

    public Reach() {
        super(Categories.Player, "reach", "Gives you super long arms.");
    }

    @Override
    public WWidget getWidget(GuiTheme theme) {
        return theme.label("Note: on vanilla servers you may give yourself up to 4 blocks of additional reach for specific actions - " +
            "interacting with block entities (chests, furnaces, etc.) or with vehicles. This does not work on paper servers.", Utils.getWindowWidth() / 3.0);
    }

    public double blockReach() {
        return isActive() ? blockReach.get() : 0;
    }

    public double entityReach() {
        return isActive() ? entityReach.get() : 0;
    }
}
