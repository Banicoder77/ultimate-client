package ultimatedevelopment.ultimateclient.systems.modules.fun;

import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.util.Arm;

import java.util.Random;

public class SkinDerp extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    private final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay")
        .description("Ticks between skin part randomizations.")
        .defaultValue(5)
        .range(1, 40)
        .sliderRange(1, 40)
        .build()
    );

    private int ticks = 0;
    private final Random random = new Random();

    public SkinDerp() {
        super(Categories.Fun, "skin-derp", "Randomly toggles skin parts to glitch your model.");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null) return;
        ticks++;
        if (ticks >= delay.get()) {
            ticks = 0;
            // Toggle random arm to cause visual glitch
            SimpleOption<Arm> armOption = mc.options.getMainArm();
            armOption.setValue(random.nextBoolean() ? Arm.RIGHT : Arm.LEFT);
        }
    }
}
