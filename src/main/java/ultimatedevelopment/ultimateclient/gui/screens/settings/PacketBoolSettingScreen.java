/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.screens.settings;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.screens.settings.base.CollectionListSettingScreen;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.settings.PacketListSetting;
import ultimatedevelopment.ultimateclient.settings.Setting;
import ultimatedevelopment.ultimateclient.utils.network.PacketUtils;
import net.minecraft.network.packet.Packet;

import java.util.Set;
import java.util.function.Predicate;

public class PacketBoolSettingScreen extends CollectionListSettingScreen<Class<? extends Packet<?>>> {
    public PacketBoolSettingScreen(GuiTheme theme, Setting<Set<Class<? extends Packet<?>>>> setting) {
        super(theme, "Select Packets", setting, setting.get(), PacketUtils.PACKETS);
    }

    @Override
    protected boolean includeValue(Class<? extends Packet<?>> value) {
        Predicate<Class<? extends Packet<?>>> filter = ((PacketListSetting) setting).filter;

        if (filter == null) return true;
        return filter.test(value);
    }

    @Override
    protected WWidget getValueWidget(Class<? extends Packet<?>> value) {
        return theme.label(PacketUtils.getName(value));
    }

    @Override
    protected String[] getValueNames(Class<? extends Packet<?>> value) {
        return new String[]{
            PacketUtils.getName(value),
            value.getSimpleName()
        };
    }
}
