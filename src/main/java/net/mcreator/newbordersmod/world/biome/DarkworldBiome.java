
package net.mcreator.newbordersmod.world.biome;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class DarkworldBiome extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:darkworld")
	public static final CustomBiome biome = null;

	public DarkworldBiome(NewBordersModModElements instance) {
		super(instance, 590);
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
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(AsphaltBlockBlock.block.getDefaultState(),
							Blocks.OBSIDIAN.getDefaultState(), Blocks.OBSIDIAN.getDefaultState())));

			setRegistryName("darkworld");

			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);

		}

	}

}
