
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class MagmaBallItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:magma_ball")
	public static final Item block = null;

	public MagmaBallItem(NewBordersModModElements instance) {
		super(instance, 598);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("magma_ball");
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
