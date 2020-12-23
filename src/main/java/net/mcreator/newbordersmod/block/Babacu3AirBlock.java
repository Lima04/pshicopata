
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class Babacu3AirBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:babacu_3_air")
	public static final Block block = null;

	public Babacu3AirBlock(NewBordersModModElements instance) {
		super(instance, 304);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	public static class CustomBlock extends Block {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.AIR).sound(SoundType.GLASS).hardnessAndResistance(0f, 0f).lightValue(0).doesNotBlockMovement()
							.notSolid());

			setRegistryName("babacu_3_air");
		}

		@Override
		public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return false;
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 0));
		}

	}

}
