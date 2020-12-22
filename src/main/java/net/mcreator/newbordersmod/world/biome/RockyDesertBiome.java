
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class RockyDesertBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:rocky_desert")
	public static final CustomBiome biome = null;

	public RockyDesertBiome(NewBordersModModElements instance) {
		super(instance, 242);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 7));
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0.1f).depth(0.1f).scale(1f).temperature(0.7999999999999999f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.EXTREME_HILLS).waterColor(4159204).waterFogColor(329011).parent("desert")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.SMOOTH_SANDSTONE.getDefaultState(),
							Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState())));

			setRegistryName("rocky_desert");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(20, 0.3D))
					.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2,
									Lists.newArrayList(Blocks.SMOOTH_SANDSTONE.getDefaultState(), Blocks.SMOOTH_SANDSTONE.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(11))));

		}

	}

}
