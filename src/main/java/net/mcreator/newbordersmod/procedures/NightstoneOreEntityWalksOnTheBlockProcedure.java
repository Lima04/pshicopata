package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class NightstoneOreEntityWalksOnTheBlockProcedure extends NewBordersModModElements.ModElement {

	public NightstoneOreEntityWalksOnTheBlockProcedure(NewBordersModModElements instance) {
		super(instance, 359);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure NightstoneOreEntityWalksOnTheBlock!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 1, (false), (false)));

	}

}
