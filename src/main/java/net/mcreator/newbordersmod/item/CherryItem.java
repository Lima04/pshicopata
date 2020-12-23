
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CherryItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cherry")
	public static final Item block = null;

	public CherryItem(NewBordersModModElements instance) {
		super(instance, 268);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.4f)

							.build()));
			setRegistryName("cherry");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
