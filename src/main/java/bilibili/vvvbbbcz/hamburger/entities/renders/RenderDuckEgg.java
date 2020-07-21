//package bilibili.vvvbbbcz.hamburger.entities.renders;
//
//import net.minecraft.client.Minecraft;
//
//public class RenderDuckEgg extends RenderSnowball<EntityDuckEgg> { // TODO 可能不需要
//    public RenderDuckEgg(RenderManager renderManagerIn) {
//        super(renderManagerIn, RegisterLoader.itemDuckEgg, Minecraft.getMinecraft().getRenderItem());
//    }
//}

package bilibili.vvvbbbcz.hamburger.entities.renders;

import bilibili.vvvbbbcz.hamburger.entities.EntityDuckEgg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;

public class RenderDuckEgg extends SpriteRenderer<EntityDuckEgg> {
    public RenderDuckEgg(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, Minecraft.getInstance().getItemRenderer());
    }
}