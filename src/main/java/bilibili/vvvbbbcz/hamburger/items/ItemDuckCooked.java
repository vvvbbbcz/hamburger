package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import net.minecraft.item.ItemFood;

public class ItemDuckCooked extends ItemFood {
    public ItemDuckCooked() {
        super(8, 6.0F, false);
        this.setUnlocalizedName("duckCooked");
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }
}
