package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.hamburger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoundLoader {
    public static final SoundEvent AO = new SoundEvent(new ResourceLocation(hamburger.MODID, "ao"));
    public static final SoundEvent LI = new SoundEvent(new ResourceLocation(hamburger.MODID, "li"));
    public static final SoundEvent GEI = new SoundEvent(new ResourceLocation(hamburger.MODID, "gei"));
    public static final SoundEvent GAN = new SoundEvent(new ResourceLocation(hamburger.MODID, "gan"));
    public static final SoundEvent LE = new SoundEvent(new ResourceLocation(hamburger.MODID, "le"));

    @SubscribeEvent
    public static void registers(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(AO.setRegistryName(new ResourceLocation(hamburger.MODID, "ao")));
        event.getRegistry().register(LI.setRegistryName(new ResourceLocation(hamburger.MODID, "li")));
        event.getRegistry().register(GEI.setRegistryName(new ResourceLocation(hamburger.MODID, "gei")));
        event.getRegistry().register(GAN.setRegistryName(new ResourceLocation(hamburger.MODID, "gan")));
        event.getRegistry().register(LE.setRegistryName(new ResourceLocation(hamburger.MODID, "le")));
    }
}
