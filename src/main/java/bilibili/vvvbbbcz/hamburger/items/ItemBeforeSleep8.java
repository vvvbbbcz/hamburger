package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.PotionLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemBeforeSleep8 extends ItemFood {
    public ItemBeforeSleep8() {
        super(10, 10.0F, false);
        this.setUnlocalizedName("beforeSleep8");
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(PotionLoader.potionShit, 2400, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 2400, 0));
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
