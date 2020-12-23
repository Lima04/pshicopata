
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class CocaisJungleHillsBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cocais_jungle_hills")
	public static final CustomBiome biome = null;

	public CocaisJungleHillsBiome(NewBordersModModElements instance) {
		super(instance, 292);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 4));
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.8f).depth(1f).scale(0.2f).temperature(0.9f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.PLAINS).waterColor(4159204).waterFogColor(329011).parent("new_borders_mod:@registryname")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));

			setRegistryName("cocais_jungle_hills");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			DefaultBiomeFeatures.addJungleGrass(this);

			this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));

			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/savanna/town_centers", 6)));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D))
					.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		}

	}

}
