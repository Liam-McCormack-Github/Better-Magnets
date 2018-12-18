package com.theundertaker11.bettermagnets;

import com.theundertaker11.bettermagnets.init.ItemRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BMCreativeTab extends CreativeTabs{

	public BMCreativeTab(int p1, String name)
    {
        super(p1, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemRegistry.MAGNET);
    }
}
