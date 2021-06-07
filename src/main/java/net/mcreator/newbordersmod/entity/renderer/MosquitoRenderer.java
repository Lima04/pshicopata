package net.mcreator.newbordersmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.newbordersmod.entity.MosquitoEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MosquitoRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MosquitoEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelMosquito(), 0f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("new_borders_mod:textures/mosquito.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelMosquito extends EntityModel<Entity> {
		private final ModelRenderer Asa;
		private final ModelRenderer Asar_r1;
		private final ModelRenderer Asal_r1;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		public ModelMosquito() {
			textureWidth = 16;
			textureHeight = 16;
			Asa = new ModelRenderer(this);
			Asa.setRotationPoint(0.2F, 22.0F, -0.05F);
			Asar_r1 = new ModelRenderer(this);
			Asar_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
			Asa.addChild(Asar_r1);
			setRotationAngle(Asar_r1, 0.2793F, -0.3665F, 0.0F);
			Asar_r1.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, -0.65F, 1.0F, 0.0F, 4.0F, 0.0F, false);
			Asal_r1 = new ModelRenderer(this);
			Asal_r1.setRotationPoint(0.6F, -1.0F, 0.0F);
			Asa.addChild(Asal_r1);
			setRotationAngle(Asal_r1, 0.2793F, 0.3665F, 0.0F);
			Asal_r1.setTextureOffset(2, 2).addBox(-0.5F, 0.0F, -0.65F, 1.0F, 0.0F, 4.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			bb_main.setTextureOffset(0, 5).addBox(0.0F, -3.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(16, 4).addBox(0.5F, -2.8F, -1.1F, 0.0F, 0.0F, 0.0F, 0.0F, false);
			bb_main.setTextureOffset(0, 0).addBox(0.0F, -3.0F, -0.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			bb_main.setTextureOffset(16, 7).addBox(0.5F, -2.8F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.5F, -2.25F, -1.8F);
			bb_main.addChild(cube_r1);
			setRotationAngle(cube_r1, 1.5708F, 0.576F, 1.5708F);
			cube_r1.setTextureOffset(12, 0).addBox(-0.3F, -0.25F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -2.75F, -0.5F);
			bb_main.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 2.3562F);
			cube_r2.setTextureOffset(12, 2).addBox(-0.3F, -0.25F, -0.2F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r2.setTextureOffset(12, 2).addBox(-0.3F, -0.25F, 0.4F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r2.setTextureOffset(12, 3).addBox(-0.3F, -0.25F, 1.1F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.0F, -2.75F, 0.8F);
			bb_main.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, 0.9948F);
			cube_r3.setTextureOffset(12, 0).addBox(-0.3F, -0.25F, -0.2F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r3.setTextureOffset(12, 1).addBox(-0.3F, -0.25F, -0.9F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r3.setTextureOffset(12, 2).addBox(-0.3F, -0.25F, -1.5F, 2.0F, 0.0F, 0.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.5F, -2.0F, 2.45F);
			bb_main.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.3491F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(0, 2).addBox(-0.5F, -0.5F, -1.45F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Asa.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Asar_r1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Asal_r1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}
}
