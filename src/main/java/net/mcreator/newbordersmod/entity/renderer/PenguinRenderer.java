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

import net.mcreator.newbordersmod.entity.PenguinEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class PenguinRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(PenguinEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelPingu(), 0.3f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("new_borders_mod:textures/penguino.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.8.3
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelPingu extends EntityModel<Entity> {
		private final ModelRenderer PataDireita;
		private final ModelRenderer Corpo;
		private final ModelRenderer NadadeiraDireita;
		private final ModelRenderer Nadadeira2_r1;
		private final ModelRenderer NadadeiraTraseira;
		private final ModelRenderer NadadeiraTraseira_r1;
		private final ModelRenderer Cabeca;
		private final ModelRenderer PataEsquerda;
		private final ModelRenderer NadadeiraEsquerda;
		private final ModelRenderer Nadadeira1_r1;
		public ModelPingu() {
			textureWidth = 64;
			textureHeight = 64;
			PataDireita = new ModelRenderer(this);
			PataDireita.setRotationPoint(0.0F, 22.0F, 0.0F);
			PataDireita.setTextureOffset(42, 43).addBox(-4.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			PataDireita.setTextureOffset(11, 39).addBox(-4.0F, 1.0F, -3.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
			Corpo = new ModelRenderer(this);
			Corpo.setRotationPoint(0.0F, 22.0F, 0.0F);
			Corpo.setTextureOffset(0, 0).addBox(-4.0F, -13.0F, -4.0F, 8.0F, 12.0F, 9.0F, 0.0F, false);
			Corpo.setTextureOffset(25, 21).addBox(-3.0F, -14.0F, -3.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);
			NadadeiraDireita = new ModelRenderer(this);
			NadadeiraDireita.setRotationPoint(0.0F, 22.0F, 0.0F);
			Nadadeira2_r1 = new ModelRenderer(this);
			Nadadeira2_r1.setRotationPoint(-5.0F, -8.0F, 0.5F);
			NadadeiraDireita.addChild(Nadadeira2_r1);
			setRotationAngle(Nadadeira2_r1, 0.0F, 0.0F, 0.2182F);
			Nadadeira2_r1.setTextureOffset(27, 29).addBox(-1.0F, -5.0F, -3.5F, 2.0F, 10.0F, 7.0F, 0.0F, false);
			NadadeiraTraseira = new ModelRenderer(this);
			NadadeiraTraseira.setRotationPoint(0.0F, 20.0F, 5.5F);
			NadadeiraTraseira_r1 = new ModelRenderer(this);
			NadadeiraTraseira_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			NadadeiraTraseira.addChild(NadadeiraTraseira_r1);
			setRotationAngle(NadadeiraTraseira_r1, 0.3927F, 0.0F, 0.0F);
			NadadeiraTraseira_r1.setTextureOffset(25, 0).addBox(-3.0F, -3.0F, -0.5F, 6.0F, 6.0F, 1.0F, 0.0F, false);
			Cabeca = new ModelRenderer(this);
			Cabeca.setRotationPoint(0.0F, 7.0F, 0.0F);
			setRotationAngle(Cabeca, 0.0F, 0.0F, 0.0F);
			Cabeca.setTextureOffset(0, 21).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 6.0F, 9.0F, 0.0F, false);
			Cabeca.setTextureOffset(38, 29).addBox(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			PataEsquerda = new ModelRenderer(this);
			PataEsquerda.setRotationPoint(0.0F, 22.0F, 0.0F);
			PataEsquerda.setTextureOffset(0, 44).addBox(2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
			PataEsquerda.setTextureOffset(0, 36).addBox(2.0F, 1.0F, -3.0F, 2.0F, 1.0F, 7.0F, 0.0F, false);
			NadadeiraEsquerda = new ModelRenderer(this);
			NadadeiraEsquerda.setRotationPoint(0.0F, 22.0F, 0.0F);
			Nadadeira1_r1 = new ModelRenderer(this);
			Nadadeira1_r1.setRotationPoint(5.0F, -8.0F, 0.5F);
			NadadeiraEsquerda.addChild(Nadadeira1_r1);
			setRotationAngle(Nadadeira1_r1, 0.0F, 0.0F, -0.2182F);
			Nadadeira1_r1.setTextureOffset(34, 0).addBox(-1.0F, -5.0F, -3.5F, 2.0F, 10.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			PataDireita.render(matrixStack, buffer, packedLight, packedOverlay);
			Corpo.render(matrixStack, buffer, packedLight, packedOverlay);
			NadadeiraDireita.render(matrixStack, buffer, packedLight, packedOverlay);
			NadadeiraTraseira.render(matrixStack, buffer, packedLight, packedOverlay);
			Cabeca.render(matrixStack, buffer, packedLight, packedOverlay);
			PataEsquerda.render(matrixStack, buffer, packedLight, packedOverlay);
			NadadeiraEsquerda.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Cabeca.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Cabeca.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.PataEsquerda.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.PataDireita.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}