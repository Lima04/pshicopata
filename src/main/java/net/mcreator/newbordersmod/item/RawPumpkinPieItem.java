
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class RawPumpkinPieItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:raw_pumpkin_pie")
	public static final Item block = null;

	public RawPumpkinPieItem(NewBordersModModElements instance) {
		super(instance, 679);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("raw_pumpkin_pie");
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
