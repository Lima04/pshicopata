
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class PolishedLimestoneBrickSlabBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:polished_limestone_brick_slab")
	public static final Block block = null;

	public PolishedLimestoneBrickSlabBlock(NewBordersModModElements instance) {
		super(instance, 484);

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

					Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(1.25f, 3f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.PICKAXE));

			setRegistryName("polished_limestone_brick_slab");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, state.get(TYPE) == SlabType.DOUBLE ? 2 : 1));
		}

	}

}
