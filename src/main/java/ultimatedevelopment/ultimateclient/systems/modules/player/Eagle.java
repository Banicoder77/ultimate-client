package ultimatedevelopment.ultimateclient.systems.modules.player;
import ultimatedevelopment.ultimateclient.events.entity.player.ClipAtLedgeEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class Eagle extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> edgeDistance = sgGeneral.add(new DoubleSetting.Builder()
        .name("edge-distance").description("How close to the edge before sneaking (in blocks).").defaultValue(0.5).min(0.01).max(1.3).sliderRange(0.01, 1.3).build());
    public final Setting<Boolean> onlyWhileHolding = sgGeneral.add(new BoolSetting.Builder()
        .name("only-while-holding-block").description("Only activates while holding a placeable block.").defaultValue(false).build());
    public Eagle() { super(Categories.Player, "eagle", "Auto-sneaks at block edges to help you bridge faster without falling. Also known as FastBridge."); }
    @EventHandler
    private void onClipAtLedge(ClipAtLedgeEvent event) {
        if (mc.player == null) return;
        event.setClip(true);
    }
}
