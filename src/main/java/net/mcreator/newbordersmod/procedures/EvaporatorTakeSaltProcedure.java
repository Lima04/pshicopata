package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class EvaporatorTakeSaltProcedure extends NewBordersModModElements.ModElement {

	public EvaporatorTakeSaltProcedure(NewBordersModModElements instance) {
		super(instance, 456);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure EvaporatorTakeSalt!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).giveExperiencePoints((int) 5);

	}

}
