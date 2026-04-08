package ultimatedevelopment.ultimateclient.systems.modules.world;
import ultimatedevelopment.ultimateclient.events.world.TickEvent;
import ultimatedevelopment.ultimateclient.settings.*;
import ultimatedevelopment.ultimateclient.systems.modules.Categories;
import ultimatedevelopment.ultimateclient.systems.modules.Module;
import ultimatedevelopment.ultimateclient.utils.player.InvUtils;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
public class BlockIn extends Module {
    private final SettingGroup sgGeneral = settings.getDefaultGroup();
    public final Setting<Integer> delay = sgGeneral.add(new IntSetting.Builder()
        .name("delay").description("Delay in ticks between placement attempts.").defaultValue(1).range(0, 10).sliderRange(0, 10).build());
    private int timer = 0;
    public BlockIn() { super(Categories.World, "block-in", "Places blocks around you to trap yourself."); }
    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (mc.player == null || mc.world == null) return;
        if (timer++ < delay.get()) return;
        timer = 0;
        BlockPos[] positions = {
            mc.player.getBlockPos(),
            mc.player.getBlockPos().up()
        };
        for (BlockPos pos : positions) {
            if (!mc.world.getBlockState(pos).isAir()) continue;
            int slot = InvUtils.findInHotbar(s -> s.getItem() instanceof BlockItem).slot();
            if (slot < 0) return;
            int prev = mc.player.getInventory().getSelectedSlot();
            mc.player.getInventory().setSelectedSlot(slot);
            mc.interactionManager.interactBlock(mc.player, Hand.MAIN_HAND,
                new BlockHitResult(Vec3d.ofCenter(pos), Direction.UP, pos, false));
            mc.player.getInventory().setSelectedSlot(prev);
        }
    }
}
