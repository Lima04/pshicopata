package net.mcreator.newbordersmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class SulfurOreEntityWalksOnTheBlockProcedure extends NewBordersModModElements.ModElement {
	public SulfurOreEntityWalksOnTheBlockProcedure(NewBordersModModElements instance) {
		super(instance, 610);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure SulfurOreEntityWalksOnTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 100, (int) 0, (true), (true)));
	}
}