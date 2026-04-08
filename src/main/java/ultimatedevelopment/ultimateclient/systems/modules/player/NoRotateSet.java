package ultimatedevelopment.ultimateclient.systems.modules.player;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
/** Alias for NoRotate - blocks server-forced rotation packets. */
public class NoRotateSet extends Module {
    public NoRotateSet() { super(Categories.Player, "no-rotate-set", "Prevents the server from rotating your head."); }
}
