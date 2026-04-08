/*
 * This file is part of the Ultimate Client distribution (https://github.com/MeteorDevelopment/ultimate-client).
 * Copyright (c) Meteor Development.
 */

package ultimatedevelopment.ultimateclient.utils.network;

import ultimatedevelopment.ultimateclient.utils.PreInit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class UltimateExecutor {
    public static ExecutorService executor;

    private UltimateExecutor() {
    }

    @PreInit
    public static void init() {
        AtomicInteger threadNumber = new AtomicInteger(1);

        executor = Executors.newCachedThreadPool((task) -> {
            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.setName("Ultimate-Executor-" + threadNumber.getAndIncrement());
            return thread;
        });
    }

    public static void execute(Runnable task) {
        executor.execute(task);
    }
}
