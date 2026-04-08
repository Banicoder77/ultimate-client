package ultimatedevelopment.ultimateclient.systems.modules.movement;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.mixin.LivingEntityAccessor;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class NoJumpDelay extends Module {
    public NoJumpDelay() { super(Categories.Movement, "no-jump-delay", "Removes the delay between jumps."); }
    @EventHandler
    private void onTick(TickEvent.Pre event) {
        if (mc.player == null) return;
        ((LivingEntityAccessor) mc.player).meteor$setJumpCooldown(0);
    }
}
