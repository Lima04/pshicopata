
package net.mcreator.newbordersmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class GlowshroomBlockBlock extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:glowshroom_block")
	public static final Block block = null;
	public GlowshroomBlockBlock(NewBordersModModElements instance) {
		super(instance, 108);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(0.2f, 0.2f).setLightLevel(s -> 12)
					.harvestLevel(0).harvestTool(ToolType.AXE).setRequiresTool());
			setRegistryName("glowshroom_block");
		}
	}
}
