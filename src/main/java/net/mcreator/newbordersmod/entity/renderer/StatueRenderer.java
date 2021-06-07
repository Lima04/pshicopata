package net.mcreator.newbordersmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.newbordersmod.entity.StatueEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class StatueRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(StatueEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelStatue(), 0f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("new_borders_mod:textures/statue.png");
					}
				};
			});
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Cabeca.rotateAngleY = f2 / 20.f;
		}
	}
}
