package com.theundertaker11.bettermagnets.init;

import com.theundertaker11.bettermagnets.items.AntiMagnet;
import com.theundertaker11.bettermagnets.items.ItemMagnet;
import com.theundertaker11.bettermagnets.util.IItemModelProvider;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ItemRegistry {

	public static Item MAGNET;
	public static Item antiMagnet;

	public static void init() {
		MAGNET = register(new ItemMagnet("magnet"));
		antiMagnet = register(new AntiMagnet("antimagnet"));
	}

	private static <T extends Item> T register(T item) {
		ForgeRegistries.ITEMS.register(item);

		if (item instanceof IItemModelProvider) {
			((IItemModelProvider) item).registerItemModel(item);
		}
		return item;
	}
}
