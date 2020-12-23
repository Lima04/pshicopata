
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class BabacuPlanksBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:babacu_planks")
	public static final Block block = null;

	public BabacuPlanksBlock(NewBordersModModElements instance) {
		super(instance, 314);

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

					Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2f, 3f).lightValue(0).harvestLevel(0)
							.harvestTool(ToolType.AXE));

			setRegistryName("babacu_planks");
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
