package ultimatedevelopment.ultimateclient.systems.modules.player;
import ultimatedevelopment.ultimateclient.events.entity.player.InteractEntityEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import java.util.List;
import java.util.Set;
public class NoEntityInteract extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Set<EntityType<?>>> entities = sgGeneral.add(new EntityTypeListSetting.Builder()
        .name("entities").description("Entity types to prevent interaction with.").build());
    public NoEntityInteract() { super(Categories.Player, "no-entity-interact", "Prevents accidentally right-clicking entities."); }
    @EventHandler
    private void onInteractEntity(InteractEntityEvent event) {
        if (entities.get().isEmpty() || entities.get().contains(event.entity.getType())) event.cancel();
    }
}
