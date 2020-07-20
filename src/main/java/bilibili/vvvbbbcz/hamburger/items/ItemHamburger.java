package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemHamburger extends Item {
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA, 2400, 0);
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .effect(NAUSEA, 1.0F)
            .build();

    public ItemHamburger() {
        super(new Properties().food(FOOD).group(ItemGroupLoader.HAMBURGER));
    }
}
