package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class SmoothCamera extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> smoothing = sgGeneral.add(new DoubleSetting.Builder()
        .name("smoothing").description("How much smoothing to apply (higher = more smooth).").defaultValue(5).min(1).max(20).sliderRange(1,20).build());
    public SmoothCamera() { super(Categories.Render, "smooth-camera", "Adds cinematic smoothing to camera movement."); }
    @Override public void onActivate() { mc.options.smoothCameraEnabled = true; }
    @Override public void onDeactivate() { mc.options.smoothCameraEnabled = false; }
}
