package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class DuckItem extends Item {
        private static final Food FOOD = (new Food.Builder())
                .hunger(6)
                .saturation(6.0F)
                .build();

    public DuckItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }
}
