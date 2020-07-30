package bilibili.vvvbbbcz.hamburger.fluid;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.block.Blocks;
import bilibili.vvvbbbcz.hamburger.item.Items;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;
import java.util.Random;

public abstract class ShitFluid extends ForgeFlowingFluid {
    private static final ResourceLocation STILL = new ResourceLocation(Hamburger.MODID, "block/shit_still");
    private static final ResourceLocation FLOWING = new ResourceLocation(Hamburger.MODID, "block/shit_flow");
    private static final ResourceLocation OVERLAY = new ResourceLocation(Hamburger.MODID, "block/shit_overlay");
    protected ShitFluid() {
        super(new Properties(() -> Fluids.SHIT, () -> Fluids.FLOWING_SHIT, FluidAttributes.builder(STILL, FLOWING)
//                .color(0xff643c00)
                .density(2000)
                .viscosity(4000)
                .overlay(OVERLAY)
                .translationKey("block.hamburger.shit")
                .temperature(300)
                )
                .canMultiply()
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1)
                .bucket(() -> Items.SHIT_BUCKET)
                .tickRate(6)
                .explosionResistance(100.0F)
                .block(() -> (FlowingFluidBlock) Blocks.SHIT_FLUID_BLOCK)
        );
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

    public static class Flowing extends ShitFluid {
        protected void fillStateContainer(@Nonnull StateContainer.Builder<Fluid, IFluidState> builder) {
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
        public int getLevel(@Nonnull IFluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(IFluidState state) {
            return true;
        }
    }
}