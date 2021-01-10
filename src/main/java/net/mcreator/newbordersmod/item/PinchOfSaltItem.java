
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class PinchOfSaltItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:pinch_of_salt")
	public static final Item block = null;

	public PinchOfSaltItem(NewBordersModModElements instance) {
		super(instance, 381);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("pinch_of_salt");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

	}

}
