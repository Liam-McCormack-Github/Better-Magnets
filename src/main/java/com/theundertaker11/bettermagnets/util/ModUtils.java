package com.theundertaker11.bettermagnets.util;

import java.util.List;

import com.theundertaker11.bettermagnets.Reference;
import com.theundertaker11.bettermagnets.items.ItemMagnet;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ModUtils {

	public static boolean isStackEmpty(ItemStack stack)
	{
		if(stack==null)
			return true;
		else 
			return false;
	}
	
	public static void toggleMagnet(ItemStack stack)
	{
		if(!isStackEmpty(stack)&&stack.getItem() instanceof ItemMagnet)
		{
			getTag(stack).setBoolean(Reference.KEY, !getTag(stack).getBoolean(Reference.KEY));
		}
	}
	
	public static void disableMagnet(ItemStack stack)
	{
		if(!isStackEmpty(stack)&&stack.getItem() instanceof ItemMagnet)
		{
			getTag(stack).setBoolean(Reference.KEY, false);
		}
	}
	public static boolean isMagnetActive(ItemStack stack)
	{
		return getTag(stack).getBoolean(Reference.KEY);
	}
	
	public static NBTTagCompound getTag(ItemStack stack)
	{
		if(stack.getTagCompound()==null)
		{
			stack.setTagCompound(new NBTTagCompound());
		}
		return stack.getTagCompound();
	}
	
	//Next two are from Joetato and for the magnet code.
		public static List<Entity> getEntitiesInRange(Class<? extends Entity> entityType, World world, double x, double y, double z, double radius) {
			return getEntitesInTange(entityType, world, x - radius, y - radius, z - radius, x + radius, y + radius,
					z + radius);
		}

		public static List<Entity> getEntitesInTange(Class<? extends Entity> entityType, World world, double x, double y, double z, double x2,
				double y2, double z2) {
			return world.getEntitiesWithinAABB(entityType, new AxisAlignedBB(x, y, z, x2, y2, z2));
		}
}
