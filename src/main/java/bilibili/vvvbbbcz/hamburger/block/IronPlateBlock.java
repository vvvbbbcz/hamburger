package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.tileentity.IronPlateTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ContainerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IronPlateBlock extends ContainerBlock {
    private static final BooleanProperty USING = BooleanProperty.create("using");
    private static final VoxelShape BASE_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
    private static final VoxelShape USING_B_SHAPE = Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D);
    public IronPlateBlock() {
        super(Properties.create(Material.IRON)
                .doesNotBlockMovement()
                .hardnessAndResistance(0.5F)
        );
        this.setDefaultState(this.getStateContainer().getBaseState().with(USING, false));
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            IronPlateTileEntity tileEntity = (IronPlateTileEntity) worldIn.getTileEntity(pos);
            NetworkHooks.openGui((ServerPlayerEntity) player, tileEntity, pos);
        }
        return ActionResultType.SUCCESS;
    }

    @Nonnull
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new IronPlateTileEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof IronPlateTileEntity) {
            IItemHandler handler = ((IronPlateTileEntity) tileentity).getPlateItemStacks();

            for (int i = 0; i < handler.getSlots(); i++) {
                if (!handler.getStackInSlot(i).isEmpty()) {
                    Block.spawnAsEntity(worldIn.getWorld(), pos, handler.getStackInSlot(i));
                }
            }
        }

        super.onPlayerDestroy(worldIn, pos, state);
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (active) {
            worldIn.setBlockState(pos, Blocks.IRON_PLATE.getDefaultState().with(USING, Boolean.TRUE), 3);
//            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.TRUE), 3);
        } else {
            worldIn.setBlockState(pos, Blocks.IRON_PLATE.getDefaultState().with(USING, Boolean.FALSE), 3);
//            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.FALSE), 3);
        }

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

//    @Nonnull
//    @Override
//    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
//        return BlockFaceShape.UNDEFINED;
//    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(USING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(USING, Boolean.FALSE);
    }

    @Nonnull
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.getBlock() == this) {
            if (state.get(USING)) {
                return USING_B_SHAPE;
            }
        }
        return BASE_SHAPE;
    }

    @Nonnull
    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.getBlock() == this) {
            if (state.get(USING)) {
                return USING_B_SHAPE;
            }
        }
        return BASE_SHAPE;
    }
}
