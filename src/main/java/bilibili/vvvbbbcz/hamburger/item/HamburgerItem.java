package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvent;

public class HamburgerItem extends Item implements IToiletFood {
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA, 2400, 0);
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .effect(() -> NAUSEA, 1.0F)
            .build();

    public HamburgerItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @Override
    public Item getFinalFood() {
        return Items.HAMBURGER_8;
    }

    @Override
    public SoundEvent getCastSpellSound() {
        return SoundEvents.ENTITY_LAO_BA_SPELL_1;
    }
}
