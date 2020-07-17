package bilibili.vvvbbbcz.hamburger.proxy;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGenTreesLoader(), 0);
    }

    public void init(FMLInitializationEvent event) {
        new GuiElementLoader();
        OreGeneratorLoader.init();
        SmeltingLoader.register();
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
}
