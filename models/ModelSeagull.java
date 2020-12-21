// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelSeagull extends EntityModel<Entity> {
	private final ModelRenderer WingBaseRight;
	private final ModelRenderer WingBaseLeft;
	private final ModelRenderer WingLeft;
	private final ModelRenderer WingRight;
	private final ModelRenderer Backwing;
	private final ModelRenderer Corpo;

	public ModelSeagull() {
		textureWidth = 32;
		textureHeight = 32;

		WingBaseRight = new ModelRenderer(this);
		WingBaseRight.setRotationPoint(-5.0F, 16.0F, 6.0F);
		WingBaseRight.setTextureOffset(0, 14).addBox(1.0F, -2.0F, -10.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		WingBaseLeft = new ModelRenderer(this);
		WingBaseLeft.setRotationPoint(0.0F, 24.0F, 0.0F);
		WingBaseLeft.setTextureOffset(10, 10).addBox(1.0F, -10.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		WingLeft = new ModelRenderer(this);
		WingLeft.setRotationPoint(6.0F, 16.0F, 6.0F);
		WingLeft.setTextureOffset(0, 9).addBox(-2.0F, -2.0F, -10.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		WingRight = new ModelRenderer(this);
		WingRight.setRotationPoint(0.0F, 24.0F, 0.0F);
		WingRight.setTextureOffset(11, 0).addBox(-7.0F, -10.0F, -4.0F, 3.0F, 1.0F, 4.0F, 0.0F, false);

		Backwing = new ModelRenderer(this);
		Backwing.setRotationPoint(0.0F, 16.3F, 9.0F);
		Backwing.setTextureOffset(14, 15).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);

		Corpo = new ModelRenderer(this);
		Corpo.setRotationPoint(0.0F, 16.0F, 6.0F);
		Corpo.setTextureOffset(0, 0).addBox(-0.5F, -1.0F, -14.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		Corpo.setTextureOffset(0, 0).addBox(-1.0F, -2.0F, -12.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		WingBaseRight.render(matrixStack, buffer, packedLight, packedOverlay);
		WingBaseLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		WingLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		WingRight.render(matrixStack, buffer, packedLight, packedOverlay);
		Backwing.render(matrixStack, buffer, packedLight, packedOverlay);
		Corpo.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}