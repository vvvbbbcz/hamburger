package bilibili.vvvbbbcz.hamburger.creativetabs;

import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemGroupLao8 extends ItemGroup {
    public ItemGroupLao8() {
        super("lao8");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return new ItemStack(RegisterLoader.blockWoodWC);
    }
}
