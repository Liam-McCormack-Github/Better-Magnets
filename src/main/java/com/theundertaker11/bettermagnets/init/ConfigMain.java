package com.theundertaker11.bettermagnets.init;

import com.theundertaker11.bettermagnets.items.ItemMagnet;
import com.theundertaker11.bettermagnets.util.ModUtils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class ConfigMain {

	public static int tier1Range;
	public static int tier2Range;
	public static int tier3Range;
	public static int tier4Range;
	public static int tier5Range;
	
	public static void init(Configuration config)
	{
		config.load();
		final String R = "Range Config";
		config.addCustomCategoryComment(R, "Each number is in blocks, and should be an integer.");
		tier1Range = config.getInt("Tier 1 Radius", R, 2, 1, 6, "");
		tier2Range = config.getInt("Tier 2 Radius", R, 4, 1, 8, "");
		tier3Range = config.getInt("Tier 3 Radius", R, 6, 1, 10, "");
		tier4Range = config.getInt("Tier 4 Radius", R, 8, 1, 12, "");
		tier5Range = config.getInt("Ultimate Radius", R, 14, 1, 18, "");
		config.save();
	}
	
	public static double getRange(ItemStack stack)
	{
		if(!ModUtils.isStackEmpty(stack)&&stack.getItem() instanceof ItemMagnet)
		{
			switch(stack.getItemDamage()){
				case 0: return (double)tier1Range + 0.5;
				case 1: return (double)tier2Range + 0.5;
				case 2: return (double)tier3Range + 0.5;
				case 3: return (double)tier4Range + 0.5;
				case 4: return (double)tier5Range + 0.5;
			}
		}
		return 0;
	}
}
