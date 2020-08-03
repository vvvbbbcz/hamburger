package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.fluid.Fluids;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.FarmlandWaterManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class FertileFarmlandBlock extends FarmlandBlock {
    public FertileFarmlandBlock() {
        super(Properties.create(Material.EARTH).tickRandomly().hardnessAndResistance(0.6F).sound(SoundType.GROUND));
    }

    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Blocks.FERTILE_DIRT.getDefaultState() : this.getDefaultState();
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        if (!state.isValidPosition(worldIn, pos)) {
            turnToDirt(state, worldIn, pos);
        } else {
            int i = state.get(MOISTURE);
            if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
                if (i > 0) {
                    worldIn.setBlockState(pos, state.with(MOISTURE, i - 1), 2);
                } else if (!hasCrops(worldIn, pos)) {
                    turnToDirt(state, worldIn, pos);
                }
            } else if (i < 7) {
                worldIn.setBlockState(pos, state.with(MOISTURE, 7), 2);
            }
        }

        BlockState crop = worldIn.getBlockState(pos.up());
        if (crop.getBlock() instanceof CropsBlock) {
            if (hasShitFluid(worldIn, pos)) {
                if (rand.nextInt(4) == 0) { // x4
                    this.cropGrow(worldIn, pos.up(), crop, (CropsBlock) crop.getBlock());
                }
            } else if (hasWater(worldIn, pos)) {
                if (rand.nextInt(8) == 0) { // x2
                    this.cropGrow(worldIn, pos.up(), crop, (CropsBlock) crop.getBlock());
                }
            } else {
                if (rand.nextInt(13) == 0) { // x2
                    this.cropGrow(worldIn, pos.up(), crop, (CropsBlock) crop.getBlock());
                }
            }
        }
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return plantable.getPlantType(world, pos) == PlantType.Crop;
    }

    public void cropGrow(World worldIn, BlockPos pos, BlockState state, CropsBlock crop) {
        if (!worldIn.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            int i = state.get(crop.getAgeProperty());
            if (i < 7) {
                worldIn.setBlockState(pos, state.with(crop.getAgeProperty(), i + 1), 2);
                net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
            }
        }
    }

    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        if (!worldIn.isRemote && ForgeHooks.onFarmlandTrample(worldIn, pos, Blocks.FERTILE_DIRT.getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
            turnToDirt(worldIn.getBlockState(pos), worldIn, pos);
        }
        entityIn.onLivingFall(fallDistance, 1.0F);
    }

    public static void turnToDirt(BlockState state, World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, Blocks.FERTILE_DIRT.getDefaultState(), worldIn, pos));
    }

    private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
        BlockState state = worldIn.getBlockState(pos.up());
        return state.getBlock() instanceof IPlantable && canSustainPlant(state, worldIn, pos, Direction.UP, (IPlantable)state.getBlock());
    }

    private static boolean hasWater(IWorldReader worldIn, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
            if (worldIn.getFluidState(blockpos).isTagged(FluidTags.WATER)) {
                return true;
            }
        }
        return FarmlandWaterManager.hasBlockWaterTicket(worldIn, pos);
    }

    private static boolean hasShitFluid(IWorldReader worldIn, BlockPos pos) {
        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
            Fluid fluid = worldIn.getFluidState(blockpos).getFluid();
            if (fluid == Fluids.SHIT || fluid == Fluids.FLOWING_SHIT) {
                return true;
            }
        }
        return false;
    }
}
