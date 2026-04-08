/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets.pressable;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateGuiTheme;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WConfirmedMinus;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

public class WUltimateConfirmedMinus extends WConfirmedMinus implements UltimateWidget {
    @Override
    protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        UltimateGuiTheme theme = theme();
        double pad = pad();
        double s = theme.scale(3);

        Color outline = theme.outlineColor.get(pressed, mouseOver);
        Color fg = pressedOnce ? theme.backgroundColor.get(pressed, mouseOver) : theme().minusColor.get();
        Color bg = pressedOnce ? theme().minusColor.get() : theme.backgroundColor.get(pressed, mouseOver);

        renderBackground(renderer, this, outline, bg);
        renderer.quad(x + pad, y + height / 2 - s / 2, width - pad * 2, s, fg);
    }
}
