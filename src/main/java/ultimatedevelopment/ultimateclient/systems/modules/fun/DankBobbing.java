package ultimatedevelopment.ultimateclient.systems.modules.fun;

import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;

public class DankBobbing extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();

    public final Setting<Double> motion = sgGeneral.add(new DoubleSetting.Builder()
        .name("motion")
        .description("How intense the bobbing effect is.")
        .defaultValue(5)
        .min(1).max(50)
        .sliderRange(1, 50)
        .build()
    );

    public DankBobbing() {
        super(Categories.Fun, "dank-bobbing", "Adds an exaggerated bobbing effect to the camera.");
    }
}
