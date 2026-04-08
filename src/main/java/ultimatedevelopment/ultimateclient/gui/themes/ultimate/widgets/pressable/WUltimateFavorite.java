/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets.pressable;

import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WFavorite;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

public class WUltimateFavorite extends WFavorite implements UltimateWidget {
    public WUltimateFavorite(boolean checked) {
        super(checked);
    }

    @Override
    protected Color getColor() {
        return theme().favoriteColor.get();
    }
}
