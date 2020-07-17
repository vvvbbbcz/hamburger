package bilibili.vvvbbbcz.hamburger.items;


import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class ItemBeforeSleep extends Item {
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA, 2400, 0);
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .effect(NAUSEA, 1.0F)
            .build();

    public ItemBeforeSleep() {
        super(new Properties().food(FOOD).group(ItemGroupLoader.tabLao8));
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }
}
