
package net.mcreator.newbordersmod.entity;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class PenguinEntity extends NewBordersModModElements.ModElement {

	public static EntityType entity = null;

	public PenguinEntity(NewBordersModModElements instance) {
		super(instance, 266);

		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.AMBIENT).setShouldReceiveVelocityUpdates(true)
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
			if (ForgeRegistries.BIOMES.getKey(biome).equals(new ResourceLocation("new_borders_mod:permafrost")))
				biomeCriteria = true;
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

			biome.getSpawns(EntityClassification.AMBIENT).add(new Biome.SpawnListEntry(entity, 9, 1, 4));
		}

		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS,
				Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MobEntity::canSpawnOn);

	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelcustom_model(), 0.3f) {

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

	}

	// Made with Blockbench 3.7.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports

	public static class Modelcustom_model extends EntityModel<Entity> {
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

		public Modelcustom_model() {
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
			Cabeca.setRotationPoint(0.0F, 22.0F, 0.0F);
			Cabeca.setTextureOffset(0, 21).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 6.0F, 9.0F, 0.0F, false);
			Cabeca.setTextureOffset(38, 29).addBox(-1.0F, -16.0F, -8.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

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
			this.NadadeiraTraseira.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.PataEsquerda.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.PataDireita.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
