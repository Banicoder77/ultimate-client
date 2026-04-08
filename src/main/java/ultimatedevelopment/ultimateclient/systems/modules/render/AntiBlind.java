package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class AntiBlind extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> blindness = sgGeneral.add(new BoolSetting.Builder()
        .name("blindness").description("Remove blindness effect.").defaultValue(true).build());
    public final Setting<Boolean> darkness = sgGeneral.add(new BoolSetting.Builder()
        .name("darkness").description("Remove darkness effect.").defaultValue(true).build());
    public AntiBlind() { super(Categories.Render, "anti-blind", "Removes visual impairing effects like blindness and darkness."); }
}
