package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import net.minecraft.item.BlockNamedItem;

public class ItemLemonSeed extends BlockNamedItem {
    public ItemLemonSeed() {
        super(RegisterLoader.blockLemonSapling, new Properties().group(ItemGroupLoader.tabLao8));
    }
}
