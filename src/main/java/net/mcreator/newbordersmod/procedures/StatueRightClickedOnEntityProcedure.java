package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newbordersmod.item.StatueItemItem;
import net.mcreator.newbordersmod.NewBordersModModElements;
import net.mcreator.newbordersmod.NewBordersModMod;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class StatueRightClickedOnEntityProcedure extends NewBordersModModElements.ModElement {
	public StatueRightClickedOnEntityProcedure(NewBordersModModElements instance) {
		super(instance, 351);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency entity for procedure StatueRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency x for procedure StatueRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency y for procedure StatueRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency z for procedure StatueRightClickedOnEntity!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency world for procedure StatueRightClickedOnEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (!entity.world.isRemote())
			entity.remove();
		if (world instanceof World && !world.isRemote()) {
			ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(StatueItemItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 0);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}
	}
}
