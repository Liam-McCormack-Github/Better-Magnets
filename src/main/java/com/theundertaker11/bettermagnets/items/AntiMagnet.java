package com.theundertaker11.bettermagnets.items;

import com.theundertaker11.bettermagnets.BetterMagnetsMain;
import com.theundertaker11.bettermagnets.util.IItemModelProvider;

import net.minecraft.item.Item;

public class AntiMagnet extends Item implements IItemModelProvider{

	protected String name;

	public AntiMagnet(String name) {
		super();
		setRegistryName(name);
		this.name = name;
		setUnlocalizedName(name);
		setCreativeTab(BetterMagnetsMain.BMtab);
		setMaxStackSize(1);
	}
	
	@Override
	public void registerItemModel(Item item) {
		BetterMagnetsMain.proxy.registerItemRenderer(this, 0, name);
	}
}
