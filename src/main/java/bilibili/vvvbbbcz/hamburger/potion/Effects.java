package bilibili.vvvbbbcz.hamburger.potion;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Effects {
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, Hamburger.MODID);
    public static final RegistryObject<Effect> SHIT = EFFECTS.register("shit", ShitEffect::new);
}
