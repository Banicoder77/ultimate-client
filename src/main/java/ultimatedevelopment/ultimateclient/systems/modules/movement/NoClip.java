package ultimatedevelopment.ultimateclient.systems.modules.movement;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class NoClip extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> speed = sgGeneral.add(new DoubleSetting.Builder()
        .name("speed").description("Movement speed while no-clipping.").defaultValue(0.3).min(0.01).max(2).sliderRange(0.01, 2).build());
    public NoClip() { super(Categories.Movement, "no-clip", "Lets you fly through walls."); }
    @Override
    public void onActivate() { if (mc.player != null) mc.player.noClip = true; }
    @Override
    public void onDeactivate() { if (mc.player != null) mc.player.noClip = false; }
    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null) return;
        mc.player.noClip = true;
        mc.player.setVelocity(0, 0, 0);
        double s = speed.get();
        if (mc.options.forwardKey.isPressed()) mc.player.addVelocity(0, 0, -s);
        if (mc.options.backKey.isPressed()) mc.player.addVelocity(0, 0, s);
        if (mc.options.leftKey.isPressed()) mc.player.addVelocity(-s, 0, 0);
        if (mc.options.rightKey.isPressed()) mc.player.addVelocity(s, 0, 0);
        if (mc.options.jumpKey.isPressed()) mc.player.addVelocity(0, s, 0);
        if (mc.options.sneakKey.isPressed()) mc.player.addVelocity(0, -s, 0);
    }
}
