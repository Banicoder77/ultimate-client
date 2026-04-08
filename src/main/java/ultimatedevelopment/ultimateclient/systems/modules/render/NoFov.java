package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.events.render.GetFovEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
public class NoFov extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Double> fov = sgGeneral.add(new DoubleSetting.Builder()
        .name("fov").description("The FOV to use.").defaultValue(90).min(1).max(179).sliderRange(1,179).build());
    public NoFov() { super(Categories.Render, "no-fov", "Locks your FOV to a custom value."); }
    @EventHandler
    private void onGetFov(GetFovEvent event) { event.fov = fov.get().floatValue(); }
}
