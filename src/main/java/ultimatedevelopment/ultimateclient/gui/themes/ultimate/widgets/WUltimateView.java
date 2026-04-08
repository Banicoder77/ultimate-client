/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WView;

public class WUltimateView extends WView implements UltimateWidget {
    @Override
    protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        if (canScroll && hasScrollBar) {
            renderer.quad(handleX(), handleY(), handleWidth(), handleHeight(), theme().scrollbarColor.get(focused, handleMouseOver));
        }
    }
}
