package ultimatedevelopment.ultimateclient.systems.modules.world;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.systems.modules.Modules;
import meteordevelopment.orbit.EventHandler;
import java.util.List;
public class AutoDisable extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<List<Module>> modules = sgGeneral.add(new ModuleListSetting.Builder()
        .name("modules").description("Modules to disable when their condition is met.").build());
    public AutoDisable() { super(Categories.World, "auto-disable", "Automatically disables selected modules when a condition is met."); }
    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null) return;
        for (Module m : modules.get()) {
            if (m.isActive()) m.toggle();
        }
        toggle();
    }
}
