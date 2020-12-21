package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.block.BigCandyAirBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class BigCandySpawnProcedure extends NewBordersModModElements.ModElement {
	public BigCandySpawnProcedure(NewBordersModModElements instance) {
		super(instance, 191);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure BigCandySpawn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure BigCandySpawn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure BigCandySpawn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure BigCandySpawn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double down = 0;
		down = (double) 0;
		while ((((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == BigCandyAirBlock.block.getDefaultState()
						.getBlock()))) {
			down = (double) ((down) + 1);
		}
		if (((!((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock()))
				&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.LAVA.getDefaultState()
						.getBlock())))) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("new_borders_mod", "big_candy_tree"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) (x - 4), (int) ((y - (down)) + 1), (int) (z - 4)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == BigCandyAirBlock.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
