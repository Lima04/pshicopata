
package net.mcreator.newbordersmod.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.BreakBlockGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.newbordersmod.procedures.SentinelEntityDiesProcedure;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NewBordersModModElements.ModElement.Tag
public class CleanerSentinelEntity extends NewBordersModModElements.ModElement {
	public static EntityType entity = null;
	public CleanerSentinelEntity(NewBordersModModElements instance) {
		super(instance, 230);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.7f, 1f))
						.build("cleaner_sentinel").setRegistryName("cleaner_sentinel");
		elements.entities.add(() -> entity);
		elements.items.add(() -> new SpawnEggItem(entity, -13421773, -16777114, new Item.Properties().group(ItemGroup.MISC))
				.setRegistryName("cleaner_sentinel_spawn_egg"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelSentinel(), 0.2f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("new_borders_mod:textures/cleanersentinel.png");
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
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.targetSelector.addGoal(1, new HurtByTargetGoal(this).setCallsForHelp(this.getClass()));
			this.goalSelector.addGoal(2, new BreakBlockGoal(Blocks.GRASS.getDefaultState().getBlock(), this, 1, (int) 16));
			this.goalSelector.addGoal(3, new BreakBlockGoal(Blocks.TALL_GRASS.getDefaultState().getBlock(), this, 1, (int) 16));
			this.goalSelector.addGoal(4, new BreakBlockGoal(Blocks.OAK_LOG.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(5, new BreakBlockGoal(Blocks.COBBLESTONE.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(6, new BreakBlockGoal(Blocks.SMOOTH_STONE.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(7, new BreakBlockGoal(Blocks.OAK_PLANKS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(8, new BreakBlockGoal(Blocks.SPRUCE_PLANKS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(9, new BreakBlockGoal(Blocks.ACACIA_PLANKS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(10, new BreakBlockGoal(Blocks.JUNGLE_PLANKS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(11, new BreakBlockGoal(Blocks.DARK_OAK_PLANKS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(12, new BreakBlockGoal(Blocks.OAK_STAIRS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(13, new BreakBlockGoal(Blocks.SPRUCE_STAIRS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(14, new BreakBlockGoal(Blocks.BIRCH_STAIRS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(15, new BreakBlockGoal(Blocks.JUNGLE_STAIRS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(16, new BreakBlockGoal(Blocks.ACACIA_STAIRS.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(17, new BreakBlockGoal(Blocks.WHITE_CONCRETE.getDefaultState().getBlock(), this, 5, (int) 16));
			this.goalSelector.addGoal(18, new RandomWalkingGoal(this, 1, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.goalSelector.addGoal(19, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public double getMountedYOffset() {
			return super.getMountedYOffset() + 0.5;
		}

		@Override
		public net.minecraft.util.SoundEvent getAmbientSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("new_borders_mod:sentinel2"));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		public void onDeath(DamageSource source) {
			super.onDeath(source);
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity sourceentity = source.getTrueSource();
			Entity entity = this;
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				SentinelEntityDiesProcedure.executeProcedure($_dependencies);
			}
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
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
