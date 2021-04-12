
package net.mcreator.newbordersmod.fuel;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.item.ItemStack;

import net.mcreator.newbordersmod.item.ShaleOilBucketItem;
import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class ShaleOilFuel extends NewBordersModModElements.ModElement {
	public ShaleOilFuel(NewBordersModModElements instance) {
		super(instance, 721);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		if (event.getItemStack().getItem() == new ItemStack(ShaleOilBucketItem.block, (int) (1)).getItem())
			event.setBurnTime(8000);
	}
}
