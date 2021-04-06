
package net.mcreator.newbordersmod.painting;

@NewBordersModModElements.ModElement.Tag
public class FifodaPainting extends NewBordersModModElements.ModElement {

	public FifodaPainting(NewBordersModModElements instance) {
		super(instance, 603);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@SubscribeEvent
	public void registerPaintingType(RegistryEvent.Register<PaintingType> event) {
		event.getRegistry().register(new PaintingType(16, 32).setRegistryName("fifoda"));
	}

}
