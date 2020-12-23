
package net.mcreator.newbordersmod.block;

import net.minecraft.block.material.Material;

@NewBordersModModElements.ModElement.Tag
public class WhiteCherryBlossomsBlock extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:white_cherry_blossoms")
	public static final Block block = null;

	public WhiteCherryBlossomsBlock(NewBordersModModElements instance) {
		super(instance, 267);

	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	public static class CustomBlock extends LeavesBlock {

		public CustomBlock() {
			super(

					Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).lightValue(0).notSolid());

			setRegistryName("white_cherry_blossoms");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 30;
		}

		@Override
		public MaterialColor getMaterialColor(BlockState state, IBlockReader blockAccess, BlockPos pos) {
			return MaterialColor.SNOW;
		}

		@Override
		public PushReaction getPushReaction(BlockState state) {
			return PushReaction.DESTROY;
		}

	}

}
