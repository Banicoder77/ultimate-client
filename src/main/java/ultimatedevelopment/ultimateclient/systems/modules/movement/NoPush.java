package ultimatedevelopment.ultimateclient.systems.modules.movement;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class NoPush extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> entities = sgGeneral.add(new BoolSetting.Builder()
        .name("entities").description("Prevent being pushed by entities.").defaultValue(true).build());
    public final Setting<Boolean> blocks = sgGeneral.add(new BoolSetting.Builder()
        .name("blocks").description("Prevent being pushed by blocks (e.g. pistons).").defaultValue(false).build());
    public final Setting<Boolean> liquids = sgGeneral.add(new BoolSetting.Builder()
        .name("liquids").description("Prevent being pushed by liquids.").defaultValue(true).build());
    public NoPush() { super(Categories.Movement, "no-push", "Prevents you from being pushed by entities and liquids."); }
}
