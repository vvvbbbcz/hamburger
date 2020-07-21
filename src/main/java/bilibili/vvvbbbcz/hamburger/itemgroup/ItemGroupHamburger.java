package bilibili.vvvbbbcz.hamburger.itemgroup;

import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemGroupHamburger extends ItemGroup {
    public ItemGroupHamburger() {
        super("hamburger");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return new ItemStack(RegisterLoader.blockWoodWC);
    }
}
