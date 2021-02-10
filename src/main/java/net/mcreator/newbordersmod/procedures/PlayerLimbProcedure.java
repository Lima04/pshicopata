package net.mcreator.newbordersmod.procedures;

@NewBordersModModElements.ModElement.Tag
public class PlayerLimbProcedure extends NewBordersModModElements.ModElement {

	public PlayerLimbProcedure(NewBordersModModElements instance) {
		super(instance, 591);

		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PlayerLimb!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure PlayerLimb!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure PlayerLimb!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure PlayerLimb!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlayerLimb!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if (((((world.getCurrentMoonPhaseFactor()) == 8) == (true)) && ((entity.dimension.getId()) == (0)))) {
			if (!world.getWorld().isRemote && world.getWorld().getServer() != null) {
				world.getWorld().getServer().getCommandManager().handleCommand(
						new CommandSource(ICommandSource.DUMMY, new Vec3d(x, y, z), Vec2f.ZERO, (ServerWorld) world, 4, "",
								new StringTextComponent(""), world.getWorld().getServer(), null).withFeedbackDisabled(),
						"execute in new_borders_mod:Limb run tp @p ~ ~ ~");
			}
		}

	}

	@SubscribeEvent
	public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}

}
