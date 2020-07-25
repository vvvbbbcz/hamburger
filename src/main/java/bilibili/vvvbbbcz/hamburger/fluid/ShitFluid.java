/*package bilibili.vvvbbbcz.hamburger.fluid;

import bilibili.vvvbbbcz.hamburger.blocks.Blocks;
import bilibili.vvvbbbcz.hamburger.items.Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public abstract class ShitFluid extends FlowingFluid {
    @Nonnull
    @Override
    public Item getFilledBucket() {
        return Items.SHIT_BUCKET.get();
    }

    @Nonnull
    @Override
    public Fluid getFlowingFluid() {
        return Fluids.FLOWING_SHIT.get();
    }

    @Nonnull
    @Override
    public Fluid getStillFluid() {
        return Fluids.SHIT.get();
    }

    @Override
    protected void animateTick(World worldIn, BlockPos pos, IFluidState state, Random random) {
        if (!state.isSource() && !state.get(FALLING)) {
            if (random.nextInt(64) == 0) {
                worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
            }
        } else if (random.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.UNDERWATER, (double)pos.getX() + (double)random.nextFloat(), (double)pos.getY() + (double)random.nextFloat(), (double)pos.getZ() + (double)random.nextFloat(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected boolean canSourcesMultiply() {
        return true;
    }

    @Override
    protected void beforeReplacingBlock(IWorld worldIn, @Nonnull BlockPos pos, BlockState state) {
        TileEntity tileentity = state.hasTileEntity() ? worldIn.getTileEntity(pos) : null;
        Block.spawnDrops(state, worldIn.getWorld(), pos, tileentity);
    }

    @Override
    protected int getSlopeFindDistance(@Nonnull IWorldReader worldIn) {
        return 4;
    }

    @Nonnull
    @Override
    protected BlockState getBlockState(@Nonnull IFluidState state) {
        return Blocks.SHIT_FLUID_BLOCK.get().getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
    }

    @Override
    public boolean isEquivalentTo(@Nonnull Fluid fluidIn) {
        return fluidIn == Fluids.SHIT.get() || fluidIn == Fluids.FLOWING_SHIT.get();
    }

    @Override
    protected int getLevelDecreasePerBlock(@Nonnull IWorldReader worldIn) {
        return 1;
    }

    @Override
    public int getTickRate(IWorldReader p_205569_1_) {
        return 6;
    }

    @Override
    protected boolean canDisplace(IFluidState fluidStateIn, IBlockReader blockReader, BlockPos pos, Fluid fluidIn, Direction directionIn) {
        return directionIn == Direction.DOWN && !fluidIn.isIn(FluidTags.WATER);
    }

    @Override
    protected float getExplosionResistance() {
        return 100.0F;
    }

    public static class Flowing extends ShitFluid {
        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> builder) {
            super.fillStateContainer(builder);
            builder.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(IFluidState state) {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(IFluidState state) {
            return false;
        }
    }

    public static class Source extends ShitFluid {
        public int getLevel(IFluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(IFluidState state) {
            return true;
        }
    }
}*/