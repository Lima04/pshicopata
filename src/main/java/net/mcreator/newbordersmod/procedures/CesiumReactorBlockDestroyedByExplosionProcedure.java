package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;

import net.mcreator.newbordersmod.item.NuclearWasteItem;
import net.mcreator.newbordersmod.block.LeadBlockBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;
import net.mcreator.newbordersmod.NewBordersModMod;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class CesiumReactorBlockDestroyedByExplosionProcedure extends NewBordersModModElements.ModElement {
	public CesiumReactorBlockDestroyedByExplosionProcedure(NewBordersModModElements instance) {
		super(instance, 486);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency x for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency y for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency z for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency world for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(LeadBlockBlock.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 1);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(NuclearWasteItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 1);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}
	}
}
