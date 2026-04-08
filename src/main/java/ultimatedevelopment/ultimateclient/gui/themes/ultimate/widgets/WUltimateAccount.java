/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.gui.themes.ultimate.widgets;

import ultimatedevelopment.ultimateclient.gui.WidgetScreen;
import ultimatedevelopment.ultimateclient.gui.themes.ultimate.UltimateWidget;
import ultimatedevelopment.ultimateclient.gui.widgets.WAccount;
import ultimatedevelopment.ultimateclient.systems.accounts.Account;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

public class WUltimateAccount extends WAccount implements UltimateWidget {
    public WUltimateAccount(WidgetScreen screen, Account<?> account) {
        super(screen, account);
    }

    @Override
    protected Color loggedInColor() {
        return theme().loggedInColor.get();
    }

    @Override
    protected Color accountTypeColor() {
        return theme().textSecondaryColor.get();
    }
}
