/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.addons;

import ultimatedevelopment.ultimateclient.UltimateClient;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.EntrypointContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fabricmc.loader.api.metadata.Person;

import java.util.ArrayList;
import java.util.List;

public class AddonManager {
    public static final List<UltimateAddon> ADDONS = new ArrayList<>();

    public static void init() {
        // Meteor pseudo addon
        {
            UltimateClient.ADDON = new UltimateAddon() {
                @Override
                public void onInitialize() {}

                @Override
                public String getPackage() {
                    return "ultimatedevelopment.ultimateclient";
                }

                @Override
                public String getWebsite() {
                    return "https://meteorclient.com";
                }

                @Override
                public GithubRepo getRepo() {
                    return new GithubRepo("Banicoder77", "ultimate-client");
                }

                @Override
                public String getCommit() {
                    String commit = UltimateClient.MOD_META.getCustomValue(UltimateClient.MOD_ID + ":commit").getAsString();
                    return commit.isEmpty() ? null : commit;
                }
            };

            ModMetadata metadata = FabricLoader.getInstance().getModContainer(UltimateClient.MOD_ID).get().getMetadata();

            UltimateClient.ADDON.name = metadata.getName();
            UltimateClient.ADDON.authors = new String[metadata.getAuthors().size()];
            if (metadata.containsCustomValue(UltimateClient.MOD_ID + ":color")) {
                UltimateClient.ADDON.color.parse(metadata.getCustomValue(UltimateClient.MOD_ID + ":color").getAsString());
            }

            int i = 0;
            for (Person author : metadata.getAuthors()) {
                UltimateClient.ADDON.authors[i++] = author.getName();
            }

            ADDONS.add(UltimateClient.ADDON);
        }

        // Addons
        for (EntrypointContainer<UltimateAddon> entrypoint : FabricLoader.getInstance().getEntrypointContainers("meteor", UltimateAddon.class)) {
            ModMetadata metadata = entrypoint.getProvider().getMetadata();
            UltimateAddon addon;
            try {
                addon = entrypoint.getEntrypoint();
            } catch (Throwable throwable) {
                throw new RuntimeException("Exception during addon init \"%s\".".formatted(metadata.getName()), throwable);
            }

            addon.name = metadata.getName();

            if (metadata.getAuthors().isEmpty()) throw new RuntimeException("Addon \"%s\" requires at least 1 author to be defined in it's fabric.mod.json. See https://fabricmc.net/wiki/documentation:fabric_mod_json_spec".formatted(addon.name));
            addon.authors = new String[metadata.getAuthors().size()];

            if (metadata.containsCustomValue(UltimateClient.MOD_ID + ":color")) {
                addon.color.parse(metadata.getCustomValue(UltimateClient.MOD_ID + ":color").getAsString());
            }

            int i = 0;
            for (Person author : metadata.getAuthors()) {
                addon.authors[i++] = author.getName();
            }

            ADDONS.add(addon);
        }
    }
}
