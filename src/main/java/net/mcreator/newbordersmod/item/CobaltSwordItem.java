
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CobaltSwordItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:cobalt_sword")
	public static final Item block = null;

	public CobaltSwordItem(NewBordersModModElements instance) {
		super(instance, 683);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2561;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 5f;
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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT)) {

		}.setRegistryName("cobalt_sword"));
	}

}
