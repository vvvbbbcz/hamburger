package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class BathroomPiece extends ScatteredStructurePiece {
    protected BathroomPiece(Random rand, int xIn, int zIn) {
        super(StructureTypes.BATHROOM, rand, xIn, 64, zIn, 7, 7, 9);
    }

    protected BathroomPiece(TemplateManager templateManager, CompoundNBT nbt) {
        super(StructureTypes.BATHROOM, nbt);
    }

    @Override
    public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn, MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn) {
        return false;
    }
}
