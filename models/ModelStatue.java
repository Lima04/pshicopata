// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelStatue extends EntityModel<Entity> {
	private final ModelRenderer BracoEsquerdo;
	private final ModelRenderer Cabeca;
	private final ModelRenderer BracoDireito;
	private final ModelRenderer Corpo;

	public ModelStatue() {
		textureWidth = 128;
		textureHeight = 128;

		BracoEsquerdo = new ModelRenderer(this);
		BracoEsquerdo.setRotationPoint(-3.0F, 13.0F, -1.0F);
		BracoEsquerdo.setTextureOffset(16, 42).addBox(7.0F, -12.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		Cabeca = new ModelRenderer(this);
		Cabeca.setRotationPoint(0.0F, 13.0F, 0.0F);
		Cabeca.setTextureOffset(32, 34).addBox(-4.0F, -20.0F, -5.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		BracoDireito = new ModelRenderer(this);
		BracoDireito.setRotationPoint(4.0F, 13.0F, 0.0F);
		BracoDireito.setTextureOffset(0, 42).addBox(-12.0F, -12.0F, -3.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		Corpo = new ModelRenderer(this);
		Corpo.setRotationPoint(3.0F, 13.0F, -1.0F);
		Corpo.setTextureOffset(0, 0).addBox(-15.0F, 10.0F, -12.0F, 24.0F, 2.0F, 24.0F, 0.0F, false);
		Corpo.setTextureOffset(0, 26).addBox(-9.0F, 4.0F, -4.0F, 12.0F, 6.0F, 8.0F, 0.0F, false);
		Corpo.setTextureOffset(0, 0).addBox(-7.0F, -12.0F, -2.0F, 8.0F, 16.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		BracoEsquerdo.render(matrixStack, buffer, packedLight, packedOverlay);
		Cabeca.render(matrixStack, buffer, packedLight, packedOverlay);
		BracoDireito.render(matrixStack, buffer, packedLight, packedOverlay);
		Corpo.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Cabeca.rotateAngleY = f2 / 20.f;
	}
}