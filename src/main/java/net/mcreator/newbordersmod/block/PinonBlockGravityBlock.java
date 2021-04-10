
package net.mcreator.newbordersmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.newbordersmod.item.PinonNutItem;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.List;
import java.util.Collections;

@NewBordersModModElements.ModElement.Tag
public class PinonBlockGravityBlock extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:pinon_block_gravity")
	public static final Block block = null;
	public PinonBlockGravityBlock(NewBordersModModElements instance) {
		super(instance, 240);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(null)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends FallingBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(1f, 10f).lightValue(0).harvestLevel(1)
					.harvestTool(ToolType.AXE));
			setRegistryName("pinon_block_gravity");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(PinonNutItem.block, (int) (8)));
		}
	}
}
