package net.mcreator.newbordersmod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.newbordersmod.block.StrippedRedwoodLogBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.function.Supplier;
import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class TimbermanExchangeProcedure extends NewBordersModModElements.ModElement {
	public TimbermanExchangeProcedure(NewBordersModModElements instance) {
		super(instance, 45);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure TimbermanExchange!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			public int getAmount(int sltid) {
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
							if (stack != null)
								return stack.getCount();
						}
					}
				}
				return 0;
			}
		}.getAmount((int) (0))) == 10)) {
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(Blocks.JUNGLE_LOG, (int) (1));
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 10);
			}
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = new ItemStack(StrippedRedwoodLogBlock.block, (int) (1));
						_setstack.setCount((int) 10);
						((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
