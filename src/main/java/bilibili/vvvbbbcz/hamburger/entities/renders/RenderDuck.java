package bilibili.vvvbbbcz.hamburger.entities.renders;

import bilibili.vvvbbbcz.largeprojectslao8.entities.EntityDuck;
import bilibili.vvvbbbcz.largeprojectslao8.entities.models.ModelDuck;
import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RenderDuck extends RenderLiving<EntityDuck> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LargeprojectsLao8.MODID + ":textures/entities/duck.png");

    public RenderDuck(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelDuck(), 0.5F);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@Nonnull EntityDuck entity) {
        return TEXTURE;
    }

    @Override
    protected float handleRotationFloat(EntityDuck livingBase, float partialTicks) {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
