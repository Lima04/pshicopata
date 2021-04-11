package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class CobaltBombRedstoneOnProcedure extends NewBordersModModElements.ModElement {
	public CobaltBombRedstoneOnProcedure(NewBordersModModElements instance) {
		super(instance, 285);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CobaltBombRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CobaltBombRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CobaltBombRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CobaltBombRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		if (((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))
				&& (((((world.getBlockState(new BlockPos((int) (x + 25), (int) y, (int) z))).getBlock() == Blocks.SAND.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) (x - 25), (int) y, (int) z))).getBlock() == Blocks.SAND.getDefaultState()
								.getBlock()))
						|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 25)))).getBlock() == Blocks.SAND.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 25)))).getBlock() == Blocks.SAND.getDefaultState()
										.getBlock())))
						|| (((((world.getBlockState(new BlockPos((int) (x + 25), (int) (y + 25), (int) z))).getBlock() == Blocks.SAND
								.getDefaultState().getBlock())
								|| ((world.getBlockState(new BlockPos((int) (x - 25), (int) (y + 25), (int) z))).getBlock() == Blocks.SAND
										.getDefaultState().getBlock()))
								|| (((world.getBlockState(new BlockPos((int) (x + 25), (int) (y - 25), (int) z))).getBlock() == Blocks.SAND
										.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) (x - 25), (int) (y - 25), (int) z))).getBlock() == Blocks.SAND
												.getDefaultState().getBlock())))
								|| ((((world.getBlockState(new BlockPos((int) x, (int) (y + 25), (int) (z + 25)))).getBlock() == Blocks.SAND
										.getDefaultState().getBlock())
										|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 25), (int) (z - 25)))).getBlock() == Blocks.SAND
												.getDefaultState().getBlock()))
										|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 25), (int) (z + 25)))).getBlock() == Blocks.SAND
												.getDefaultState().getBlock())
												|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 25), (int) (z - 25))))
														.getBlock() == Blocks.SAND.getDefaultState().getBlock()))))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.GLASS.getDefaultState(), 3);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) y, (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + 1), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + (-1)), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + 2), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + (-2)), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + 3), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().createExplosion(null, (int) x, (int) (y + (-3)), (int) z, (float) 200, Explosion.Mode.BREAK);
		}
	}
}
