package bilibili.vvvbbbcz.hamburger.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDuck extends ModelBase {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer rightLeg;
    private final ModelRenderer leftLeg;
    private final ModelRenderer rightWing;
    private final ModelRenderer leftWing;
    private final ModelRenderer bill;

    public ModelDuck() {
        textureWidth = 64;
        textureHeight = 64;

        this.head = new ModelRenderer(this);
        this.head.setRotationPoint(0.0F, 15.0F, -2.0F);
        this.head.cubeList.add(new ModelBox(head, 14, 0, -2.0F, -5.0F, -4.0F, 4, 5, 5, 0.0F, false));

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 3.0F);
        body.cubeList.add(new ModelBox(body, 0, 10, -3.0F, -5.0F, -4.0F, 6, 11, 6, 0.0F, false));

        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setRotationPoint(-1.0F, 19.0F, 7.0F);
        this.rightLeg.cubeList.add(new ModelBox(rightLeg, 52, 0, -2.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));

        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setRotationPoint(1.0F, 19.0F, 7.0F);
        this.leftLeg.cubeList.add(new ModelBox(leftLeg, 52, 0, -1.0F, 0.0F, -3.0F, 3, 5, 3, 0.0F, false));

        rightWing = new ModelRenderer(this);
        rightWing.setRotationPoint(-3.0F, 13.0F, 4.0F);
        rightWing.cubeList.add(new ModelBox(rightWing, 0, 27, -1.0F, 0.0F, -5.0F, 1, 5, 9, 0.0F, false));

        leftWing = new ModelRenderer(this);
        leftWing.setRotationPoint(3.0F, 13.0F, 4.0F);
        leftWing.cubeList.add(new ModelBox(leftWing, 0, 27, 0.0F, 0.0F, -5.0F, 1, 5, 9, 0.0F, false));

        this.bill = new ModelRenderer(this);
        this.bill.setRotationPoint(0.0F, 15.0F, -2.0F);
        this.bill.cubeList.add(new ModelBox(bill, 0, 0, -2.0F, -3.0F, -7.0F, 4, 2, 3, 0.0F, false));
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        if (this.isChild) {
            float f = 2.0F;
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 5.0F * scale, 2.0F * scale);
            this.head.render(scale);
            this.bill.render(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.body.render(scale);
            this.rightLeg.render(scale);
            this.leftLeg.render(scale);
            this.rightWing.render(scale);
            this.leftWing.render(scale);
            GlStateManager.popMatrix();
        } else {
            this.head.render(scale);
            this.bill.render(scale);
            this.body.render(scale);
            this.rightLeg.render(scale);
            this.leftLeg.render(scale);
            this.rightWing.render(scale);
            this.leftWing.render(scale);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.head.rotateAngleX = headPitch * 0.017453292F;
        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.bill.rotateAngleX = this.head.rotateAngleX;
        this.bill.rotateAngleY = this.head.rotateAngleY;
        this.body.rotateAngleX = ((float) Math.PI / 2F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightWing.rotateAngleZ = ageInTicks;
        this.leftWing.rotateAngleZ = -ageInTicks;
    }
}