package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Function;

public class BathroomStructure extends Structure<NoFeatureConfig> {
//    private static final List<Biome.SpawnListEntry> SPAWN_LIST = Lists.newArrayList()

    public BathroomStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        return true;
    }

    @Nonnull
    @Override
    public IStartFactory getStartFactory() {
        return BathroomStructure.Start::new;
    }

    @Nonnull
    @Override
    public String getStructureName() {
        return "bathroom";
    }

//    @Nonnull
//    @Override
//    public List<Biome.SpawnListEntry> getSpawnList() {
//        return super.getSpawnList();
//    }

    @Override
    public int getSize() {
        return 3;
    }

    public static class Start extends StructureStart {

        public Start(Structure<?> structure, int chunkPosX, int chunkPosZ, MutableBoundingBox bounds, int references, long seed) {
            super(structure, chunkPosX, chunkPosZ, bounds, references, seed);
        }

        @Override
        public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
            BathroomPiece piece = new BathroomPiece(this.rand, 128, 128);
            this.components.add(piece);
            this.recalculateStructureSize();
        }
    }
}
