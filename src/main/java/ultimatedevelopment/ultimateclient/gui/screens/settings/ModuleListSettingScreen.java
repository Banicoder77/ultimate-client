/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.gui.screens.settings;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.screens.settings.base.CollectionListSettingScreen;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.settings.Setting;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;

import java.util.List;

public class ModuleListSettingScreen extends CollectionListSettingScreen<Module> {
    public ModuleListSettingScreen(GuiTheme theme, Setting<List<Module>> setting) {
        super(theme, "Select Modules", setting, setting.get(), Modules.get().getAll());
    }

    @Override
    protected WWidget getValueWidget(Module value) {
        return theme.label(value.title);
    }

    @Override
    protected String[] getValueNames(Module value) {
        String[] names = new String[value.aliases.length + 1];
        System.arraycopy(value.aliases, 0, names, 1, value.aliases.length);
        names[0] = value.title;
        return names;
    }
}
