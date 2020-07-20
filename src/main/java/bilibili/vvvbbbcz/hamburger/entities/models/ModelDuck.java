package bilibili.vvvbbbcz.hamburger.entities.models;

import bilibili.vvvbbbcz.hamburger.entities.EntityDuck;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class ModelDuck extends AgeableModel<EntityDuck> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightWing;
    private final ModelRenderer leftWing;
    private final ModelRenderer bill;

    public ModelDuck() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0.0F, 15.0F, -2.0F);
        this.head.addBox(14, 0, -2.0F, -5.0F, -4.0F, 4, 5, 5, 0.0F);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 3.0F);
        body.addBox(0, 10, -3.0F, -5.0F, -4.0F, 6, 11, 6, 0.0F);

        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setRotationPoint(-1.0F, 19.0F, 7.0F);
        this.rightLeg.addBox(52, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F);

        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setRotationPoint(1.0F, 19.0F, 7.0F);
        this.leftLeg.addBox(52, 0, -1.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F);

        rightWing = new ModelRenderer(this);
        rightWing.setRotationPoint(-3.0F, 13.0F, 4.0F);
        rightWing.addBox(0, 27, -1.0F, 0.0F, -5.0F, 1, 5, 9, 0.0F);

        leftWing = new ModelRenderer(this);
        leftWing.setRotationPoint(3.0F, 13.0F, 4.0F);
        leftWing.addBox(0, 27, 0.0F, 0.0F, -5.0F, 1, 5, 9, 0.0F);

        this.bill = new ModelRenderer(this);
        this.bill.setRotationPoint(0.0F, 15.0F, -2.0F);
        this.bill.addBox(0, 0, -2.0F, -3.0F, -7.0F, 4, 2, 3, 0.0F);
    }

    @Nonnull
    @Override
    protected Iterable<ModelRenderer> getHeadParts() {
        return ImmutableList.of(this.head, this.bill);
    }

    @Nonnull
    @Override
    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(this.body, this.rightLeg, this.leftLeg, this.rightWing, this.leftWing);
    }

    @Override
    public void setRotationAngles(EntityDuck entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * 0.017453293F;
        this.head.rotateAngleY = netHeadYaw * 0.017453293F;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightWing.rotateAngleZ = ageInTicks;
        this.leftWing.rotateAngleZ = -ageInTicks;
    }
}