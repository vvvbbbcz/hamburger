package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import bilibili.vvvbbbcz.hamburger.entity.LaoBaEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class BathroomPiece extends ScatteredStructurePiece {
    private static final Selector SELECTOR = new Selector();
    private boolean laoBa;

    protected BathroomPiece(Random rand, BlockPos pos) {
        super(StructureTypes.BATHROOM, rand, pos.getX(), pos.getY(), pos.getZ(), 12, 10, 4);
    }

    protected BathroomPiece(TemplateManager templateManager, CompoundNBT nbt) {
        super(StructureTypes.BATHROOM, nbt);
        this.laoBa = nbt.getBoolean("LaoBa");
    }

    @Override
    protected void readAdditional(CompoundNBT tagCompound) {
        super.readAdditional(tagCompound);
        tagCompound.putBoolean("LaoBa", this.laoBa);
    }

    @Override
    public boolean create(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, Random randomIn, MutableBoundingBox mutableBoundingBoxIn, ChunkPos chunkPosIn) {
        this.fillWithRandomizedBlocks(worldIn, mutableBoundingBoxIn, 0, 0, 0, 2, 3, 3, false, randomIn, SELECTOR);
        this.fillWithAir(worldIn, mutableBoundingBoxIn, 1, 1, 0, 1, 2, 2);
        this.setBlockState(worldIn, bilibili.vvvbbbcz.hamburger.block.Blocks.STONE_TOILET.getDefaultState(), 1, 0, 2, mutableBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.ACACIA_DOOR.getDefaultState(), 1, 1, 0, mutableBoundingBoxIn);
        this.setBlockState(worldIn, Blocks.ACACIA_DOOR.getDefaultState().with(DoorBlock.HALF, DoubleBlockHalf.UPPER), 1, 2, 0, mutableBoundingBoxIn);

        if (!this.laoBa) {
            int x = this.getXWithOffset(1, 2);
            int y = this.getYWithOffset(1);
            int z = this.getZWithOffset(1, 2);
            if (mutableBoundingBoxIn.isVecInside(new BlockPos(x, y, z))) {
                this.laoBa = true;
                LaoBaEntity laoBaEntity = Entities.LAO_BA.create(worldIn.getWorld());
                laoBaEntity.enablePersistence();
                laoBaEntity.setLocationAndAngles((double)x + 0.5D, (double)y, (double)z + 0.5D, 0.0F, 0.0F);
                laoBaEntity.onInitialSpawn(worldIn, worldIn.getDifficultyForLocation(new BlockPos(x, y, z)), SpawnReason.STRUCTURE, (ILivingEntityData)null, (CompoundNBT)null);
                worldIn.addEntity(laoBaEntity);
            }
        }
        return true;
    }

    static class Selector extends BlockSelector {
        private Selector() {
        }

        @Override
        public void selectBlocks(Random rand, int x, int y, int z, boolean wall) {
            if (rand.nextBoolean()) {
                this.blockstate = Blocks.STONE_BRICKS.getDefaultState();
            } else {
                this.blockstate = Blocks.MOSSY_STONE_BRICKS.getDefaultState();
            }
        }
    }
}
