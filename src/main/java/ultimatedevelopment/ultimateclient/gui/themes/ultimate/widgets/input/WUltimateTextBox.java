/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets.input;

import ultimatedevelopment.ultimateclient.gui.renderer.GuiRenderer;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateGuiTheme;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets.WUltimateLabel;
import ultimatedevelopment.ultimateclient.gui.utils.CharFilter;
import ultimatedevelopment.ultimateclient.gui.widgets.WWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WContainer;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WVerticalList;
import ultimatedevelopment.ultimateclient.gui.widgets.input.WTextBox;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;
import net.minecraft.util.math.MathHelper;

public class WUltimateTextBox extends WTextBox implements UltimateWidget {
    private boolean cursorVisible;
    private double cursorTimer;

    private double animProgress;

    public WUltimateTextBox(String text, String placeholder, CharFilter filter, Class<? extends Renderer> renderer) {
        super(text, placeholder, filter, renderer);
    }

    @Override
    protected WContainer createCompletionsRootWidget() {
        return new WVerticalList() {
            @Override
            protected void onRender(GuiRenderer renderer1, double mouseX, double mouseY, double delta) {
                UltimateGuiTheme theme1 = theme();
                double s = theme1.scale(2);
                Color c = theme1.outlineColor.get();

                Color col = theme1.backgroundColor.get();
                int preA = col.a;
                col.a += col.a / 2;
                col.validate();
                renderer1.quad(this, col);
                col.a = preA;

                renderer1.quad(x, y + height - s, width, s, c);
                renderer1.quad(x, y, s, height - s, c);
                renderer1.quad(x + width - s, y, s, height - s, c);
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T extends WWidget & ICompletionItem> T createCompletionsValueWidth(String completion, boolean selected) {
        return (T) new CompletionItem(completion, false, selected);
    }

    private static class CompletionItem extends WUltimateLabel implements ICompletionItem {
        private static final Color SELECTED_COLOR = new Color(255, 255, 255, 15);

        private boolean selected;

        public CompletionItem(String text, boolean title, boolean selected) {
            super(text, title);
            this.selected = selected;
        }

        @Override
        protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
            super.onRender(renderer, mouseX, mouseY, delta);

            if (selected) renderer.quad(this, SELECTED_COLOR);
        }

        @Override
        public boolean isSelected() {
            return selected;
        }

        @Override
        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        @Override
        public String getCompletion() {
            return text;
        }
    }

    @Override
    protected void onCursorChanged() {
        cursorVisible = true;
        cursorTimer = 0;
    }

    @Override
    protected void onRender(GuiRenderer renderer, double mouseX, double mouseY, double delta) {
        if (cursorTimer >= 1) {
            cursorVisible = !cursorVisible;
            cursorTimer = 0;
        }
        else {
            cursorTimer += delta * 1.75;
        }

        renderBackground(renderer, this, false, false);

        UltimateGuiTheme theme = theme();
        double pad = pad();
        double overflowWidth = getOverflowWidthForRender();

        renderer.scissorStart(x + pad, y + pad, width - pad * 2, height - pad * 2);

        // Text content
        if (!text.isEmpty()) {
            this.renderer.render(renderer, x + pad - overflowWidth, y + pad, text, theme.textColor.get());
        }
        else if (placeholder != null) {
            this.renderer.render(renderer, x + pad - overflowWidth, y + pad, placeholder, theme.placeholderColor.get());
        }

        // Text highlighting
        if (focused && (cursor != selectionStart || cursor != selectionEnd)) {
            double selStart = x + pad + getTextWidth(selectionStart) - overflowWidth;
            double selEnd = x + pad + getTextWidth(selectionEnd) - overflowWidth;

            renderer.quad(selStart, y + pad, selEnd - selStart, theme.textHeight(), theme.textHighlightColor.get());
        }

        // Cursor
        animProgress += delta * 10 * (focused && cursorVisible ? 1 : -1);
        animProgress = MathHelper.clamp(animProgress, 0, 1);

        if ((focused && cursorVisible) || animProgress > 0) {
            renderer.setAlpha(animProgress);
            renderer.quad(x + pad + getTextWidth(cursor) - overflowWidth, y + pad, theme.scale(1), theme.textHeight(), theme.textColor.get());
            renderer.setAlpha(1);
        }

        renderer.scissorEnd();
    }
}
