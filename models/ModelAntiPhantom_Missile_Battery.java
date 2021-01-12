// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class ModelAntiPhantom_Missile_Battery extends EntityModel<Entity> {
	private final ModelRenderer Radar;
	private final ModelRenderer cube_r1;
	private final ModelRenderer Radar3_r1;
	private final ModelRenderer Radar2_r1;
	private final ModelRenderer Radar1_r1;
	private final ModelRenderer bb_main;

	public ModelAntiPhantom_Missile_Battery() {
		textureWidth = 64;
		textureHeight = 64;

		Radar = new ModelRenderer(this);
		Radar.setRotationPoint(-6.3F, 7.5F, -7.3F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.2F, 0.5F, -1.2F);
		Radar.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.5708F, -1.0472F, 1.5708F);
		cube_r1.setTextureOffset(0, 13).addBox(-5.5F, -0.5F, -0.5F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Radar3_r1 = new ModelRenderer(this);
		Radar3_r1.setRotationPoint(8.8F, -1.5F, 0.8F);
		Radar.addChild(Radar3_r1);
		setRotationAngle(Radar3_r1, 0.0F, -1.5708F, 0.0F);
		Radar3_r1.setTextureOffset(0, 21).addBox(-1.5F, -2.0F, 3.5F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		Radar2_r1 = new ModelRenderer(this);
		Radar2_r1.setRotationPoint(3.8F, -1.5F, 0.8F);
		Radar.addChild(Radar2_r1);
		setRotationAngle(Radar2_r1, 0.0F, -1.5708F, 0.0F);
		Radar2_r1.setTextureOffset(30, 21).addBox(-1.5F, -2.0F, 2.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Radar1_r1 = new ModelRenderer(this);
		Radar1_r1.setRotationPoint(-0.2F, -1.5F, 0.8F);
		Radar.addChild(Radar1_r1);
		setRotationAngle(Radar1_r1, 0.0F, -1.5708F, 0.0F);
		Radar1_r1.setTextureOffset(0, 26).addBox(-1.5F, -2.0F, 3.5F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Radar1_r1.setTextureOffset(29, 29).addBox(-1.5F, 1.0F, -5.5F, 3.0F, 2.0F, 11.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 5.0F, 16.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 21).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 5.0F, 10.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-8.0F, -15.0F, -8.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Radar.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Radar.rotateAngleY = f2 / 20.f;
	}
}