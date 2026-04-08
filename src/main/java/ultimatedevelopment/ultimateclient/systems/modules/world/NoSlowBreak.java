package ultimatedevelopment.ultimateclient.systems.modules.world;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class NoSlowBreak extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> miningFatigue = sgGeneral.add(new BoolSetting.Builder()
        .name("mining-fatigue").description("Cancel mining fatigue penalty on break speed.").defaultValue(true).build());
    public final Setting<Boolean> onAir = sgGeneral.add(new BoolSetting.Builder()
        .name("on-air").description("No break speed penalty when not on ground.").defaultValue(true).build());
    public final Setting<Boolean> underwater = sgGeneral.add(new BoolSetting.Builder()
        .name("underwater").description("No break speed penalty when underwater.").defaultValue(false).build());
    public NoSlowBreak() { super(Categories.World, "no-slow-break", "Removes break speed penalties in various situations."); }
}
