package bilibili.vvvbbbcz.hamburger.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.ForgeRegistries;

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
