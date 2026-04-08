/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.widgets;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WContainer;

public abstract class WTooltip extends WContainer implements WRoot {
    private boolean valid;

    protected String text;

    public WTooltip(String text) {
        this.text = text;
    }

    @Override
    public void init() {
        add(theme.label(text)).pad(4);
    }

    @Override
    public void invalidate() {
        valid = false;
    }

    @Override
    public boolean render(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        if (!valid) {
            calculateSize();
            calculateWidgetPositions();

            valid = true;
        }

        return super.render(renderer, mouseX, mouseY, delta);
    }
}
