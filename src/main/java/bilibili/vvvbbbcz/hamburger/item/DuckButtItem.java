package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DuckButtItem extends Item {
    private static final EffectInstance SHIT = new EffectInstance(bilibili.vvvbbbcz.hamburger.potion.Effects.SHIT.get());
    private static final EffectInstance NAUSEA = new EffectInstance(Effects.NAUSEA);
    private static final Food FOOD = (new Food.Builder())
            .hunger(12)
            .saturation(12.0F)
            .effect(SHIT, 1.0F)
            .effect(NAUSEA, 1.0F)
            .build();

    public DuckButtItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
