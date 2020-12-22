
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class SnowBricksBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:snow_bricks")
	public static final Block block = null;

	public SnowBricksBlock(NewBordersModModElements instance) {
		super(instance, 242);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.SNOW).hardnessAndResistance(0.2f, 0.2f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.SHOVEL));

			setRegistryName("snow_bricks");
		}

	}

}
