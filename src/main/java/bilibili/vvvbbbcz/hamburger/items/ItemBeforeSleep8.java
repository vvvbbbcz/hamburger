package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import bilibili.vvvbbbcz.hamburger.loaders.EffectLoader;
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

public class ItemBeforeSleep8 extends Item {
    private static final EffectInstance SHIT = new EffectInstance(EffectLoader.SHIT, 2400, 2);
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA, 2400, 0);
    private static final Food FOOD = (new Food.Builder())
            .hunger(10)
            .saturation(10.0F)
            .effect(SHIT, 1.0F)
            .effect(NAUSEA, 1.0F)
            .build();

    public ItemBeforeSleep8() {
        super(new Properties().food(FOOD).group(ItemGroupLoader.HAMBURGER));
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
