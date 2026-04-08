/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.systems.accounts.types;

import com.mojang.util.UndashedUuid;
import ultimatedevelopment.ultimateclient.systems.accounts.Account;
import ultimatedevelopment.ultimateclient.systems.accounts.AccountType;
import ultimatedevelopment.ultimateclient.systems.accounts.MicrosoftLogin;
import net.minecraft.client.session.Session;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MicrosoftAccount extends Account<MicrosoftAccount> {
    private @Nullable String token;
    public MicrosoftAccount(String refreshToken) {
        super(AccountType.Microsoft, refreshToken);
    }

    @Override
    public boolean fetchInfo() {
        token = auth();
        return token != null;
    }

    @Override
    public boolean login() {
        if (token == null) return false;

        super.login();

        setSession(new Session(cache.username, UndashedUuid.fromStringLenient(cache.uuid), token, Optional.empty(), Optional.empty()));
        return true;
    }

    private @Nullable String auth() {
        MicrosoftLogin.LoginData data = MicrosoftLogin.login(name);
        if (!data.isGood()) return null;

        name = data.newRefreshToken;
        cache.username = data.username;
        cache.uuid = data.uuid;

        return data.mcToken;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MicrosoftAccount account)) return false;
        return account.name.equals(this.name);
    }
}
