package bilibili.vvvbbbcz.hamburger.fluid;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidShit extends Fluid {
    public FluidShit() {
        super("shit", new ResourceLocation("shit_still"), new ResourceLocation("shit_flow"), new ResourceLocation("shit_overlay"));
//        this.setBlock(RegisterLoader.fluidShit);
        this.setUnlocalizedName("shit");
        this.setDensity(1100);
        this.setViscosity(1100);
    }
}