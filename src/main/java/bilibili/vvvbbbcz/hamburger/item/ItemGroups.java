package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemGroups {
    public static final ItemGroup HAMBURGER = new ItemGroup("hamburger") {
        @Nonnull
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Blocks.WOOD_TOILET);
        }
    };
}
