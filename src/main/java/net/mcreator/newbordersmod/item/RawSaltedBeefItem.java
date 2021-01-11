
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class RawSaltedBeefItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:raw_salted_beef")
	public static final Item block = null;

	public RawSaltedBeefItem(NewBordersModModElements instance) {
		super(instance, 427);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(3).saturation(3.6f)

							.build()));
			setRegistryName("raw_salted_beef");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
