/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.utils.BaseWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

public interface UltimateWidget extends BaseWidget {
    default UltimateGuiTheme theme() {
        return (UltimateGuiTheme) getTheme();
    }

    default void renderBackground(GuiRenderer renderer, WWidget widget, Color outlineColor, Color backgroundColor) {
        UltimateGuiTheme theme = theme();
        double s = theme.scale(2);

        renderer.quad(widget.x + s, widget.y + s, widget.width - s * 2, widget.height - s * 2, backgroundColor);

        renderer.quad(widget.x, widget.y, widget.width, s, outlineColor);
        renderer.quad(widget.x, widget.y + widget.height - s, widget.width, s, outlineColor);
        renderer.quad(widget.x, widget.y + s, s, widget.height - s * 2, outlineColor);
        renderer.quad(widget.x + widget.width - s, widget.y + s, s, widget.height - s * 2, outlineColor);
    }

    default void renderBackground(GuiRenderer renderer, WWidget widget, boolean pressed, boolean mouseOver) {
        UltimateGuiTheme theme = theme();
        renderBackground(renderer, widget, theme.outlineColor.get(pressed, mouseOver), theme.backgroundColor.get(pressed, mouseOver));
    }
}
