package bilibili.vvvbbbcz.hamburger.fluid;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Fluids {
    public static final DeferredRegister<Fluid> FLUIDS =  new DeferredRegister<>(ForgeRegistries.FLUIDS, Hamburger.MODID);
//    public static final RegistryObject<FlowingFluid> SHIT = FLUIDS.register("shit", ShitFluid.Source::new);
//    public static final RegistryObject<FlowingFluid> FLOWING_SHIT = FLUIDS.register("flowing_shit", ShitFluid.Flowing::new);
}
