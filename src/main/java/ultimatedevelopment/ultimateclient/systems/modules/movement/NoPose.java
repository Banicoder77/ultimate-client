package ultimatedevelopment.ultimateclient.systems.modules.movement;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class NoPose extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> noSwim = sgGeneral.add(new BoolSetting.Builder()
        .name("no-swim").description("Prevent entering swimming pose in water.").defaultValue(true).build());
    public final Setting<Boolean> noCrawl = sgGeneral.add(new BoolSetting.Builder()
        .name("no-crawl").description("Prevent entering crawl pose.").defaultValue(false).build());
    public NoPose() { super(Categories.Movement, "no-pose", "Prevents unwanted pose changes like swimming or crawling."); }
}
