
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class ParaOsFilhosDeAbraaoItem extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:para_os_filhos_de_abraao")
	public static final Item block = null;
	public ParaOsFilhosDeAbraaoItem(NewBordersModModElements instance) {
		super(instance, 71);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NewBordersModModElements.sounds.get(new ResourceLocation("new_borders_mod:paraosfilhosdeabraao")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("para_os_filhos_de_abraao");
		}
	}
}
