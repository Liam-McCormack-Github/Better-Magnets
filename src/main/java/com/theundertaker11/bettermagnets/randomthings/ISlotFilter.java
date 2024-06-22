package com.theundertaker11.bettermagnets.randomthings;

import net.minecraft.item.ItemStack;

public interface ISlotFilter
{
	public boolean isItemStackValid(ItemStack is);
}
