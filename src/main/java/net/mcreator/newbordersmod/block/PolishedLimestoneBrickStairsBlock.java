
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class PolishedLimestoneBrickStairsBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:polished_limestone_brick_stairs")
	public static final Block block = null;

	public PolishedLimestoneBrickStairsBlock(NewBordersModModElements instance) {
		super(instance, 485);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends StairsBlock {

		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.25f, 3f)).getDefaultState(),

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.25f, 3f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("polished_limestone_brick_stairs");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

	}

}
