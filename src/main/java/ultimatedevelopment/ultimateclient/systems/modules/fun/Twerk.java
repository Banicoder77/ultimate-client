package ultimatedevelopment.ultimateclient.systems.modules.fun;

import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;

public class Twerk extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay")
        .description("Ticks between sneak toggles.")
        .defaultValue(2)
        .range(1, 20)
        .sliderRange(1, 20)
        .build()
    );

    public Twerk() {
        super(Categories.Fun, "twerk", "Automatically sneaks and unsneaks rapidly.");
    }

    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null) return;
        boolean shouldSneak = mc.player.age % (delay.get() * 2) < delay.get();
        mc.player.setSneaking(shouldSneak);
    }
}
