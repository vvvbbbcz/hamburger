package bilibili.vvvbbbcz.hamburger.inventory.container;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Containers {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, Hamburger.MODID);
    public static final ContainerType<IronPlateContainer> IRON_PLATE = register("iron_plate", IForgeContainerType.create((int id, PlayerInventory inventory, PacketBuffer buffer) -> new IronPlateContainer(id, inventory, Minecraft.getInstance().world, buffer.readBlockPos())));

    private static <T extends Container> ContainerType<T> register(String name, ContainerType<T> type) {
        CONTAINERS.register(name, () -> type);
        return type;
    }
}
