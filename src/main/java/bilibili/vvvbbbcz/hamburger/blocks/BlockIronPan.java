package bilibili.vvvbbbcz.hamburger.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BlockIronPan extends BlockContainer {
    private static final PropertyBool USING = PropertyBool.create("using");
    private static final AxisAlignedBB BASE_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.15D, 1.0D);
    private static final AxisAlignedBB USING_B_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.2D, 1.0D);
    private static final AxisAlignedBB CO_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1D, 1.0D);
    private static final AxisAlignedBB USING_CO_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.2D, 1.0D);

    public BlockIronPan() {
        super(Material.WOOD);
        this.setUnlocalizedName("ironPan");
        this.setHardness(0.5F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(USING, false));
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(LargeprojectsLao8.instance, ModConfig.ID_GUI_IRON_PAN, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(@Nonnull World worldIn, int meta) {
        return new TileEntityIronPan();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public void breakBlock(World worldIn, @Nonnull BlockPos pos, @Nonnull IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof TileEntityIronPan) {
            IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

            for (int i = 0; i < handler.getSlots(); i++) {
                if (!handler.getStackInSlot(i).isEmpty()) {
                    Block.spawnAsEntity(worldIn, pos, handler.getStackInSlot(i));
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (active) {
            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.TRUE), 3);
//            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.TRUE), 3);
        } else {
            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.FALSE), 3);
//            worldIn.setBlockState(pos, RegisterLoader.blockIronPan.getDefaultState().withProperty(USING, Boolean.FALSE), 3);
        }

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    @Nonnull
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(USING, (meta == 1));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(USING) ? 1 : 0;
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, USING);
    }

    @Nonnull
    @Override
    public IBlockState getStateForPlacement(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull EnumFacing facing, float hitX, float hitY, float hitZ, int meta, @Nonnull EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(USING, Boolean.FALSE);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nonnull
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        if (state.getBlock() == this) {
            if (state.getValue(USING)) {
                return USING_B_AABB;
            }
        }
        return BASE_AABB;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        if (blockState.getBlock() == this) {
            if (blockState.getValue(USING)) {
                return USING_CO_AABB;
            }
        }
        return CO_AABB;
    }

    @Nonnull
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
