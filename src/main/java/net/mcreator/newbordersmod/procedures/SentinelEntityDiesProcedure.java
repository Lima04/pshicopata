package net.mcreator.newbordersmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.item.LeadIngotItem;
import net.mcreator.newbordersmod.block.Cobalt59BolckBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class SentinelEntityDiesProcedure extends NewBordersModModElements.ModElement {
	public SentinelEntityDiesProcedure(NewBordersModModElements instance) {
		super(instance, 212);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure SentinelEntityDies!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure SentinelEntityDies!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure SentinelEntityDies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SentinelEntityDies!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.00005)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Cobalt59BolckBlock.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
		if ((Math.random() < 0.2)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.IRON_BLOCK, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
		if ((Math.random() < 0.2)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Items.IRON_INGOT, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
		if ((Math.random() < 0.2)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(LeadIngotItem.block, (int) (1)));
				entityToSpawn.setPickupDelay((int) 0);
				entityToSpawn.setNoDespawn();
				world.addEntity(entityToSpawn);
			}
		}
	}
}
