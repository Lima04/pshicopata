package net.mcreator.newbordersmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newbordersmod.NewBordersModModElements;
import net.mcreator.newbordersmod.NewBordersModMod;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class TwinCherriesFoodEatenProcedure extends NewBordersModModElements.ModElement {
	public TwinCherriesFoodEatenProcedure(NewBordersModModElements instance) {
		super(instance, 374);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewBordersModMod.LOGGER.warn("Failed to load dependency entity for procedure TwinCherriesFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 100, (int) 0, (false), (true)));
	}
}
