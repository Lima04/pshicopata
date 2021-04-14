package net.mcreator.newbordersmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class SunstoneOreEntityWalksOnTheBlockProcedure extends NewBordersModModElements.ModElement {
	public SunstoneOreEntityWalksOnTheBlockProcedure(NewBordersModModElements instance) {
		super(instance, 439);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SunstoneOreEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 3);
	}
}
