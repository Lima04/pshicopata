
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CookedSaltedCodItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cooked_salted_cod")
	public static final Item block = null;

	public CookedSaltedCodItem(NewBordersModModElements instance) {
		super(instance, 420);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(12f)

							.build()));
			setRegistryName("cooked_salted_cod");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
