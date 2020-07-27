package bilibili.vvvbbbcz.hamburger.client.renderer.entity;

import bilibili.vvvbbbcz.hamburger.entity.DuckEggEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDuckEgg extends SpriteRenderer<DuckEggEntity> {
    public RenderDuckEgg(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, Minecraft.getInstance().getItemRenderer());
    }
}