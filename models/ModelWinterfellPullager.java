// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelWinterfellPullager extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer nose;
	private final ModelRenderer body;
	private final ModelRenderer right_leg;
	private final ModelRenderer right_leg_sub_0;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_arm;
	private final ModelRenderer right_arm_sub_0;
	private final ModelRenderer left_arm;

	public ModelWinterfellPullager() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -1.0F);
		head.setTextureOffset(36, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(28, 30).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F, 0.25F, false);
		head.setTextureOffset(52, 18).addBox(4.4F, -10.0F, -4.0F, 2.0F, 10.0F, 8.0F, 0.25F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(-5.4F, -5.0F, 0.5F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, 3.1416F, 0.0F);
		head_r1.setTextureOffset(44, 48).addBox(-1.0F, -5.0F, -3.5F, 2.0F, 10.0F, 8.0F, 0.25F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(0.5F, -11.4F, 1.5F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 1.5708F, 0.0F, -1.5708F);
		head_r2.setTextureOffset(0, 104).addBox(-1.0F, -6.0F, -6.0F, 2.0F, 11.0F, 13.0F, 0.25F, false);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(2.0F, -5.0F, 5.5F);
		head.addChild(head_r3);
		setRotationAngle(head_r3, 0.0F, -1.5708F, 0.0F);
		head_r3.setTextureOffset(98, 23).addBox(-1.0F, -5.0F, -4.5F, 2.0F, 10.0F, 13.0F, 0.25F, false);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 12.0F, 8.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);

		right_leg_sub_0 = new ModelRenderer(this);
		right_leg_sub_0.setRotationPoint(2.0F, 12.0F, 0.0F);
		right_leg.addChild(right_leg_sub_0);
		right_leg_sub_0.setTextureOffset(60, 36).addBox(0.0F, -12.0F, -3.0F, 4.0F, 12.0F, 6.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
		left_leg.setTextureOffset(58, 60).addBox(-6.0F, 0.0F, -3.0F, 4.0F, 12.0F, 6.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-7.0F, 2.0F, 0.0F);

		right_arm_sub_0 = new ModelRenderer(this);
		right_arm_sub_0.setRotationPoint(7.0F, 22.0F, 0.0F);
		right_arm.addChild(right_arm_sub_0);
		right_arm_sub_0.setTextureOffset(22, 48).addBox(4.0F, -24.0F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(7.0F, 2.0F, 0.0F);
		left_arm.setTextureOffset(0, 43).addBox(-16.0F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		nose.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.nose.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.nose.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}