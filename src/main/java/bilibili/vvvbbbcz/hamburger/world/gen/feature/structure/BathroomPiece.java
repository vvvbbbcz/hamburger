package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class BathroomPiece extends ScatteredStructurePiece {
    private static final Selector SELECTOR = new Selector();

    protected BathroomPiece(Random rand, int xIn, int zIn) {
        super(StructureTypes.BATHROOM, rand, xIn, 68, zIn, 3, 4, 4);
    }

    protected BathroomPiece(TemplateManager templateManager, CompoundNBT nbt) {
        super(StructureTypes.BATHROOM, nbt);
    }

    @Override
    public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn, MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn) {
        this.fillWithRandomizedBlocks(worldIn, mutableBoundingBoxIn, 0, 0, 0, 2, 3, 3, false, randomIn, SELECTOR);
        this.fillWithAir(worldIn, mutableBoundingBoxIn, 1, 1, 0, 1, 2, 2);
        this.setBlockState(worldIn, Blocks.ACACIA_DOOR.getDefaultState(), 1, 1, 0, mutableBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.ACACIA_DOOR.getDefaultState().with(DoorBlock.HALF, DoubleBlockHalf.UPPER), 1, 2, 0, mutableBoundingBoxIn);
        return true;
    }

    static class Selector extends BlockSelector {
        private Selector() {
        }

        @Override
        public void selectBlocks(Random rand, int x, int y, int z, boolean wall) {
            this.blockstate = Blocks.STONE_BRICKS.getDefaultState();
        }
    }
}
