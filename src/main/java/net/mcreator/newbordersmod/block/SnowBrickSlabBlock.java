
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class SnowBrickSlabBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:snow_brick_slab")
	public static final Block block = null;

	public SnowBrickSlabBlock(NewBordersModModElements instance) {
		super(instance, 244);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends SlabBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.SNOW).hardnessAndResistance(0.2f, 0.2f).lightValue(0));

			setRegistryName("snow_brick_slab");
		}

	}

}
