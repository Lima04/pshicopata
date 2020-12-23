
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class BabacuPulpItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:babacu_pulp")
	public static final Item block = null;

	public BabacuPulpItem(NewBordersModModElements instance) {
		super(instance, 284);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(6).saturation(1f)

							.build()));
			setRegistryName("babacu_pulp");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

	}

}
