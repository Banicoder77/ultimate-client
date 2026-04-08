package ultimatedevelopment.ultimateclient.systems.modules.combat;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.mixin.MinecraftClientAccessor;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class NoMissCooldown extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> removeAttackCooldown = sgGeneral.add(new BoolSetting.Builder()
        .name("remove-attack-cooldown").description("Removes the 10-tick cooldown after missing an attack.").defaultValue(true).build());
    public NoMissCooldown() { super(Categories.Combat, "no-miss-cooldown", "Removes the cooldown penalty when you miss an attack."); }
    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (!removeAttackCooldown.get() || mc.player == null) return;
        ((MinecraftClientAccessor) mc).meteor$setAttackCooldown(0);
    }
}
