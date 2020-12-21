
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
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

import net.mcreator.newbordersmod.procedures.SeagullStayEntityFallsProcedure;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NewBordersModModElements.ModElement.Tag
public class SeagullStayEntity extends NewBordersModModElements.ModElement {
	public static EntityType entity = null;
	public SeagullStayEntity(NewBordersModModElements instance) {
		super(instance, 233);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.6f, 1.8f)).build("seagull_stay")
						.setRegistryName("seagull_stay");
		elements.entities.add(() -> entity);
		elements.items.add(
				() -> new SpawnEggItem(entity, -1, -10066330, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("seagull_stay_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("ocean")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("beach")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("stone_shore")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_beach")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("warm_ocean")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("lukewarm_ocean")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("cold_ocean")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.AMBIENT).add(new Biome.SpawnListEntry(entity, 6, 1, 2));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelSeagullGround(), 0f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("new_borders_mod:textures/seagullstay.png");
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
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.3));
			this.goalSelector.addGoal(2, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("new_borders_mod:seagull_living"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("new_borders_mod:seagull_hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SeagullStayEntityFallsProcedure.executeProcedure($_dependencies);
			}
			return super.onLivingFall(l, d);
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SeagullStayEntityFallsProcedure.executeProcedure($_dependencies);
			}
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onCollideWithPlayer(PlayerEntity sourceentity) {
			super.onCollideWithPlayer(sourceentity);
			Entity entity = this;
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SeagullStayEntityFallsProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}
	}

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
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
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

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Head.rotateAngleY = f4 / (180F / (float) Math.PI);
			this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}
}
