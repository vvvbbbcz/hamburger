package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import net.minecraft.item.SpawnEggItem;

public class DuckSpawnEggItem extends SpawnEggItem {
    public DuckSpawnEggItem() {
        super(Entities.DUCK, 0xd5ff00, 0x8ca700, new Properties().group(ItemGroups.HAMBURGER));
    }
}
