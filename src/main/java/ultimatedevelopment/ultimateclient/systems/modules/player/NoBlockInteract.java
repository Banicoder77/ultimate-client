package ultimatedevelopment.ultimateclient.systems.modules.player;
import ultimatedevelopment.ultimateclient.events.entity.player.InteractBlockEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.block.*;
import java.util.List;
public class NoBlockInteract extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<List<Block>> blocks = sgGeneral.add(new BlockListSetting.Builder()
        .name("blocks").description("Blocks to prevent interaction with. Empty = all interactable blocks.").build());
    public NoBlockInteract() { super(Categories.Player, "no-block-interact", "Prevents accidentally right-clicking interactable blocks."); }
    @EventHandler
    private void onInteractBlock(InteractBlockEvent event) {
        if (mc.player == null) return;
        Block b = mc.world.getBlockState(event.result.getBlockPos()).getBlock();
        if (blocks.get().isEmpty() || blocks.get().contains(b)) event.cancel();
    }
}
