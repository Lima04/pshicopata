
package net.mcreator.newbordersmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.newbordersmod.NewBordersModModElements;

@NewBordersModModElements.ModElement.Tag
public class ThePoopifersTheFirstShit2003Item extends NewBordersModModElements.ModElement {
	@ObjectHolder("new_borders_mod:the_poopifers_the_first_shit_2003")
	public static final Item block = null;
	public ThePoopifersTheFirstShit2003Item(NewBordersModModElements instance) {
		super(instance, 160);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, NewBordersModModElements.sounds.get(new ResourceLocation("new_borders_mod:pifer")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("the_poopifers_the_first_shit_2003");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}
	}
}
