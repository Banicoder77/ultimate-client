/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.gui.screens.accounts;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.WindowScreen;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WHorizontalList;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WButton;
import ultimatedevelopment.ultimateclient.systems.accounts.Account;
import ultimatedevelopment.ultimateclient.systems.accounts.AccountType;
import ultimatedevelopment.ultimateclient.systems.accounts.TokenAccount;
import ultimatedevelopment.ultimateclient.utils.render.color.Color;

import static ultimatedevelopment.ultimateclient.UltimateClient.mc;

public class AccountInfoScreen extends WindowScreen {
    private final Account<?> account;

    public AccountInfoScreen(GuiTheme theme, Account<?> account) {
        super(theme, account.getUsername() + " details");
        this.account = account;
    }

    @Override
    public void initWidgets() {
        TokenAccount e = (TokenAccount) account;
        WHorizontalList l = add(theme.horizontalList()).expandX().widget();

        String tokenLabel = account.getType() + " token:";
        if (account.getType() == AccountType.Session) tokenLabel = "";

        WButton copy = theme.button("Copy");
        copy.action = () -> mc.keyboard.setClipboard(e.getToken());

        l.add(theme.label(tokenLabel));
        l.add(theme.label(account.getType() == AccountType.Session ? "Click to copy Token" : e.getToken()).color(Color.GRAY)).pad(5);
        l.add(copy);
    }
}
