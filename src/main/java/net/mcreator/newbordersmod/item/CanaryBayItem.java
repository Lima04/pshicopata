
package net.mcreator.newbordersmod.item;

@NewBordersModModElements.ModElement.Tag
public class CanaryBayItem extends NewBordersModModElements.ModElement {

	@ObjectHolder("new_borders_mod:canary_bay")
	public static final Item block = null;

	public CanaryBayItem(NewBordersModModElements instance) {
		super(instance, 678);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, NewBordersModModElements.sounds.get(new ResourceLocation("new_borders_mod:canary_bay")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("canary_bay");
		}

	}

}
