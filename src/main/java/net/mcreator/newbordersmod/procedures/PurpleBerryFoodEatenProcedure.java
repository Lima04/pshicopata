package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class PurpleBerryFoodEatenProcedure extends NewBordersModModElements.ModElement {

	public PurpleBerryFoodEatenProcedure(NewBordersModModElements instance) {
		super(instance, 245);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PurpleBerryFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((Math.random() < 0.41)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 600, (int) 1, (false), (true)));
		}

	}

}
