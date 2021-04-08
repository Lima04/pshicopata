/*
 *    MCreator note:
 *
 *    This file is autogenerated to connect all MCreator mod elements together.
 *
 */
package net.mcreator.newbordersmod;

import net.minecraftforge.forgespi.language.ModFileScanData;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.biome.Biome;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.Item;
import net.minecraft.entity.EntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.block.Block;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

public class NewBordersModModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<Biome>> biomes = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public final List<Supplier<Enchantment>> enchantments = new ArrayList<>();
	public static Map<ResourceLocation, net.minecraft.util.SoundEvent> sounds = new HashMap<>();
	public NewBordersModModElements() {
		sounds.put(new ResourceLocation("new_borders_mod", "estrelar"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "estrelar")));
		sounds.put(new ResourceLocation("new_borders_mod", "estrelarmv"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "estrelarmv")));
		sounds.put(new ResourceLocation("new_borders_mod", "estrela"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "estrela")));
		sounds.put(new ResourceLocation("new_borders_mod", "estrelarmv2"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "estrelarmv2")));
		sounds.put(new ResourceLocation("new_borders_mod", "fogodosol"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "fogodosol")));
		sounds.put(new ResourceLocation("new_borders_mod", "sambadeverao"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "sambadeverao")));
		sounds.put(new ResourceLocation("new_borders_mod", "paraosfilhosdeabraao"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "paraosfilhosdeabraao")));
		sounds.put(new ResourceLocation("new_borders_mod", "naturalmente"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "naturalmente")));
		sounds.put(new ResourceLocation("new_borders_mod", "tapanoreal"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "tapanoreal")));
		sounds.put(new ResourceLocation("new_borders_mod", "tapetesguardanaposcetins"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "tapetesguardanaposcetins")));
		sounds.put(new ResourceLocation("new_borders_mod", "diad"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "diad")));
		sounds.put(new ResourceLocation("new_borders_mod", "maisqueamor"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "maisqueamor")));
		sounds.put(new ResourceLocation("new_borders_mod", "violaenluarada"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "violaenluarada")));
		sounds.put(new ResourceLocation("new_borders_mod", "pifer"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "pifer")));
		sounds.put(new ResourceLocation("new_borders_mod", "aah"), new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "aah")));
		sounds.put(new ResourceLocation("new_borders_mod", "sentinel1"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "sentinel1")));
		sounds.put(new ResourceLocation("new_borders_mod", "sentinel2"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "sentinel2")));
		sounds.put(new ResourceLocation("new_borders_mod", "seagull_living"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "seagull_living")));
		sounds.put(new ResourceLocation("new_borders_mod", "seagull_hurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "seagull_hurt")));
		sounds.put(new ResourceLocation("new_borders_mod", "mosquito"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "mosquito")));
		sounds.put(new ResourceLocation("new_borders_mod", "keyboard1"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "keyboard1")));
		sounds.put(new ResourceLocation("new_borders_mod", "keyboard2"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "keyboard2")));
		sounds.put(new ResourceLocation("new_borders_mod", "frostbittenambient"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "frostbittenambient")));
		sounds.put(new ResourceLocation("new_borders_mod", "frostbittenhurt"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "frostbittenhurt")));
		sounds.put(new ResourceLocation("new_borders_mod", "frostbittensteps"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "frostbittensteps")));
		sounds.put(new ResourceLocation("new_borders_mod", "frostbittendeath"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "frostbittendeath")));
		sounds.put(new ResourceLocation("new_borders_mod", "freezesay"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "freezesay")));
		sounds.put(new ResourceLocation("new_borders_mod", "normal_canon"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "normal_canon")));
		sounds.put(new ResourceLocation("new_borders_mod", "heat_canon"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "heat_canon")));
		sounds.put(new ResourceLocation("new_borders_mod", "canary_bay"),
				new net.minecraft.util.SoundEvent(new ResourceLocation("new_borders_mod", "canary_bay")));
		try {
			ModFileScanData modFileInfo = ModList.get().getModFileById("new_borders_mod").getFile().getScanResult();
			Set<ModFileScanData.AnnotationData> annotations = modFileInfo.getAnnotations();
			for (ModFileScanData.AnnotationData annotationData : annotations) {
				if (annotationData.getAnnotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(annotationData.getClassType().getClassName());
					if (clazz.getSuperclass() == NewBordersModModElements.ModElement.class)
						elements.add((NewBordersModModElements.ModElement) clazz.getConstructor(this.getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(elements);
		elements.forEach(NewBordersModModElements.ModElement::initElements);
	}

	public void registerSounds(RegistryEvent.Register<net.minecraft.util.SoundEvent> event) {
		for (Map.Entry<ResourceLocation, net.minecraft.util.SoundEvent> sound : sounds.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
	private int messageID = 0;
	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, PacketBuffer> encoder, Function<PacketBuffer, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		NewBordersModMod.PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public List<Supplier<Block>> getBlocks() {
		return blocks;
	}

	public List<Supplier<Item>> getItems() {
		return items;
	}

	public List<Supplier<Biome>> getBiomes() {
		return biomes;
	}

	public List<Supplier<EntityType<?>>> getEntities() {
		return entities;
	}

	public List<Supplier<Enchantment>> getEnchantments() {
		return enchantments;
	}
	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}
		protected final NewBordersModModElements elements;
		protected final int sortid;
		public ModElement(NewBordersModModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(FMLServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
