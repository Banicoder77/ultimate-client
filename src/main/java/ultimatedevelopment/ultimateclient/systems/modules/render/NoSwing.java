package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class NoSwing extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Boolean> serverSide = sgGeneral.add(new BoolSetting.Builder()
        .name("server-side").description("Hide swing from server (others won't see it).").defaultValue(false).build());
    public final Setting<Boolean> clientSide = sgGeneral.add(new BoolSetting.Builder()
        .name("client-side").description("Hide swing on your own client.").defaultValue(true).build());
    public NoSwing() { super(Categories.Render, "no-swing", "Disables the hand swing animation."); }
}
