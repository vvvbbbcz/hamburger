package bilibili.vvvbbbcz.hamburger.client.renderer.entity.model;

import bilibili.vvvbbbcz.hamburger.entity.DuckEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nonnull;

public class DuckModel extends AgeableModel<DuckEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer rightLeg;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightWing;
	private final ModelRenderer leftWing;
	private final ModelRenderer bill;

	public DuckModel() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.setTextureOffset(14, 0).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 5.0F, 5.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 15.0F, 1.0F);
		body.setTextureOffset(0, 10).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(-1.0F, 19.0F, 5.0F);
		rightLeg.setTextureOffset(52, 0).addBox(-2.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(1.0F, 19.0F, 5.0F);
		leftLeg.setTextureOffset(52, 0).addBox(-1.0F, 0.0F, -3.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		rightWing = new ModelRenderer(this);
		rightWing.setRotationPoint(-3.0F, 13.0F, 2.0F);
		rightWing.setTextureOffset(0, 27).addBox(-1.0F, 0.0F, -5.0F, 1.0F, 5.0F, 9.0F, 0.0F, false);

		leftWing = new ModelRenderer(this);
		leftWing.setRotationPoint(3.0F, 13.0F, 2.0F);
		leftWing.setTextureOffset(0, 27).addBox(0.0F, 0.0F, -5.0F, 1.0F, 5.0F, 9.0F, 0.0F, false);

		bill = new ModelRenderer(this);
		bill.setRotationPoint(0.0F, 15.0F, -4.0F);
		bill.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -7.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
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
	public void setRotationAngles(DuckEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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