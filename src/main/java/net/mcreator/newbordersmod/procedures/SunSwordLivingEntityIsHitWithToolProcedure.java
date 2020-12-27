package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class SunSwordLivingEntityIsHitWithToolProcedure extends NewBordersModModElements.ModElement {

	public SunSwordLivingEntityIsHitWithToolProcedure(NewBordersModModElements instance) {
		super(instance, 364);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SunSwordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure SunSwordLivingEntityIsHitWithTool!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");

		if ((world.getWorld().isDaytime())) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 60, (int) 1, (false), (false)));
		}

	}

}
