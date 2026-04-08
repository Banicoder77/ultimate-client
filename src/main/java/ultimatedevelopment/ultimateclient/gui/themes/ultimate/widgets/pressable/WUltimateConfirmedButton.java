/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets.pressable;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.renderer.packer.GuiTexture;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateGuiTheme;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WButton;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WConfirmedButton;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

public class WUltimateConfirmedButton extends WConfirmedButton implements UltimateWidget {
    public WUltimateConfirmedButton(String text, String confirmText, GuiTexture texture) {
        super(text, confirmText, texture);
    }

    @Override
    protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        UltimateGuiTheme theme = theme();
        double pad = pad();

        Color outline = theme.outlineColor.get(pressed, mouseOver);
        Color fg = pressedOnce ? theme.backgroundColor.get(pressed, mouseOver) : theme.textColor.get();
        Color bg = pressedOnce ? theme.textColor.get() : theme.backgroundColor.get(pressed, mouseOver);

        renderBackground(renderer, this, outline, bg);

        String text = getText();

        if (text != null) {
            renderer.text(text, x + width / 2 - textWidth / 2, y + pad, fg, false);
        }
        else {
            double ts = theme.textHeight();
            renderer.quad(x + width / 2 - ts / 2, y + pad, ts, ts, texture, fg);
        }
    }
}
