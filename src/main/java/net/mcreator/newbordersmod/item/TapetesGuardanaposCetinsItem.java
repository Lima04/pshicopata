
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class TapetesGuardanaposCetinsItem extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:tapetes_guardanapos_cetins")
	public static final Item block = null;
	public TapetesGuardanaposCetinsItem(NewBordersModModElements instance) {
		super(instance, 160);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NewBordersModModElements.sounds.get(new ResourceLocation("new_borders_mod:tapetesguardanaposcetins")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("tapetes_guardanapos_cetins");
		}
	}
}
