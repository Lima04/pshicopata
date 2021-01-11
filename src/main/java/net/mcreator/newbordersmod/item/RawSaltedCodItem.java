
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class RawSaltedCodItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:raw_salted_cod")
	public static final Item block = null;

	public RawSaltedCodItem(NewBordersModModElements instance) {
		super(instance, 418);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.8f)

							.build()));
			setRegistryName("raw_salted_cod");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
