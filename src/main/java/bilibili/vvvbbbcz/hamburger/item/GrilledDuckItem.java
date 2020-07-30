package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class GrilledDuckItem extends Item {
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .build();

    public GrilledDuckItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }
}
