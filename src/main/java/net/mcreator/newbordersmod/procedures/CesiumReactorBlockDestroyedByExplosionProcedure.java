package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class CesiumReactorBlockDestroyedByExplosionProcedure extends NewBordersModModElements.ModElement {

	public CesiumReactorBlockDestroyedByExplosionProcedure(NewBordersModModElements instance) {
		super(instance, 415);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CesiumReactorBlockDestroyedByExplosion!");
			return;
		}

		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (!world.getWorld().isRemote) {
			ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(LeadBlockBlock.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 1);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}
		if (!world.getWorld().isRemote) {
			ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(NuclearWasteItem.block, (int) (1)));
			entityToSpawn.setPickupDelay((int) 1);
			entityToSpawn.setNoDespawn();
			world.addEntity(entityToSpawn);
		}

	}

}
