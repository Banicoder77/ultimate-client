package ultimatedevelopment.ultimateclient.systems.modules.player;
import ultimatedevelopment.ultimateclient.events.packets.PacketEvent;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.s2c.play.UpdateSelectedSlotS2CPacket;
public class NoSlotSet extends Module {
    public NoSlotSet() { super(Categories.Player, "no-slot-set", "Prevents the server from changing your selected hotbar slot."); }
    @EventHandler
    private void onReceive(PacketEvent.Receive event) {
        if (event.packet instanceof UpdateSelectedSlotS2CPacket) event.cancel();
    }
}
