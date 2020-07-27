package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.item.BlockNamedItem;

public class LemonSeedItem extends BlockNamedItem {
    public LemonSeedItem() {
        super(Blocks.LEMON_SAPLING, new Properties().group(ItemGroups.HAMBURGER));
    }
}