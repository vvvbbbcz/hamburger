package bilibili.vvvbbbcz.hamburger.client.renderer.entity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.entity.DuckEntity;
import bilibili.vvvbbbcz.hamburger.client.renderer.entity.model.ModelDuck;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class RenderDuck extends MobRenderer<DuckEntity, ModelDuck> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID, "textures/entities/duck.png");

    public RenderDuck(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDuck(), 0.3F);
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(@Nonnull DuckEntity entity) {
        return TEXTURE;
    }

    @Override
    protected float handleRotationFloat(DuckEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }
}
