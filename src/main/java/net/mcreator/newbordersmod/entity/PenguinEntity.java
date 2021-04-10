
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
import net.minecraft.world.IWorldReader;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.material.Material;

import net.mcreator.newbordersmod.NewBordersModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NewBordersModModElements.ModElement.Tag
public class PenguinEntity extends NewBordersModModElements.ModElement {
	public static EntityType entity = null;
	public PenguinEntity(NewBordersModModElements instance) {
		super(instance, 196);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.CREATURE).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).size(0.5f, 1f)).build("penguin")
						.setRegistryName("penguin");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -13421773, -1, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("penguin_spawn_egg"));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
			boolean biomeCriteria = false;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("frozen_ocean")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("frozen_river")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("snowy_beach")))
				biomeCriteria = true;
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("cold_ocean")))
				biomeCriteria = true;
			if (!biomeCriteria)
				continue;
			biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(entity, 12, 1, 4));
		}
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos,
						random) -> (world.getBlockState(pos.down()).getMaterial() == Material.ORGANIC && world.getLightSubtracted(pos, 0) > 8));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelPingu(), 0.3f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("new_borders_mod:textures/penguino.png");
				}
			};
		});
	}
	public static class CustomEntity extends AnimalEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 0;
			setNoAI(false);
			this.moveController = new MovementController(this) {
				@Override
				public void tick() {
					if (CustomEntity.this.areEyesInFluid(FluidTags.WATER))
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, 0.005, 0));
					if (this.action == MovementController.Action.MOVE_TO && !CustomEntity.this.getNavigator().noPath()) {
						double dx = this.posX - CustomEntity.this.getPosX();
						double dy = this.posY - CustomEntity.this.getPosY();
						double dz = this.posZ - CustomEntity.this.getPosZ();
						dy = dy / (double) MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
						CustomEntity.this.rotationYaw = this.limitAngle(CustomEntity.this.rotationYaw,
								(float) (MathHelper.atan2(dz, dx) * (double) (180 / (float) Math.PI)) - 90, 90);
						CustomEntity.this.renderYawOffset = CustomEntity.this.rotationYaw;
						CustomEntity.this.setAIMoveSpeed(MathHelper.lerp(0.125f, CustomEntity.this.getAIMoveSpeed(),
								(float) (this.speed * CustomEntity.this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue())));
						CustomEntity.this.setMotion(CustomEntity.this.getMotion().add(0, CustomEntity.this.getAIMoveSpeed() * dy * 0.1, 0));
					} else {
						CustomEntity.this.setAIMoveSpeed(0);
					}
				}
			};
			this.navigator = new SwimmerPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1.2, 40));
			this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.5));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 0.7, false));
			this.goalSelector.addGoal(4, new PanicGoal(this, 1.2));
			this.goalSelector.addGoal(5, new LookRandomlyGoal(this));
			this.goalSelector.addGoal(6, new TemptGoal(this, 0.6, Ingredient.fromItems(new ItemStack(Items.COD, (int) (1)).getItem()), false));
			this.goalSelector.addGoal(7, new TemptGoal(this, 0.6, Ingredient.fromItems(new ItemStack(Items.SALMON, (int) (1)).getItem()), false));
			this.targetSelector.addGoal(8, new NearestAttackableTargetGoal(this, CodEntity.class, true, false));
			this.targetSelector.addGoal(9, new NearestAttackableTargetGoal(this, SalmonEntity.class, true, false));
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source == DamageSource.DROWN)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3);
		}

		@Override
		public AgeableEntity createChild(AgeableEntity ageable) {
			CustomEntity retval = (CustomEntity) entity.create(this.world);
			retval.onInitialSpawn(this.world, this.world.getDifficultyForLocation(new BlockPos(retval)), SpawnReason.BREEDING,
					(ILivingEntityData) null, (CompoundNBT) null);
			return retval;
		}

		@Override
		public boolean isBreedingItem(ItemStack stack) {
			if (stack == null)
				return false;
			if (new ItemStack(Items.SALMON, (int) (1)).getItem() == stack.getItem())
				return true;
			if (new ItemStack(Items.COD, (int) (1)).getItem() == stack.getItem())
				return true;
			return false;
		}

		@Override
		public boolean canBreatheUnderwater() {
			return true;
		}

		@Override
		public boolean isNotColliding(IWorldReader worldreader) {
			return worldreader.checkNoEntityCollision(this, VoxelShapes.create(this.getBoundingBox()));
		}

		@Override
		public boolean isPushedByWater() {
			return false;
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
