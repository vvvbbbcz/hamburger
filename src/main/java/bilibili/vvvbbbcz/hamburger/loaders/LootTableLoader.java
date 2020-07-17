package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.hamburger;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableLoader {
    public static final ResourceLocation DUCK = LootTableList.register(new ResourceLocation(hamburger.MODID, "duck"));
}
