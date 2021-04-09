
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CobaltHoeItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cobalt_hoe")
	public static final Item block = null;

	public CobaltHoeItem(NewBordersModModElements instance) {
		super(instance, 688);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 2561;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 5;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(CobaltShardItem.block, (int) (1)));
			}
		}, -3f, new Item.Properties().group(ItemGroup.TOOLS)) {

		}.setRegistryName("cobalt_hoe"));
	}

}
