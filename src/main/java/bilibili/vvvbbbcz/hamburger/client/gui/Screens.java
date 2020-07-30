package bilibili.vvvbbbcz.hamburger.client.gui;

import bilibili.vvvbbbcz.hamburger.inventory.container.Containers;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class Screens {
    public static void register() {
        ScreenManager.registerFactory(Containers.IRON_PLATE, GuiIronPlate::new);
    }
}
