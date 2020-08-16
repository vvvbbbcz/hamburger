package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import net.minecraft.item.SpawnEggItem;

public class LaoBaSpawnEggItem extends SpawnEggItem {
    public LaoBaSpawnEggItem() {
        super(Entities.LAO_BA, 0x553434, 0x5f0000, new Properties().group(ItemGroups.HAMBURGER));
    }
}
