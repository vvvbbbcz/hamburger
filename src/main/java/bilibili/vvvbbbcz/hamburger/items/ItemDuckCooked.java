package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ItemDuckCooked extends Item {
    private static final Food FOOD = (new Food.Builder())
            .hunger(8)
            .saturation(6.0F)
            .build();

    public ItemDuckCooked() {
        super(new Properties().food(FOOD).group(ItemGroupLoader.tabLao8));
    }
}
