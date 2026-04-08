/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.systems;

import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import ultimatedevelopment.ultimateclient.UltimateClient;
import ultimatedevelopment.ultimateclient.events.game.GameLeftEvent;
import ultimatedevelopment.ultimateclient.systems.accounts.Accounts;
import ultimatedevelopment.ultimateclient.systems.config.Config;
import ultimatedevelopment.ultimateclient.systems.friends.Friends;
import ultimatedevelopment.ultimateclient.systems.hud.Hud;
import ultimatedevelopment.ultimateclient.systems.macros.Macros;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import ultimatedevelopment.ultimateclient.systems.profiles.Profiles;
import ultimatedevelopment.ultimateclient.systems.proxies.Proxies;
import ultimatedevelopment.ultimateclient.systems.waypoints.Waypoints;
import meteordevelopment.orbit.EventHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Systems {
    @SuppressWarnings("rawtypes")
    private static final Map<Class<? extends System>, System<?>> systems = new Reference2ReferenceOpenHashMap<>();
    private static final List<Runnable> preLoadTasks = new ArrayList<>(1);

    public static void addPreLoadTask(Runnable task) {
        preLoadTasks.add(task);
    }

    public static void init() {
        // Has to be loaded first so the hidden modules list in config tab can load modules
        add(new Modules());

        Config config = new Config();
        System<?> configSystem = add(config);
        configSystem.init();
        configSystem.load();

        // Registers the colors from config tab. This allows rainbow colours to work for friends.
        config.settings.registerColorSettings(null);

        add(new Macros());
        add(new Friends());
        add(new Accounts());
        add(new Waypoints());
        add(new Profiles());
        add(new Proxies());
        add(new Hud());

        UltimateClient.EVENT_BUS.subscribe(Systems.class);
    }

    public static System<?> add(System<?> system) {
        systems.put(system.getClass(), system);
        UltimateClient.EVENT_BUS.subscribe(system);
        system.init();

        return system;
    }

    // save/load

    @EventHandler
    private static void onGameLeft(GameLeftEvent event) {
        save();
    }

    public static void save(File folder) {
        long start = java.lang.System.currentTimeMillis();
        UltimateClient.LOG.info("Saving");

        for (System<?> system : systems.values()) system.save(folder);

        UltimateClient.LOG.info("Saved in {} milliseconds.", java.lang.System.currentTimeMillis() - start);
    }

    public static void save() {
        save(null);
    }

    public static void load(File folder) {
        long start = java.lang.System.currentTimeMillis();
        UltimateClient.LOG.info("Loading");

        for (Runnable task : preLoadTasks) task.run();
        for (System<?> system : systems.values()) system.load(folder);

        UltimateClient.LOG.info("Loaded in {} milliseconds", java.lang.System.currentTimeMillis() - start);
    }

    public static void load() {
        load(null);
    }

    @SuppressWarnings("unchecked")
    public static <T extends System<?>> T get(Class<T> klass) {
        return (T) systems.get(klass);
    }
}
