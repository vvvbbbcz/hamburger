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
    public static final SoundEvent ENTITY_LAO_BA_AMBIENT = register("lao_ba_ambient", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_ambient")));
    public static final SoundEvent ENTITY_LAO_BA_HURT = register("lao_ba_hurt", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_hurt")));
    public static final SoundEvent ENTITY_LAO_BA_DEATH = register("lao_ba_death", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_death")));
    public static final SoundEvent ENTITY_LAO_BA_SPELL_1 = register("lao_ba_spell_1", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_spell_1")));
    public static final SoundEvent ENTITY_LAO_BA_SPELL_2 = register("lao_ba_spell_2", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_spell_2")));
    public static final SoundEvent ENTITY_LAO_BA_SPELL_3 = register("lao_ba_spell_3", new SoundEvent(new ResourceLocation(Hamburger.MODID, "lao_ba_spell_3")));

    private static SoundEvent register(String name, SoundEvent soundEvent) {
        SOUND_EVENTS.register(name, () -> soundEvent);
        return soundEvent;
    }
}
