
package net.mcreator.newbordersmod.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeManager;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.structure.ShipwreckConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class BrownRiverBiome extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:brown_river")
	public static final CustomBiome biome = null;
	public BrownRiverBiome(NewBordersModModElements instance) {
		super(instance, 420);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, 6));
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.8f).depth(-0.7000000000000001f).scale(0f).temperature(0.6f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.RIVER).waterColor(-9087744).waterFogColor(-2647040).parent("jungle")
					.surfaceBuilder(SurfaceBuilder.DEFAULT,
							new SurfaceBuilderConfig(Blocks.WATER.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("brown_river");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addOceanCarvers(this);
			DefaultBiomeFeatures.addSwampClayDisks(this);
			DefaultBiomeFeatures.addTallSeagrassLush(this);
			this.addStructure(Feature.SHIPWRECK.withConfiguration(new ShipwreckConfig(false)));
			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(27, 0.3D))
					.withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
			this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.COD, 60, 1, 4));
			this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.SALMON, 80, 1, 4));
		}
	}
}
