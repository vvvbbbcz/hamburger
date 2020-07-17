package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import bilibili.vvvbbbcz.largeprojectslao8.potions.PotionSequelaOfWar;
import bilibili.vvvbbbcz.largeprojectslao8.potions.PotionShit;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class PotionLoader {
    public static Potion potionShit = new PotionShit();
    public static Potion potionSequelaOfWar = new PotionSequelaOfWar();

    @SubscribeEvent
    public static void register(RegistryEvent.Register<Potion> event) {
        event.getRegistry().register(potionShit.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "shit")));
        event.getRegistry().register(potionSequelaOfWar.setRegistryName(new ResourceLocation(LargeprojectsLao8.MODID, "sequela_of_war")));
    }

    public static PotionType potionTypeSequelaOfWar = new PotionType(new PotionEffect(potionSequelaOfWar, 3600));

    @SubscribeEvent
    public static void registerType(RegistryEvent.Register<PotionType> event) {
        event.getRegistry().register(potionTypeSequelaOfWar.setRegistryName("sequela_of_war"));
    }
}
