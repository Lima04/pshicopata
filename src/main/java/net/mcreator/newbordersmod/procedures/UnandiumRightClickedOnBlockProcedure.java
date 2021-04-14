package net.mcreator.newbordersmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newbordersmod.item.UnandiumItem;
import net.mcreator.newbordersmod.item.NuclearWasteItem;
import net.mcreator.newbordersmod.item.CompactCobaltItem;
import net.mcreator.newbordersmod.block.WasteWaterBlock;
import net.mcreator.newbordersmod.NewBordersModModElements;

import java.util.Map;

@NewBordersModModElements.ModElement.Tag
public class UnandiumRightClickedOnBlockProcedure extends NewBordersModModElements.ModElement {
	public UnandiumRightClickedOnBlockProcedure(NewBordersModModElements instance) {
		super(instance, 318);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure UnandiumRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure UnandiumRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure UnandiumRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure UnandiumRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure UnandiumRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((Math.random() < 0.75)) {
			sx = (double) (-3);
			found = (boolean) (false);
			for (int index0 = 0; index0 < (int) (6); index0++) {
				sy = (double) (-1);
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sz = (double) (-1);
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == WasteWaterBlock.block.getDefaultState().getBlock())) {
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (true))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(UnandiumItem.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(NuclearWasteItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
		if ((Math.random() < 0.25)) {
			sx = (double) (-1);
			found = (boolean) (false);
			for (int index3 = 0; index3 < (int) (6); index3++) {
				sy = (double) (-1);
				for (int index4 = 0; index4 < (int) (6); index4++) {
					sz = (double) (-1);
					for (int index5 = 0; index5 < (int) (6); index5++) {
						if (((world.getBlockState(new BlockPos((int) (x + (sx)), (int) (y + (sy)), (int) (z + (sz)))))
								.getBlock() == WasteWaterBlock.block.getDefaultState().getBlock())) {
							found = (boolean) (true);
						}
						sz = (double) ((sz) + 1);
					}
					sy = (double) ((sy) + 1);
				}
				sx = (double) ((sx) + 1);
			}
			if (((found) == (true))) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(UnandiumItem.block, (int) (1));
					((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(CompactCobaltItem.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
