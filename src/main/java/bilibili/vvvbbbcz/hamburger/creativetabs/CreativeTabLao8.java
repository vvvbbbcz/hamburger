package bilibili.vvvbbbcz.hamburger.creativetabs;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class CreativeTabLao8 extends CreativeTabs {
    public CreativeTabLao8() {
        super("lao8");
    }

    @Nonnull
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(RegisterLoader.blockWoodWC);
    }
}
