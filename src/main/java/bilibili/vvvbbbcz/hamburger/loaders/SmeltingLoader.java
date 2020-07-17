package bilibili.vvvbbbcz.hamburger.loaders;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SmeltingLoader {
    public static void register() {
        GameRegistry.addSmelting(RegisterLoader.itemDuck, new ItemStack(RegisterLoader.itemDuckCooked), 1.0F);
    }
}
