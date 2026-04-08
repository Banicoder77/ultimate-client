package ultimatedevelopment.ultimateclient.systems.modules.combat;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.text.Text;
public class AutoLeave extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> health = sgGeneral.add(new DoubleSetting.Builder()
        .name("health").description("Health threshold to leave at.").defaultValue(8).min(0.5).max(20).sliderRange(0.5, 20).build());
    public final Setting<LeaveMode> mode = sgGeneral.add(new EnumSetting.Builder<LeaveMode>()
        .name("mode").description("How to leave the server.").defaultValue(LeaveMode.Disconnect).build());
    public AutoLeave() { super(Categories.Combat, "auto-leave", "Automatically leaves the server when your health is low."); }
    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null || mc.player.getAbilities().creativeMode) return;
        if (mc.player.getHealth() <= health.get().floatValue()) {
            switch (mode.get()) {
                case Disconnect -> mc.player.networkHandler.getConnection().disconnect(net.minecraft.text.Text.literal("AutoLeave - Low health"));
                case Quit -> mc.player.networkHandler.getConnection().disconnect(net.minecraft.text.Text.literal("AutoLeave"));
            }
            toggle();
        }
    }
    public enum LeaveMode { Disconnect, Quit }
}
