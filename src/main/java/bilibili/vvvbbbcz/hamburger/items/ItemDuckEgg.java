package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.largeprojectslao8.entities.EntityDuckEgg;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ItemDuckEgg extends Item {
    public ItemDuckEgg() {
        this.setUnlocalizedName("duckEgg");
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Nonnull
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!playerIn.capabilities.isCreativeMode) {
            itemstack.shrink(1);
        }

        worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote) {
            EntityDuckEgg entityDuckEgg = new EntityDuckEgg(worldIn, playerIn);
            entityDuckEgg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(entityDuckEgg);
        }

        playerIn.addStat(Objects.requireNonNull(StatList.getObjectUseStats(this)));
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
