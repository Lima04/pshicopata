
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CoarseSaltItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:coarse_salt")
	public static final Item block = null;

	public CoarseSaltItem(NewBordersModModElements instance) {
		super(instance, 415);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("coarse_salt");
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
