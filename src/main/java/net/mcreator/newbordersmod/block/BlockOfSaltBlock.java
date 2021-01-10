
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class BlockOfSaltBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:block_of_salt")
	public static final Block block = null;

	public BlockOfSaltBlock(NewBordersModModElements instance) {
		super(instance, 379);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.9999999999999998f, 3f).lightValue(0)
							.harvestLevel(1).harvestTool(ToolType.PICKAXE));

			setRegistryName("block_of_salt");
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.LIGHT_GRAY;
		}

	}

}
