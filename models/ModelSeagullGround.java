// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSeagullGround extends EntityModel<Entity> {
	private final ModelRenderer WingBaseRight;
	private final ModelRenderer WingBaseLeft;
	private final ModelRenderer WingBaseLeft_r1;
	private final ModelRenderer Backwing;
	private final ModelRenderer Backwing_r1;
	private final ModelRenderer Corpo;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer Pernino_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer Pernina_r1;
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;

	public ModelSeagullGround() {
		textureWidth = 32;
		textureHeight = 32;

		WingBaseRight = new ModelRenderer(this);
		WingBaseRight.setRotationPoint(-5.0F, 16.0F, 6.0F);
		WingBaseRight.setTextureOffset(10, 0).addBox(3.0F, 4.2F, -7.9F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		WingBaseLeft = new ModelRenderer(this);
		WingBaseLeft.setRotationPoint(0.0F, 24.0F, 0.0F);

		WingBaseLeft_r1 = new ModelRenderer(this);
		WingBaseLeft_r1.setRotationPoint(1.0F, -4.8F, 2.1F);
		WingBaseLeft.addChild(WingBaseLeft_r1);
		setRotationAngle(WingBaseLeft_r1, 0.0F, 0.0F, 1.5708F);
		WingBaseLeft_r1.setTextureOffset(8, 10).addBox(1.0F, -1.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

		Backwing = new ModelRenderer(this);
		Backwing.setRotationPoint(0.0F, 16.3F, 9.0F);

		Backwing_r1 = new ModelRenderer(this);
		Backwing_r1.setRotationPoint(0.0F, 5.6F, -10.4F);
		Backwing.addChild(Backwing_r1);
		setRotationAngle(Backwing_r1, -0.3142F, 0.0F, 0.0F);
		Backwing_r1.setTextureOffset(13, 6).addBox(-1.0F, -2.7F, 3.1F, 2.0F, 1.0F, 3.0F, 0.0F, false);

		Corpo = new ModelRenderer(this);
		Corpo.setRotationPoint(0.0F, 16.0F, 6.0F);
		Corpo.setTextureOffset(0, 0).addBox(-1.0F, 4.2F, -8.9F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(0.0F, 16.0F, 6.0F);

		Pernino_r1 = new ModelRenderer(this);
		Pernino_r1.setRotationPoint(1.2F, 5.4F, -7.0F);
		LeftLeg.addChild(Pernino_r1);
		setRotationAngle(Pernino_r1, -1.5533F, 0.0F, 0.0F);
		Pernino_r1.setTextureOffset(0, 14).addBox(-0.9F, -1.6F, -0.4F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(1.2F, 21.4F, -1.0F);

		Pernina_r1 = new ModelRenderer(this);
		Pernina_r1.setRotationPoint(-1.6F, 0.0F, 0.0F);
		RightLeg.addChild(Pernina_r1);
		setRotationAngle(Pernina_r1, -1.5533F, 0.0F, 0.0F);
		Pernina_r1.setTextureOffset(5, 15).addBox(-0.9F, -1.6F, -0.4F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(1.2F, 21.4F, -1.0F);
		Head.setTextureOffset(0, 0).addBox(-1.7F, -2.6F, -3.2F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(-1.2F, -4.2F, 3.1F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 1.5708F, 0.0F, 0.0F);
		Head_r1.setTextureOffset(0, 8).addBox(-1.0F, -5.0F, -5.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		WingBaseRight.render(matrixStack, buffer, packedLight, packedOverlay);
		WingBaseLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		Backwing.render(matrixStack, buffer, packedLight, packedOverlay);
		Corpo.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f4 / (180F / (float) Math.PI);
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}