
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class PrismarineCutlassItem extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:prismarine_cutlass")
	public static final Item block = null;
	public PrismarineCutlassItem(NewBordersModModElements instance) {
		super(instance, 203);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 170;
			}

			public float getEfficiency() {
				return 2f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Items.PRISMARINE_SHARD, (int) (1)), new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1)));
			}
		}, 3, -2.2000000000000002f, new Item.Properties().group(ItemGroup.COMBAT)) {
		}.setRegistryName("prismarine_cutlass"));
	}
}
