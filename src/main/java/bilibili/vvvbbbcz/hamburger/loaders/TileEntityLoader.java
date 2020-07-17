package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.largeprojectslao8.gui.tileentity.TileEntityIronPan;
import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {
    public static void register() {
        reg(TileEntityIronPan.class, "iron_pan");
    }

    private static void reg(Class<? extends TileEntity> tileEntityClass, String name) {
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(LargeprojectsLao8.MODID + ":" + name));
    }
}
