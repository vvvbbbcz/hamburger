package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundLoader {
    public static final SoundEvent AO = new SoundEvent(new ResourceLocation(Hamburger.MODID, "ao"));
    public static final SoundEvent LI = new SoundEvent(new ResourceLocation(Hamburger.MODID, "li"));
    public static final SoundEvent GEI = new SoundEvent(new ResourceLocation(Hamburger.MODID, "gei"));
    public static final SoundEvent GAN = new SoundEvent(new ResourceLocation(Hamburger.MODID, "gan"));
    public static final SoundEvent LE = new SoundEvent(new ResourceLocation(Hamburger.MODID, "le"));

    @SubscribeEvent
    public static void registers(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(AO.setRegistryName(new ResourceLocation(Hamburger.MODID, "ao")));
        event.getRegistry().register(LI.setRegistryName(new ResourceLocation(Hamburger.MODID, "li")));
        event.getRegistry().register(GEI.setRegistryName(new ResourceLocation(Hamburger.MODID, "gei")));
        event.getRegistry().register(GAN.setRegistryName(new ResourceLocation(Hamburger.MODID, "gan")));
        event.getRegistry().register(LE.setRegistryName(new ResourceLocation(Hamburger.MODID, "le")));
    }
}
