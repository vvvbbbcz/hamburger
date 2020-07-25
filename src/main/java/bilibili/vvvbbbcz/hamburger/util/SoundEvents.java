package bilibili.vvvbbbcz.hamburger.util;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, Hamburger.MODID);
    public static final RegistryObject<SoundEvent> AO = SOUND_EVENTS.register("ao", () -> new SoundEvent(new ResourceLocation(Hamburger.MODID, "ao")));
    public static final RegistryObject<SoundEvent> LI = SOUND_EVENTS.register("li", () -> new SoundEvent(new ResourceLocation(Hamburger.MODID, "li")));
    public static final RegistryObject<SoundEvent> GEI = SOUND_EVENTS.register("gei", () -> new SoundEvent(new ResourceLocation(Hamburger.MODID, "gei")));
    public static final RegistryObject<SoundEvent> GAN = SOUND_EVENTS.register("gan", () -> new SoundEvent(new ResourceLocation(Hamburger.MODID, "gan")));
    public static final RegistryObject<SoundEvent> LE = SOUND_EVENTS.register("le", () -> new SoundEvent(new ResourceLocation(Hamburger.MODID, "le")));
}
