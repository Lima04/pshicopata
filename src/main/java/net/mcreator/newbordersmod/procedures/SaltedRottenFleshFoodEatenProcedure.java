package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class SaltedRottenFleshFoodEatenProcedure extends NewBordersModModElements.ModElement {

	public SaltedRottenFleshFoodEatenProcedure(NewBordersModModElements instance) {
		super(instance, 436);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SaltedRottenFleshFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if ((Math.random() < 0.3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 300, (int) 0, (true), (true)));
		}

	}

}
