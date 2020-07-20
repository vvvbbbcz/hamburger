package bilibili.vvvbbbcz.hamburger.entities.renders;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.entities.EntityDuck;
import bilibili.vvvbbbcz.hamburger.entities.models.ModelDuck;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RenderDuck extends MobRenderer<EntityDuck, ModelDuck> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID, "textures/entities/duck.png");

    public RenderDuck(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDuck(), 0.3F);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull EntityDuck entity) {
        return TEXTURE;
    }

    @Override
    protected float handleRotationFloat(EntityDuck livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
