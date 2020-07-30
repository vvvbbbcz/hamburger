package bilibili.vvvbbbcz.hamburger.util;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Hamburger.MODID);
    public static final SoundEvent AO = register("ao", new SoundEvent(new ResourceLocation(Hamburger.MODID, "ao")));
    public static final SoundEvent LI = register("li", new SoundEvent(new ResourceLocation(Hamburger.MODID, "li")));
    public static final SoundEvent GEI = register("gei", new SoundEvent(new ResourceLocation(Hamburger.MODID, "gei")));
    public static final SoundEvent GAN = register("gan", new SoundEvent(new ResourceLocation(Hamburger.MODID, "gan")));
    public static final SoundEvent LE = register("le", new SoundEvent(new ResourceLocation(Hamburger.MODID, "le")));

    private static SoundEvent register(String name, SoundEvent soundEvent) {
        SOUND_EVENTS.register(name, () -> soundEvent);
        return soundEvent;
    }
}
