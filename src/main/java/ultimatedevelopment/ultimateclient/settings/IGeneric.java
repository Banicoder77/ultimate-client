/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.settings;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.WidgetScreen;
import ultimatedevelopment.ultimateclient.utils.misc.ICopyable;
import ultimatedevelopment.ultimateclient.utils.misc.ISerializable;

public interface IGeneric<T extends IGeneric<T>> extends ICopyable<T>, ISerializable<T> {
    WidgetScreen createScreen(GuiTheme theme, GenericSetting<T> setting);
}
