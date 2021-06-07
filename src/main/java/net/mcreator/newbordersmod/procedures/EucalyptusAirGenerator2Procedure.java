package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.block.EucalyptusAir2Block;
import net.mcreator.newbordersmod.NewBordersModModElements;
import net.mcreator.newbordersmod.NewBordersModMod;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class EucalyptusAirGenerator2Procedure extends NewBordersModModElements.ModElement {
	public EucalyptusAirGenerator2Procedure(NewBordersModModElements instance) {
		super(instance, 434);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency x for procedure EucalyptusAirGenerator2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency y for procedure EucalyptusAirGenerator2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency z for procedure EucalyptusAirGenerator2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency world for procedure EucalyptusAirGenerator2!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double down = 0;
		down = (double) 0;
		while ((((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == EucalyptusAir2Block.block
						.getDefaultState().getBlock()))) {
			down = (double) ((down) + 1);
		}
		if (((!((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock()))
				&& (!((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == Blocks.LAVA.getDefaultState()
						.getBlock())))) {
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("new_borders_mod", "eucalyptus2"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) ((y - (down)) + 1), (int) (z - 2)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - (down)), (int) z))).getBlock() == EucalyptusAir2Block.block.getDefaultState()
				.getBlock())) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.AIR.getDefaultState(), 3);
		}
	}
}
