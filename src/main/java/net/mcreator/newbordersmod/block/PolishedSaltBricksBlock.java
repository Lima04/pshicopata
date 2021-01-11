
package net.mcreator.newbordersmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class PolishedSaltBricksBlock extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:polished_salt_bricks")
	public static final Block block = null;
	public PolishedSaltBricksBlock(NewBordersModModElements instance) {
		super(instance, 399);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(2f, 3f).lightValue(0));
			setRegistryName("polished_salt_bricks");
		}
	}
}