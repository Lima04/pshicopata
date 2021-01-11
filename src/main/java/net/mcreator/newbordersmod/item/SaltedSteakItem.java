
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class SaltedSteakItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:salted_steak")
	public static final Item block = null;

	public SaltedSteakItem(NewBordersModModElements instance) {
		super(instance, 429);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(8).saturation(25.6f)

							.build()));
			setRegistryName("salted_steak");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
