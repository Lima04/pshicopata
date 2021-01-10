
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class DarkPlainsBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:dark_plains")
	public static final CustomBiome biome = null;

	public DarkPlainsBiome(NewBordersModModElements instance) {
		super(instance, 374);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	static class CustomBiome extends Biome {

		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(-1f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NETHER).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(AsphaltBlockBlock.block.getDefaultState(),
							AsphaltBlockBlock.block.getDefaultState(), AsphaltBlockBlock.block.getDefaultState())));

			setRegistryName("dark_plains");

		}

	}

}
