
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class WastelandsBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:wastelands")
	public static final CustomBiome biome = null;

	public WastelandsBiome(NewBordersModModElements instance) {
		super(instance, 474);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 1));
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0f).temperature(0.9f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.DESERT).waterColor(4159204).waterFogColor(329011).parent("sunflower_plains")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.COARSE_DIRT.getDefaultState(),
							Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState())));

			setRegistryName("wastelands");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addOres(this);

		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -8621462;
		}

	}

}
