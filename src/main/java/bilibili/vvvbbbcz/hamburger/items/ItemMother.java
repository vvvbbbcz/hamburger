package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import net.minecraft.item.Item;

public class ItemMother extends Item { // 老干妈
    public ItemMother() {
        super(new Properties().group(ItemGroupLoader.tabLao8));
    }
}
