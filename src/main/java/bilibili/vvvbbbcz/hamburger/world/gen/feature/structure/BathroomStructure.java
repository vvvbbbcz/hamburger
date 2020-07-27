package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;

import java.util.Random;
import java.util.function.Function;

public class BathroomStructure extends Structure<NoFeatureConfig> {
    public BathroomStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        return false;
    }

    @Override
    public IStartFactory getStartFactory() {
        return null;
    }

    @Override
    public String getStructureName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }
}
