package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.fluid.FluidShit;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidLoader {
    public static Fluid fluidShit = new FluidShit();

    public static void registerFluids() {
        FluidRegistry.registerFluid(fluidShit);
        FluidRegistry.addBucketForFluid(fluidShit); // 此方法在执行时会同时注册该流体
    }
}
