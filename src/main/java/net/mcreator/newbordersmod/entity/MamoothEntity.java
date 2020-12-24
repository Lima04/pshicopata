
package net.mcreator.newbordersmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.newbordersmod.NewBordersModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NewBordersModModElements.ModElement.Tag
public class MamoothEntity extends NewBordersModModElements.ModElement {
	public static EntityType entity = null;
	public MamoothEntity(NewBordersModModElements instance) {
		super(instance, 267);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(3f, 6f)).build("mammooth")
						.setRegistryName("mammooth");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421824, -6711040, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("mammooth_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("new_borders_mod:permafrost")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.AMBIENT).add(new Biome.SpawnListEntry(entity, 2, 1, 2));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelMamooth(), 3f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("new_borders_mod:textures/mammoth2.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.5));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1, false));
			this.targetSelector.addGoal(4, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, PolarBearEntity.class, true, false));
			this.goalSelector.addGoal(6, new SwimGoal(this));
			this.goalSelector.addGoal(7, new LeapAtTargetGoal(this, (float) 0.5));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40);
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.PataEsquerda2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.PataDireita1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.PataDireita2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.PataEsquerda1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}
}
