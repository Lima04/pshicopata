
package net.mcreator.newbordersmod.block;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class SnowBrickStairsBlock extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:snow_brick_stairs")
	public static final Block block = null;
	public SnowBrickStairsBlock(NewBordersModModElements instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends StairsBlock {
		public CustomBlock() {
			super(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.2f, 0.2f)).getDefaultState(),
					Block.Properties.create(Material.PACKED_ICE).sound(SoundType.SNOW).hardnessAndResistance(0.2f, 0.2f).lightValue(0));
			setRegistryName("snow_brick_stairs");
		}
	}
}
