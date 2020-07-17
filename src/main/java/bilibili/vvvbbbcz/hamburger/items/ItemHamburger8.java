package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.EffectLoader;
import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ItemHamburger8 extends Item {
    private static final EffectInstance SHIT = new EffectInstance(EffectLoader.SHIT);
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA);
    private static final Food FOOD = (new Food.Builder())
            .hunger(10)
            .saturation(10.0F)
            .effect(SHIT, 1.0F)
            .effect(NAUSEA, 1.0F)
            .build();

    public ItemHamburger8() {
        super(new Properties().food(FOOD).group(ItemGroupLoader.tabLao8));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
