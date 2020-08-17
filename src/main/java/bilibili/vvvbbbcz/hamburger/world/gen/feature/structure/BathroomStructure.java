package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import bilibili.vvvbbbcz.hamburger.world.biome.Biomes;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.ScatteredStructure;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class BathroomStructure extends ScatteredStructure<NoFeatureConfig> {
    private static final List<Biome.SpawnListEntry> SPAWN_LIST = Lists.newArrayList(new Biome.SpawnListEntry(Entities.LAO_BA, 1, 1, 1));

    public BathroomStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    @Override
    public boolean canBeGenerated(BiomeManager biomeManagerIn, ChunkGenerator<?> generatorIn, Random randIn, int chunkX, int chunkZ, Biome biomeIn) {
        return biomeIn == Biomes.ISLAND_CITY && super.canBeGenerated(biomeManagerIn, generatorIn, randIn, chunkX, chunkZ, biomeIn);
    }

    @Override
    protected int getSeedModifier() {
        return 10387313;
    }

    @Nonnull
    @Override
    public List<Biome.SpawnListEntry> getSpawnList() {
        return SPAWN_LIST;
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
            int x = chunkX * 16;
            int y = chunkZ * 16;
            BlockPos blockpos = new BlockPos(x, generator.getHeight(x, y, Heightmap.Type.WORLD_SURFACE_WG), y);
            StructurePiece piece = new BathroomPiece(this.rand, blockpos);
            this.components.add(piece);
            this.recalculateStructureSize();
        }
    }
}
