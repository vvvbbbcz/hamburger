package bilibili.vvvbbbcz.hamburger.item;


import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class SweetsBeforeSleepItem extends Item implements IToiletFood {
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA, 2400, 0);
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .effect(() -> NAUSEA, 1.0F)
            .build();

    public SweetsBeforeSleepItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @Nonnull
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        super.onItemUseFinish(stack, worldIn, entityLiving);
        return new ItemStack(Items.BOWL);
    }

    @Override
    public Item getFinalFood() {
        return bilibili.vvvbbbcz.hamburger.item.Items.SWEETS_BEFORE_SLEEP_8;
    }

    @Override
    public SoundEvent getCastSpellSound() {
        return SoundEvents.ENTITY_LAO_BA_SPELL_2;
    }
}
