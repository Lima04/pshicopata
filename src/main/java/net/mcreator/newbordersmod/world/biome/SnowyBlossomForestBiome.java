
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class SnowyBlossomForestBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:snowy_blossom_forest")
	public static final CustomBiome biome = null;

	public SnowyBlossomForestBiome(NewBordersModModElements instance) {
		super(instance, 333);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 10));
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.5f).scale(0.1f).temperature(0.1f).precipitation(Biome.RainType.SNOW)
					.category(Biome.Category.FOREST).waterColor(4159204).waterFogColor(329011).parent("snowy_taiga")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));

			setRegistryName("snowy_blossom_forest");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);

			this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));

			this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/snowy/town_centers", 6)));

			this.addStructure(Feature.IGLOO.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(4))));

			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(4))));

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D))
					.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		}

	}

}
