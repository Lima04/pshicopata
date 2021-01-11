
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class RawSaltedMuttonItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:raw_salted_mutton")
	public static final Item block = null;

	public RawSaltedMuttonItem(NewBordersModModElements instance) {
		super(instance, 431);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(2.4f)

							.build()));
			setRegistryName("raw_salted_mutton");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
