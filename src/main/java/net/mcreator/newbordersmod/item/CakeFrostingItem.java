
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CakeFrostingItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cake_frosting")
	public static final Item block = null;

	public CakeFrostingItem(NewBordersModModElements instance) {
		super(instance, 689);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("cake_frosting");
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
