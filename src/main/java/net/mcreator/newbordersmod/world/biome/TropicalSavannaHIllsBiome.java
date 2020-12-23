
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class TropicalSavannaHIllsBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:tropical_savanna_hills")
	public static final CustomBiome biome = null;

	public TropicalSavannaHIllsBiome(NewBordersModModElements instance) {
		super(instance, 268);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 5));
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.6f).scale(1f).temperature(1f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.EXTREME_HILLS).waterColor(4159204).waterFogColor(329011).parent("new_borders_mod:tropical_savanna")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState(), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState())));

			setRegistryName("tropical_savanna_hills");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);

			this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));

			this.addStructure(Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/savanna/town_centers", 6)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(6))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					Feature.RANDOM_SELECTOR
							.withConfiguration(new MultipleRandomFeatureConfig(
									ImmutableList.of(Feature.ACACIA_TREE.withConfiguration(DefaultBiomeFeatures.ACACIA_TREE_CONFIG).withChance(0.8F)),
									Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)))
							.withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.CACTUS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));

			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2,
									Lists.newArrayList(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(9))));

		}

	}

}
