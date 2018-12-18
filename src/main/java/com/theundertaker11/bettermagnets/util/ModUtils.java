package com.theundertaker11.bettermagnets.util;

import java.util.List;

import com.theundertaker11.bettermagnets.Reference;
import com.theundertaker11.bettermagnets.init.ItemRegistry;
import com.theundertaker11.bettermagnets.items.ItemMagnet;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;

public class ModUtils {

	public static boolean isStackEmpty(ItemStack stack) {
		return stack.isEmpty();
	}
	/**
	 * 
	 * @param stack
	 * @return True if magnet is now on, false if it is now off
	 */
	public static boolean toggleMagnet(ItemStack stack) {
		if (!isStackEmpty(stack) && stack.getItem() instanceof ItemMagnet) {
			getTag(stack).setBoolean(Reference.KEY, !getTag(stack).getBoolean(Reference.KEY));
			return getTag(stack).getBoolean(Reference.KEY);
		}
		return false;
	}
	public static void toggleMagnetWithMessage(ItemStack stack, EntityPlayer player) {
		if(toggleMagnet(stack))
			player.sendMessage(new TextComponentString("Magnet enabled"));
		else
			player.sendMessage(new TextComponentString("Magnet disabled"));
	}
	public static void disableMagnet(ItemStack stack) {
		if (!isStackEmpty(stack) && stack.getItem() instanceof ItemMagnet) {
			getTag(stack).setBoolean(Reference.KEY, false);
		}
	}

	public static boolean isMagnetActive(ItemStack stack) {
		return getTag(stack).getBoolean(Reference.KEY);
	}

	public static ItemStack findMagnet(EntityPlayer player) {
		try {
			ItemStack stack = findMagnetBaubles(player);
			if(!stack.isEmpty())
				return stack;
		}catch(NoSuchMethodError e) {}
		for(int i=0;i<player.inventory.getSizeInventory();i++)
    	{
    		ItemStack stack = player.inventory.getStackInSlot(i);
    		if(!ModUtils.isStackEmpty(stack)&&stack.getItem() instanceof ItemMagnet)
    		{
    			return stack;
    		}
    	}
		return ItemStack.EMPTY;
	}
	
	@Optional.Method(modid = "baubles")
	public static ItemStack findMagnetBaubles(EntityPlayer player) {
		IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
		for(int i=0;i<baubles.getSlots();i++) {
			ItemStack b = baubles.getStackInSlot(i);
			if(b.getItem() == ItemRegistry.MAGNET)
				return b;
		}
		return ItemStack.EMPTY;
	}
	public static NBTTagCompound getTag(ItemStack stack) {
		if (stack.getTagCompound() == null) {
			stack.setTagCompound(new NBTTagCompound());
		}
		return stack.getTagCompound();
	}

	// Next two are from Joetato and for the magnet code.
	public static List<Entity> getEntitiesInRange(Class<? extends Entity> entityType, World world, double x, double y,
			double z, double radius) {
		return getEntitesInTange(entityType, world, x - radius, y - radius, z - radius, x + radius, y + radius,
				z + radius);
	}

	public static List<Entity> getEntitesInTange(Class<? extends Entity> entityType, World world, double x, double y,
			double z, double x2, double y2, double z2) {
		return world.getEntitiesWithinAABB(entityType, new AxisAlignedBB(x, y, z, x2, y2, z2));
	}
}
