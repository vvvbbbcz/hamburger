package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.tileentity.TileEntityIronPan;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntityLoader {
    public static final TileEntityType<TileEntityIronPan> IRON_PAN = TileEntityType.Builder.create(TileEntityIronPan::new, RegisterLoader.blockIronPan).build(null);

    @SubscribeEvent
    public static void register(RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(IRON_PAN.setRegistryName(Hamburger.MODID, "iron_pan"));
    }
}
