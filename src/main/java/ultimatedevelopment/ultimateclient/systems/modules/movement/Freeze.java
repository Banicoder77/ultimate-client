package ultimatedevelopment.ultimateclient.systems.modules.movement;
import ultimatedevelopment.ultimateclient.events.entity.player.PlayerMoveEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import meteordevelopment.orbit.EventPriority;
public class Freeze extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> cancelPackets = sgGeneral.add(new BoolSetting.Builder()
        .name("cancel-packets").description("Stop sending movement packets to the server.").defaultValue(true).build());
    public Freeze() { super(Categories.Movement, "freeze", "Stops sending movement updates to the server."); }
    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerMove(PlayerMoveEvent event) {
        if (cancelPackets.get()) event.movement = net.minecraft.util.math.Vec3d.ZERO;
    }
}
