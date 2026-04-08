package ultimatedevelopment.ultimateclient.systems.modules.combat;
import ultimatedevelopment.ultimateclient.events.entity.player.AttackEntityEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class KeepSprint extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> motionMultiplier = sgGeneral.add(new DoubleSetting.Builder()
        .name("motion").description("Multiplier for horizontal velocity kept after attacking (100 = full sprint).").defaultValue(100).min(0).max(100).sliderRange(0, 100).build());
    public KeepSprint() { super(Categories.Combat, "keep-sprint", "Keeps sprinting after hitting an entity."); }
    @EventHandler
    private void onAttack(AttackEntityEvent event) {
        if (mc.player == null || !mc.player.isSprinting()) return;
        double mult = motionMultiplier.get() / 100.0;
        mc.player.setVelocity(
            mc.player.getVelocity().x * mult,
            mc.player.getVelocity().y,
            mc.player.getVelocity().z * mult
        );
        mc.player.setSprinting(true);
    }
}
