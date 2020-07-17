package bilibili.vvvbbbcz.hamburger.entities.renders;

import bilibili.vvvbbbcz.largeprojectslao8.entities.EntityDuckEgg;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;

public class RenderDuckEgg extends RenderSnowball<EntityDuckEgg> {
    public RenderDuckEgg(RenderManager renderManagerIn) {
        super(renderManagerIn, RegisterLoader.itemDuckEgg, Minecraft.getMinecraft().getRenderItem());
    }
}
