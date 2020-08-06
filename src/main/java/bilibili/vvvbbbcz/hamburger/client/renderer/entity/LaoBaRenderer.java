package bilibili.vvvbbbcz.hamburger.client.renderer.entity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.client.renderer.entity.model.LaoBaModel;
import bilibili.vvvbbbcz.hamburger.entity.LaoBaEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;

@OnlyIn(Dist.CLIENT)
public class LaoBaRenderer extends BipedRenderer<LaoBaEntity, LaoBaModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID, "textures/entity/lao_ba.png");

    public LaoBaRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new LaoBaModel(0.0F), 0.5F);
    }

    @Override
    public void render(LaoBaEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        this.setModelVisibilities(entityIn);
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Override
    public Vec3d getRenderOffset(LaoBaEntity entityIn, float partialTicks) {
        return entityIn.isCrouching() ? new Vec3d(0.0D, -0.125D, 0.0D) : super.getRenderOffset(entityIn, partialTicks);
    }

    private void setModelVisibilities(LaoBaEntity entity) {
        LaoBaModel model = this.getEntityModel();
        ItemStack stack = entity.getHeldItemMainhand();
        ItemStack stack1 = entity.getHeldItemOffhand();
        model.setVisible(true);
        model.rightArmPose = this.getArmPose(entity, stack, stack1, Hand.MAIN_HAND);
        model.leftArmPose = this.getArmPose(entity, stack, stack1, Hand.OFF_HAND);
    }

    private BipedModel.ArmPose getArmPose(LaoBaEntity entity, ItemStack itemStackMain, ItemStack itemStackOff, Hand handIn) {
        ItemStack stack = (handIn == Hand.MAIN_HAND ? itemStackMain : itemStackOff);
        return stack.isEmpty() ? BipedModel.ArmPose.EMPTY : BipedModel.ArmPose.ITEM;
    }

    @Nonnull
    @Override
    public ResourceLocation getEntityTexture(LaoBaEntity entity) {
        return TEXTURE;
    }
}
