package ultimatedevelopment.ultimateclient.systems.modules.render;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
public class NoBob extends Module {
    public NoBob() { super(Categories.Render, "no-bob", "Disables the view bobbing effect."); }
    @Override public void onActivate()   { if (mc.options != null) mc.options.getBobView().setValue(false); }
    @Override public void onDeactivate() { if (mc.options != null) mc.options.getBobView().setValue(true); }
}
