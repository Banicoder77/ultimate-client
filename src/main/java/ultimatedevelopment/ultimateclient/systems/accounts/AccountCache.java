/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.systems.accounts;

import com.mojang.util.UndashedUuid;
import ultimatedevelopment.ultimateclient.utils.network.UltimateExecutor;
import ultimatedevelopment.ultimateclient.utils.misc.ISerializable;
import ultimatedevelopment.ultimateclient.utils.misc.NbtException;
import ultimatedevelopment.ultimateclient.utils.render.PlayerHeadTexture;
import ultimatedevelopment.ultimateclient.utils.render.PlayerHeadUtils;
import net.minecraft.nbt.NbtCompound;

import static ultimatedevelopment.ultimateclient.UltimateClient.mc;

public class AccountCache implements ISerializable<AccountCache> {
    public String username = "";
    public String uuid = "";
    private PlayerHeadTexture headTexture;
    private volatile boolean loadingHead;

    public PlayerHeadTexture getHeadTexture() {
        return headTexture != null ? headTexture : PlayerHeadUtils.STEVE_HEAD;
    }

    public void loadHead() {
        loadHead(null);
    }

    public void loadHead(Runnable callback) {
        if (headTexture != null || uuid == null || uuid.isBlank()) {
            if (callback != null) mc.execute(callback);
            return;
        }

        if (loadingHead) return;

        loadingHead = true;

        UltimateExecutor.execute(() -> {
            byte[] head = PlayerHeadUtils.fetchHead(UndashedUuid.fromStringLenient(uuid));

            mc.execute(() -> {
                if (head != null) headTexture = new PlayerHeadTexture(head, true);
                loadingHead = false;
                if (callback != null) callback.run();
            });
        });
    }

    @Override
    public NbtCompound toTag() {
        NbtCompound tag = new NbtCompound();

        tag.putString("username", username);
        tag.putString("uuid", uuid);

        return tag;
    }

    @Override
    public AccountCache fromTag(NbtCompound tag) {
        if (tag.getString("username").isEmpty() || tag.getString("uuid").isEmpty()) throw new NbtException();

        username = tag.getString("username").get();
        uuid = tag.getString("uuid").get();
        loadHead();

        return this;
    }
}
