// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelMamooth extends EntityModel<Entity> {
	private final ModelRenderer Rosto;
	private final ModelRenderer OrelhaEsquerda_r1;
	private final ModelRenderer Chifres;
	private final ModelRenderer Tromba;
	private final ModelRenderer Corpo;
	private final ModelRenderer PataDireita1;
	private final ModelRenderer PataEsquerda1;
	private final ModelRenderer PataDireita2;
	private final ModelRenderer PataEsquerda2;

	public ModelMamooth() {
		textureWidth = 512;
		textureHeight = 512;

		Rosto = new ModelRenderer(this);
		Rosto.setRotationPoint(46.0F, -23.0F, -71.0F);
		Rosto.setTextureOffset(0, 119).addBox(-44.0F, -50.0F, 50.0F, 4.0F, 18.0F, 17.0F, 0.0F, false);
		Rosto.setTextureOffset(186, 186).addBox(-40.0F, -61.0F, 42.0F, 36.0F, 43.0F, 32.0F, 0.0F, false);
		Rosto.setTextureOffset(0, 211).addBox(-38.0F, -80.0F, 45.0F, 32.0F, 20.0F, 28.0F, 0.0F, false);
		Rosto.setTextureOffset(173, 119).addBox(-40.0F, -18.0F, 55.0F, 36.0F, 19.0F, 19.0F, 0.0F, false);
		Rosto.setTextureOffset(194, 0).addBox(-38.0F, -58.0F, 72.0F, 32.0F, 20.0F, 28.0F, 0.0F, false);

		OrelhaEsquerda_r1 = new ModelRenderer(this);
		OrelhaEsquerda_r1.setRotationPoint(-2.0F, -41.0F, 58.5F);
		Rosto.addChild(OrelhaEsquerda_r1);
		setRotationAngle(OrelhaEsquerda_r1, -3.1416F, 0.0F, 3.1416F);
		OrelhaEsquerda_r1.setTextureOffset(290, 165).addBox(-2.0F, -9.0F, -8.5F, 4.0F, 18.0F, 17.0F, 0.0F, false);

		Chifres = new ModelRenderer(this);
		Chifres.setRotationPoint(-62.0F, 43.0F, -95.0F);
		Rosto.addChild(Chifres);
		Chifres.setTextureOffset(42, 320).addBox(54.0F, -76.0F, 122.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(0, 320).addBox(56.0F, -69.0F, 118.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(319, 319).addBox(56.0F, -63.0F, 110.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(137, 317).addBox(56.0F, -64.0F, 94.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(315, 183).addBox(56.0F, -67.0F, 77.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(0, 294).addBox(22.0F, -76.0F, 122.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(42, 294).addBox(20.0F, -69.0F, 118.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(305, 244).addBox(20.0F, -63.0F, 110.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(201, 306).addBox(20.0F, -64.0F, 94.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);
		Chifres.setTextureOffset(243, 306).addBox(20.0F, -67.0F, 77.0F, 4.0F, 9.0F, 17.0F, 0.0F, false);

		Tromba = new ModelRenderer(this);
		Tromba.setRotationPoint(62.0F, 33.0F, -148.3F);
		Tromba.setTextureOffset(194, 48).addBox(-56.0F, -112.0F, 117.3F, 36.0F, 5.0F, 2.0F, 0.0F, false);
		Tromba.setTextureOffset(0, 259).addBox(-56.0F, -107.0F, 104.3F, 36.0F, 18.0F, 17.0F, 0.0F, false);
		Tromba.setTextureOffset(106, 244).addBox(-54.0F, -103.0F, 87.3F, 31.0F, 18.0F, 17.0F, 0.0F, false);
		Tromba.setTextureOffset(260, 48).addBox(-52.0F, -96.0F, 81.0F, 27.0F, 18.0F, 17.0F, 0.0F, false);
		Tromba.setTextureOffset(260, 83).addBox(-49.0F, -83.0F, 77.0F, 22.0F, 18.0F, 17.0F, 0.0F, false);
		Tromba.setTextureOffset(202, 261).addBox(-47.0F, -67.0F, 77.0F, 18.0F, 28.0F, 17.0F, 0.0F, false);

		Corpo = new ModelRenderer(this);
		Corpo.setRotationPoint(48.0F, -19.0F, 62.0F);
		Corpo.setTextureOffset(0, 0).addBox(-56.0F, -53.0F, -74.0F, 64.0F, 53.0F, 66.0F, 0.0F, false);
		Corpo.setTextureOffset(0, 119).addBox(-56.0F, -47.0F, -8.0F, 64.0F, 47.0F, 45.0F, 0.0F, false);

		PataDireita1 = new ModelRenderer(this);
		PataDireita1.setRotationPoint(0.0F, 13.0F, 0.0F);
		PataDireita1.setTextureOffset(154, 290).addBox(-8.0F, 0.0F, -13.0F, 16.0F, 11.0F, 16.0F, 0.0F, false);
		PataDireita1.setTextureOffset(154, 64).addBox(-8.0F, -35.0F, -13.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);

		PataEsquerda1 = new ModelRenderer(this);
		PataEsquerda1.setRotationPoint(48.0F, 24.0F, 0.0F);
		PataEsquerda1.setTextureOffset(154, 64).addBox(-8.0F, -46.0F, -13.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		PataEsquerda1.setTextureOffset(286, 0).addBox(-8.0F, -11.0F, -13.0F, 16.0F, 11.0F, 16.0F, 0.0F, false);

		PataDireita2 = new ModelRenderer(this);
		PataDireita2.setRotationPoint(0.0F, 24.0F, 84.0F);
		PataDireita2.setTextureOffset(154, 64).addBox(-8.0F, -46.0F, -8.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		PataDireita2.setTextureOffset(92, 211).addBox(-8.0F, -11.0F, -8.0F, 16.0F, 11.0F, 16.0F, 0.0F, false);

		PataEsquerda2 = new ModelRenderer(this);
		PataEsquerda2.setRotationPoint(48.0F, 13.0F, 84.0F);
		PataEsquerda2.setTextureOffset(218, 157).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 11.0F, 16.0F, 0.0F, false);
		PataEsquerda2.setTextureOffset(154, 64).addBox(-8.0F, -35.0F, -8.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Rosto.render(matrixStack, buffer, packedLight, packedOverlay);
		Tromba.render(matrixStack, buffer, packedLight, packedOverlay);
		Corpo.render(matrixStack, buffer, packedLight, packedOverlay);
		PataDireita1.render(matrixStack, buffer, packedLight, packedOverlay);
		PataEsquerda1.render(matrixStack, buffer, packedLight, packedOverlay);
		PataDireita2.render(matrixStack, buffer, packedLight, packedOverlay);
		PataEsquerda2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.PataEsquerda2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.PataDireita1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.PataDireita2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.PataEsquerda1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}