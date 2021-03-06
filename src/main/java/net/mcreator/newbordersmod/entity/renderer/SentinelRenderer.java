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

import net.mcreator.newbordersmod.entity.SentinelEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SentinelRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SentinelEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelSentinel(), 0.2f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("new_borders_mod:textures/sentinel.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelSentinel extends EntityModel<Entity> {
		private final ModelRenderer Mainbody;
		private final ModelRenderer Garras;
		private final ModelRenderer cube_r1;
		public ModelSentinel() {
			textureWidth = 32;
			textureHeight = 32;
			Mainbody = new ModelRenderer(this);
			Mainbody.setRotationPoint(-0.7F, 21.0F, 3.0F);
			Mainbody.setTextureOffset(0, 0).addBox(-2.0F, -5.0F, -8.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);
			Mainbody.setTextureOffset(0, 13).addBox(-1.0F, -6.0F, -7.0F, 3.0F, 1.0F, 6.0F, 0.0F, false);
			Mainbody.setTextureOffset(14, 16).addBox(-1.0F, -4.0F, 0.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
			Garras = new ModelRenderer(this);
			Garras.setRotationPoint(2.5F, 1.0F, -6.5F);
			Mainbody.addChild(Garras);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			Garras.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.9163F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 5).addBox(-0.5F, 3.0F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r1.setTextureOffset(3, 0).addBox(-4.5F, 3.0F, -1.5F, 1.0F, 1.0F, 0.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-4.5F, -1.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(4, 0).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Mainbody.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Garras.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
