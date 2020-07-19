package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.gui.container.ContainerIronPan;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GuiLoader {
    public static final ContainerType<ContainerIronPan> IRON_PAN = IForgeContainerType.create((int id, PlayerInventory inventory, PacketBuffer buffer) -> new ContainerIronPan(id, inventory, Minecraft.getInstance().world, buffer.readBlockPos()));

    public static void register(RegistryEvent.Register<ContainerType<?>> event) {
        event.getRegistry().register(IRON_PAN.setRegistryName(Hamburger.MODID, "iron_pan"));
    }
}
