package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.entity.DuckEggEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class DuckEggItem extends EggItem {
    public DuckEggItem() {
        super(new Properties().maxStackSize(16).group(ItemGroups.HAMBURGER));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            DuckEggEntity entityDuckEgg = new DuckEggEntity(playerIn, worldIn);
            entityDuckEgg.setItem(itemstack);
            entityDuckEgg.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(entityDuckEgg);
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        if (!playerIn.abilities.isCreativeMode) { // 检查玩家是否为创造模式
            itemstack.shrink(1); // 如果不是创造模式，就减少一个DuckEgg
        }

        return ActionResult.resultSuccess(itemstack);
    }
}
