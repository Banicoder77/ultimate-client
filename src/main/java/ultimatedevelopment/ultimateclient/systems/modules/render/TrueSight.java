package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class TrueSight extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> entities = sgGeneral.add(new BoolSetting.Builder()
        .name("entities").description("Show invisible entities.").defaultValue(true).build());
    public final Setting<Boolean> barriers = sgGeneral.add(new BoolSetting.Builder()
        .name("barriers").description("Show barrier blocks.").defaultValue(false).build());
    public TrueSight() { super(Categories.Render, "true-sight", "Lets you see invisible entities and barrier blocks."); }
}
