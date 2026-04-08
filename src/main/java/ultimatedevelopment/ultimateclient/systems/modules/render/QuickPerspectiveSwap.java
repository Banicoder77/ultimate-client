package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.events.ultimate.KeyEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.utils.misc.input.KeyAction;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.client.option.Perspective;
public class QuickPerspectiveSwap extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> rearView = sgGeneral.add(new BoolSetting.Builder()
        .name("rear-view").description("Switch to rear view instead of front.").defaultValue(false).build());
    private Perspective saved;
    public QuickPerspectiveSwap() { super(Categories.Render, "quick-perspective-swap", "Temporarily switches perspective while the module is held active."); }
    @Override public void onActivate() {
        saved = mc.options.getPerspective();
        mc.options.setPerspective(rearView.get() ? Perspective.THIRD_PERSON_FRONT : Perspective.THIRD_PERSON_BACK);
    }
    @Override public void onDeactivate() { if (saved != null) mc.options.setPerspective(saved); }
}
