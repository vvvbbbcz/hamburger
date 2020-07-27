package bilibili.vvvbbbcz.hamburger.client.renderer;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTypes {
    public static void registerRenderLayers() {
        RenderTypeLookup.setRenderLayer(Blocks.LEMON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(Blocks.IRON_PLATE.get(), RenderType.getCutout());
    }
}
