package ultimatedevelopment.ultimateclient.systems.modules.world;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
public class Extinguish extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> onFire = sgGeneral.add(new BoolSetting.Builder()
        .name("on-fire").description("Extinguish when on fire.").defaultValue(true).build());
    public Extinguish() { super(Categories.World, "extinguish", "Automatically extinguishes yourself when on fire."); }
    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null || !onFire.get()) return;
        if (mc.player.isOnFire()) {
            mc.player.networkHandler.sendPacket(new PlayerActionC2SPacket(
                PlayerActionC2SPacket.Action.STOP_DESTROY_BLOCK,
                BlockPos.ORIGIN, Direction.DOWN
            ));
        }
    }
}
