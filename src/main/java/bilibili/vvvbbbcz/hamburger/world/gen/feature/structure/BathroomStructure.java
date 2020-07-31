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
    public BathroomStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        if (randIn.nextFloat() < 0.03) {
            return true;
        }
        return false;
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
            BathroomPiece piece = new BathroomPiece(this.rand, chunkX * 16, chunkZ * 16);
            this.components.add(piece);
            this.recalculateStructureSize();
        }
    }
}
