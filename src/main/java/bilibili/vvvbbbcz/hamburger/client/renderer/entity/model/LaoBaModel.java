package bilibili.vvvbbbcz.hamburger.client.renderer.entity.model;

import bilibili.vvvbbbcz.hamburger.entity.LaoBaEntity;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaoBaModel extends BipedModel<LaoBaEntity> {
    public final ModelRenderer bipedLeftArmWear;
    public final ModelRenderer bipedRightArmWear;
    public final ModelRenderer bipedBodyWear;

    public LaoBaModel(float modelSize) {
        super(RenderType::getEntityTranslucent, modelSize, 0.0F, 64, 64);

        this.bipedLeftArm = new ModelRenderer(this, 32, 48);
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);

        this.bipedLeftArmWear = new ModelRenderer(this, 48, 48);
        this.bipedLeftArmWear.addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedLeftArmWear.setRotationPoint(5.0F, 2.0F, 0.0F);

        this.bipedRightArmWear = new ModelRenderer(this, 40, 32);
        this.bipedRightArmWear.addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedRightArmWear.setRotationPoint(-5.0F, 2.0F, 10.0F);

        this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, modelSize);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);

        this.bipedBodyWear = new ModelRenderer(this, 16, 32);
        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, modelSize + 0.25F);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    protected Iterable<ModelRenderer> getBodyParts() {
        return Iterables.concat(super.getBodyParts(), ImmutableList.of(this.bipedLeftArmWear, this.bipedRightArmWear, this.bipedBodyWear));
    }

    public void setRotationAngles(LaoBaEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        this.bipedLeftArmWear.copyModelAngles(this.bipedLeftArm);
        this.bipedRightArmWear.copyModelAngles(this.bipedRightArm);
        this.bipedBodyWear.copyModelAngles(this.bipedBody);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        this.bipedLeftArmWear.showModel = visible;
        this.bipedRightArmWear.showModel = visible;
        this.bipedBodyWear.showModel = visible;
    }

    public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
        ModelRenderer modelrenderer = this.getArmForSide(sideIn);
        modelrenderer.translateRotate(matrixStackIn);
    }
}
