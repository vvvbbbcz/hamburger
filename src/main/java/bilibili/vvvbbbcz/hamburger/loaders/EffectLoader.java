package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.potions.PotionShit;
import net.minecraft.potion.Effect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EffectLoader {
    public static final Effect SHIT = new PotionShit();
//    public static Potion potionSequelaOfWar = new PotionSequelaOfWar();

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Effect> event) {
        event.getRegistry().register(SHIT.setRegistryName(new ResourceLocation(Hamburger.MODID, "shit")));
//        event.getRegistry().register(potionSequelaOfWar.setRegistryName(new ResourceLocation(hamburger.MODID, "sequela_of_war")));
    }

//    public static PotionType potionTypeSequelaOfWar = new PotionType(new PotionEffect(potionSequelaOfWar, 3600));
//
//    @SubscribeEvent
//    public static void registerType(RegistryEvent.Register<PotionType> event) {
//        event.getRegistry().register(potionTypeSequelaOfWar.setRegistryName("sequela_of_war"));
//    }
}
