package bilibili.vvvbbbcz.hamburger.world.biome;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Biomes {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Hamburger.MODID);
    public static final Biome ISLAND_CITY = register("island_city", new IslandCityBiome());

    public static void add() { // 往世界中添加生物群系
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ISLAND_CITY, 20));
    }

    private static Biome register(String name, Biome biome) {
        BIOMES.register(name, () -> biome);
        return biome;
    }
}
