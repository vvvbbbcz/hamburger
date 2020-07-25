package bilibili.vvvbbbcz.hamburger.client.gui;

import bilibili.vvvbbbcz.hamburger.inventory.container.Containers;
import net.minecraft.client.gui.ScreenManager;

public class Screens {
    public static void register() {
        ScreenManager.registerFactory(Containers.IRON_PLATE.get(), GuiIronPlate::new);
    }
}
