package bilibili.vvvbbbcz.hamburger.world.biome;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Biomes {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Hamburger.MODID);
    public static final RegistryObject<Biome> ISLAND_CITY = BIOMES.register("island_city", IslandCityBiome::new);
}
