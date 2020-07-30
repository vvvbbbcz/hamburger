package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.fluid.Fluids;
import net.minecraft.item.BucketItem;

public class ShitFluidBucketItem extends BucketItem {
    public ShitFluidBucketItem() {
        super(() -> Fluids.SHIT, new Properties().group(ItemGroups.HAMBURGER));
    }
}
