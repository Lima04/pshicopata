
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class DuskstoneGemItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:duskstone_gem")
	public static final Item block = null;

	public DuskstoneGemItem(NewBordersModModElements instance) {
		super(instance, 374);

	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {

		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64).rarity(Rarity.UNCOMMON));
			setRegistryName("duskstone_gem");
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
