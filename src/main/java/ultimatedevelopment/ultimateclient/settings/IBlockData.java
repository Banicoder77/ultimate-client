/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.settings;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.WidgetScreen;
import ultimatedevelopment.ultimateclient.utils.misc.IChangeable;
import ultimatedevelopment.ultimateclient.utils.misc.ICopyable;
import ultimatedevelopment.ultimateclient.utils.misc.ISerializable;
import net.minecraft.block.Block;

public interface IBlockData<T extends ICopyable<T> & ISerializable<T> & IChangeable & IBlockData<T>> {
    WidgetScreen createScreen(GuiTheme theme, Block block, BlockDataSetting<T> setting);
}
