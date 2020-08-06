package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

public class SweetsBeforeSleep8Item extends Item implements IToiletFood {
    private static final Food FOOD = (new Food.Builder())
            .hunger(10)
            .saturation(10.0F)
            .effect(() -> new EffectInstance(bilibili.vvvbbbcz.hamburger.potion.Effects.SHIT, 2400, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 2400, 0), 1.0F)
            .build();

    public SweetsBeforeSleep8Item() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
