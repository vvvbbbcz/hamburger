package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SoundLoader {
    public static final SoundEvent AO = new SoundEvent(new ResourceLocation(LargeprojectsLao8.MODID, "ao"));
    public static final SoundEvent LI = new SoundEvent(new ResourceLocation(LargeprojectsLao8.MODID, "li"));
    public static final SoundEvent GEI = new SoundEvent(new ResourceLocation(LargeprojectsLao8.MODID, "gei"));
    public static final SoundEvent GAN = new SoundEvent(new ResourceLocation(LargeprojectsLao8.MODID, "gan"));
    public static final SoundEvent LE = new SoundEvent(new ResourceLocation(LargeprojectsLao8.MODID, "le"));

    @SubscribeEvent
    public static void registers(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(AO.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "ao")));
        event.getRegistry().register(LI.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "li")));
        event.getRegistry().register(GEI.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "gei")));
        event.getRegistry().register(GAN.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "gan")));
        event.getRegistry().register(LE.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "le")));
    }
}
