package ultimatedevelopment.ultimateclient.systems.modules.fun;

import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.util.Arm;

public class HandDerp extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay")
        .description("Ticks between hand switches.")
        .defaultValue(5)
        .range(1, 40)
        .sliderRange(1, 40)
        .build()
    );

    private int ticks = 0;
    private Arm originalArm;

    public HandDerp() {
        super(Categories.Fun, "hand-derp", "Rapidly switches your main hand.");
    }

    @Override
    public void onActivate() {
        if (mc.player != null) originalArm = mc.options.getMainArm().getValue();
        ticks = 0;
    }

    @Override
    public void onDeactivate() {
        if (originalArm == null || mc.options == null) return;
        mc.options.getMainArm().setValue(originalArm);
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null) return;
        ticks++;
        if (ticks >= delay.get()) {
            ticks = 0;
            Arm current = mc.options.getMainArm().getValue();
            mc.options.getMainArm().setValue(current == Arm.RIGHT ? Arm.LEFT : Arm.RIGHT);
        }
    }
}
