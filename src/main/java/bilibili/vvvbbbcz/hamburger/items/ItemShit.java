package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.PotionLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class ItemShit extends ItemFood {
    public ItemShit() {
        super(2, 4.0F, false);
        this.setUnlocalizedName("shit");
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (!player.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
            return EnumActionResult.FAIL;
        } else {
            if (applyBoneMeal(itemstack, worldIn, pos, player, hand)) {
                if (!worldIn.isRemote) {
                    worldIn.playEvent(2005, pos, 0);//粒子效果
                }
                return EnumActionResult.SUCCESS;
            }
            return EnumActionResult.PASS;
        }
    }

    public static boolean applyBoneMeal(ItemStack stack, World worldIn, BlockPos pos, EntityPlayer player, @javax.annotation.Nullable EnumHand hand) {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        int hook = net.minecraftforge.event.ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, iblockstate, stack, hand);
        if (hook != 0) return hook > 0;

        if (iblockstate.getBlock() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable) iblockstate.getBlock();

            if (igrowable == Blocks.GRASS) {
                if (!worldIn.isRemote) {
                    igrowable.grow(worldIn, worldIn.rand, pos, iblockstate);
                    if (new Random().nextInt(5) == 0) {
                        player.dropItem(new ItemStack(RegisterLoader.itemLemon), false);
                    }

                    stack.shrink(1);
                }

                return true;
            }
        }

        return false;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(PotionLoader.potionShit, 2400, 0));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 2400, 0));
    }
}
