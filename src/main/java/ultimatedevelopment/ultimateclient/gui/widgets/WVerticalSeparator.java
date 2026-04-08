/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.gui.widgets;

public class WVerticalSeparator extends WWidget {
    @Override
    protected void onCalculateSize() {
        width = theme.scale(3);
        height = 1;
    }
}
