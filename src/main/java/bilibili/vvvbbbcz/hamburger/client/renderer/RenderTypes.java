package bilibili.vvvbbbcz.hamburger.client.renderer;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import bilibili.vvvbbbcz.hamburger.fluid.Fluids;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderTypes {
    public static void registerRenderLayers() {
        // Blocks
        RenderTypeLookup.setRenderLayer(Blocks.LEMON_SAPLING, RenderType.getCutout());
        // Fluids
        RenderTypeLookup.setRenderLayer(Fluids.SHIT, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(Fluids.FLOWING_SHIT, RenderType.getTranslucent());
    }
}
