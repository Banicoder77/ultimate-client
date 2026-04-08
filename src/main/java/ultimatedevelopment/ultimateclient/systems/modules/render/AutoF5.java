package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.events.game.OpenScreenEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.option.Perspective;
public class AutoF5 extends Module {
    private Perspective prevPerspective;
    public AutoF5() { super(Categories.Render, "auto-f5", "Automatically switches to third-person when opening inventory."); }
    @EventHandler
    private void onOpenScreen(OpenScreenEvent event) {
        if (mc.player == null) return;
        if (event.screen instanceof HandledScreen<?>) {
            prevPerspective = mc.options.getPerspective();
            if (prevPerspective != Perspective.THIRD_PERSON_BACK)
                mc.options.setPerspective(Perspective.THIRD_PERSON_BACK);
        } else if (prevPerspective != null) {
            mc.options.setPerspective(prevPerspective);
            prevPerspective = null;
        }
    }
}
