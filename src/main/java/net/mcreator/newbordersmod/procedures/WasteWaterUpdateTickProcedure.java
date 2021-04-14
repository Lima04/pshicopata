package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.newbordersmod.block.WasteWaterBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class WasteWaterUpdateTickProcedure extends NewBordersModModElements.ModElement {
	public WasteWaterUpdateTickProcedure(NewBordersModModElements instance) {
		super(instance, 498);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure WasteWaterUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure WasteWaterUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure WasteWaterUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure WasteWaterUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) (z + 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) (z - 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) y, (int) (z + 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) y, (int) (z - 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.WATER.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x + 1), (int) (y + 1), (int) (z + 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
		if (((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.WATER.getDefaultState()
				.getBlock())) {
			{
				BlockPos _bp = new BlockPos((int) (x - 1), (int) (y - 1), (int) (z - 1));
				BlockState _bs = WasteWaterBlock.block.getDefaultState();
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
