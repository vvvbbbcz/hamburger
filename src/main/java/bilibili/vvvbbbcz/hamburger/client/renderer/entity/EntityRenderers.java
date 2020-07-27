package bilibili.vvvbbbcz.hamburger.client.renderer.entity;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class EntityRenderers {
    public static void register() {
        RenderingRegistry.registerEntityRenderingHandler(Entities.DUCK, RenderDuck::new);
        RenderingRegistry.registerEntityRenderingHandler(Entities.DUCK_EGG, RenderDuckEgg::new);
    }
}
