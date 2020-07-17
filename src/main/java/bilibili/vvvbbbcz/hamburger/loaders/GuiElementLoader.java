package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.configure.ModConfig;
import bilibili.vvvbbbcz.hamburger.gui.container.ContainerIronPan;
import bilibili.vvvbbbcz.hamburger.gui.GuiIronPan;
import bilibili.vvvbbbcz.hamburger.gui.tileentity.TileEntityIronPan;
import bilibili.vvvbbbcz.hamburger.hamburger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import javax.annotation.Nullable;

public class GuiElementLoader implements IGuiHandler {
    public GuiElementLoader() {
        NetworkRegistry.INSTANCE.registerGuiHandler(hamburger.instance, this);
    }

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == ModConfig.ID_GUI_IRON_PAN) {
            return new ContainerIronPan((TileEntityIronPan) world.getTileEntity(new BlockPos(x, y, z)), player);
        } else {
            return null;
        }
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == ModConfig.ID_GUI_IRON_PAN) {
            return new GuiIronPan(new ContainerIronPan((TileEntityIronPan) world.getTileEntity(new BlockPos(x, y, z)), player));
        } else {
            return null;
        }
    }
}
