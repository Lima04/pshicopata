
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class RawSaltedSalmonItem extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:raw_salted_salmon")
	public static final Item block = null;
	public RawSaltedSalmonItem(NewBordersModModElements instance) {
		super(instance, 124);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.4f).build()));
			setRegistryName("raw_salted_salmon");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}
	}
}
