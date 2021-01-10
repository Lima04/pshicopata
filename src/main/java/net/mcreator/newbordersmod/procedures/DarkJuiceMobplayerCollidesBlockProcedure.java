package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class DarkJuiceMobplayerCollidesBlockProcedure extends NewBordersModModElements.ModElement {

	public DarkJuiceMobplayerCollidesBlockProcedure(NewBordersModModElements instance) {
		super(instance, 375);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure DarkJuiceMobplayerCollidesBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 1, (false), (false)));

	}

}
