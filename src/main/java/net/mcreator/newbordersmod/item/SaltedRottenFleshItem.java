
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class SaltedRottenFleshItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:salted_rotten_flesh")
	public static final Item block = null;

	public SaltedRottenFleshItem(NewBordersModModElements instance) {
		super(instance, 435);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}

	public static class FoodItemCustom extends Item {

		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(1.6f)

							.build()));
			setRegistryName("salted_rotten_flesh");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);

			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();

				$_dependencies.put("entity", entity);

				SaltedRottenFleshFoodEatenProcedure.executeProcedure($_dependencies);
			}

			return retval;
		}

	}

}
