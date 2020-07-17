package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.SoundLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class BlockWoodWC extends Block {
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    private static int clickTime = 1;

    public BlockWoodWC() {
        super(Material.WOOD);
        this.setUnlocalizedName("woodWC");
        this.setSoundType(SoundType.WOOD);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getFoodStats().getFoodLevel() >= 6) {
            switch (clickTime) {
                case 1:
                    playerIn.playSound(SoundLoader.AO, 1.0F, 1.0F);
                    clickTime++;
                    return true;
                case 3:
                    playerIn.playSound(SoundLoader.LI, 1.0F, 1.0F);
                    clickTime++;
                    return true;
                case 5:
                    playerIn.playSound(SoundLoader.GEI, 1.0F, 1.0F);
                    clickTime++;
                    return true;
                case 7:
                    playerIn.playSound(SoundLoader.GAN, 1.0F, 1.0F);
                    clickTime++;
                    return true;
                case 9:
                    playerIn.playSound(SoundLoader.LE, 1.0F, 1.0F);
                    clickTime++;
                    return true;
                case 10:
                    playerIn.addItemStackToInventory(new ItemStack(RegisterLoader.itemShit, 1));
                    playerIn.getFoodStats().addStats(-6, 0);
                    clickTime = 1;
                    return true;
                default:
                    clickTime++;
                    return true;
            }
        }
        return false;
    }

    @Nonnull
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }

    @Nonnull
    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Nonnull
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
    }

    @Nonnull
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }
}
