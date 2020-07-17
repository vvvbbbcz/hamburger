package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import net.minecraft.item.ItemFood;

public class ItemDuck extends ItemFood {
    public ItemDuck() {
        super(6, 6.0F, false);
        this.setUnlocalizedName("duck");
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }
}
