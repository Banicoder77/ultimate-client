/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.gui.screens.accounts;

import ultimatedevelopment.ultimateclient.gui.GuiTheme;
import ultimatedevelopment.ultimateclient.gui.widgets.containers.WHorizontalList;
import ultimatedevelopment.ultimateclient.gui.widgets.pressable.WButton;
import ultimatedevelopment.ultimateclient.systems.accounts.MicrosoftLogin;
import ultimatedevelopment.ultimateclient.systems.accounts.types.MicrosoftAccount;

import static ultimatedevelopment.ultimateclient.UltimateClient.mc;

public class AddMicrosoftAccountScreen extends AddAccountScreen {
    public AddMicrosoftAccountScreen(GuiTheme theme, AccountsScreen parent) {
        super(theme, "Add Microsoft Account", parent);
    }

    @Override
    public void initWidgets() {
        String url = MicrosoftLogin.getRefreshToken(refreshToken -> {

            if (refreshToken != null) {
                MicrosoftAccount account = new MicrosoftAccount(refreshToken);
                AccountsScreen.addAccount(null, parent, account);
            }

            close();
        });

        add(theme.label("Please select the account to log into in your browser."));
        add(theme.label("If the link does not automatically open in a few seconds, copy it into your browser."));

        WHorizontalList l = add(theme.horizontalList()).expandX().widget();

        WButton copy = l.add(theme.button("Copy link")).expandX().widget();
        copy.action = () -> mc.keyboard.setClipboard(url);

        WButton cancel = l.add(theme.button("Cancel")).expandX().widget();
        cancel.action = () -> {
            MicrosoftLogin.stopServer();
            close();
        };
    }

    @Override
    public void tick() {}

    @Override
    public boolean shouldCloseOnEsc() {
        return false;
    }
}
