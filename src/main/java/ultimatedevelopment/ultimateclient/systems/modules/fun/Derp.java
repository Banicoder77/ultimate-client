package ultimatedevelopment.ultimateclient.systems.modules.fun;

import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class Derp extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<DerpMode> mode = sgGeneral.add(new EnumSetting.Builder<DerpMode>()
        .name("mode")
        .description("How to derp yaw.")
        .defaultValue(DerpMode.Spin)
        .build()
    );

    private final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("speed")
        .description("Spin speed in degrees per tick.")
        .defaultValue(30)
        .min(1).max(180)
        .sliderRange(1, 180)
        .visible(() -> mode.get() == DerpMode.Spin)
        .build()
    );

    private final Setting<Boolean> safePitch = sgGeneral.add(new BoolSetting.Builder()
        .name("safe-pitch")
        .description("Keeps pitch within -90..90.")
        .defaultValue(true)
        .build()
    );

    private float spinYaw = 0f;

    public Derp() {
        super(Categories.Fun, "derp", "Makes your head move in a derpy way.");
    }

    @Override
    public void onActivate() {
        if (mc.player != null) spinYaw = mc.player.getYaw();
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null) return;
        float newYaw;
        switch (mode.get()) {
            case Spin -> { spinYaw += speed.get().floatValue(); newYaw = spinYaw; }
            case Random -> newYaw = (float)(Math.random() * 360f - 180f);
            case Jitter -> newYaw = mc.player.getYaw() + (mc.player.age % 2 == 0 ? 90f : -90f);
            default -> newYaw = mc.player.getYaw();
        }
        float pitch = safePitch.get()
            ? (float)(Math.random() * 180f - 90f)
            : (float)(Math.random() * 360f - 180f);
        mc.player.setYaw(newYaw);
        mc.player.setPitch(pitch);
    }

    public enum DerpMode { Spin, Random, Jitter }
}
