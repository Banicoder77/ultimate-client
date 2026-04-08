/*
 * This file is part of the Ultimate Client distribution (https://github.com/Banicoder77/ultimate-client).
 * Copyright (c) Banicoder77.
 */

package ultimatedevelopment.ultimateclient.utils.network;

public class OnlinePlayers {
    private static long lastPingTime;

    private OnlinePlayers() {
    }

    public static void update() {
        long time = System.currentTimeMillis();

        if (time - lastPingTime > 5 * 60 * 1000) {
            UltimateExecutor.execute(() -> Http.post("https://github.com/Banicoder77/ultimate-client/api/online/ping").ignoreExceptions().send());

            lastPingTime = time;
        }
    }

    public static void leave() {
        UltimateExecutor.execute(() -> Http.post("https://github.com/Banicoder77/ultimate-client/api/online/leave").ignoreExceptions().send());
    }
}
