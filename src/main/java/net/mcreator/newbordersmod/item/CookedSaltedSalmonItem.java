
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CookedSaltedSalmonItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cooked_salted_salmon")
	public static final Item block = null;

	public CookedSaltedSalmonItem(NewBordersModModElements instance) {
		super(instance, 424);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(19.200000000000003f)

							.build()));
			setRegistryName("cooked_salted_salmon");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
