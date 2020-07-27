package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class Hamburger8Item extends Item {
    private static final Food FOOD = (new Food.Builder())
            .hunger(10)
            .saturation(10.0F)
            .effect(() -> new EffectInstance(bilibili.vvvbbbcz.hamburger.potion.Effects.SHIT.get(), 2400, 1), 1.0F)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 2400, 0), 1.0F)
            .build();

    public Hamburger8Item() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
