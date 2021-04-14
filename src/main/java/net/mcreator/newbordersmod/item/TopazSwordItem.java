
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class TopazSwordItem extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:topaz_sword")
	public static final Item block = null;
	public TopazSwordItem(NewBordersModModElements instance) {
		super(instance, 732);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1561;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(RubyCrystalItem.block, (int) (1)));
			}
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("topaz_sword"));
	}
}
