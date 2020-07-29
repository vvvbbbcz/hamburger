package bilibili.vvvbbbcz.hamburger.fluid;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Fluids {
    public static final DeferredRegister<Fluid> FLUIDS =  new DeferredRegister<>(ForgeRegistries.FLUIDS, Hamburger.MODID);
    public static final FlowingFluid SHIT = register("shit", new ShitFluid.Source());
    public static final FlowingFluid FLOWING_SHIT = register("flowing_shit", new ShitFluid.Flowing());

    private static <T extends Fluid> T register(String name, T fluid) {
        FLUIDS.register(name, () -> fluid);
        return fluid;
    }
}
