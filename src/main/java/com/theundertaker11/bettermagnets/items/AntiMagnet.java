package com.theundertaker11.bettermagnets.items;

import java.util.List;

import javax.annotation.Nullable;

import com.theundertaker11.bettermagnets.BetterMagnetsMain;
import com.theundertaker11.bettermagnets.init.ItemRegistry;
import com.theundertaker11.bettermagnets.util.IItemModelProvider;
import com.theundertaker11.bettermagnets.util.ModUtils;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Stops the magnets from working when in a Player's inventory.");
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (world.isRemote)
			return;
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entity;
			
			//Disable ANY inventory magnets. ModUtils#disableMagnet() method is safe to call on any stack.
			for(int i = 0; i<player.inventory.getSizeInventory(); i++) {
				ItemStack invStack = player.inventory.getStackInSlot(i);
				ModUtils.disableMagnet(invStack);
			}
			
			//Disable bauble magnet
			ItemStack baubleMagnet = ItemStack.EMPTY;
			try {
				baubleMagnet = ModUtils.findMagnetBaubles(player);
			}catch(NoSuchMethodError e) {}
			if(!baubleMagnet.isEmpty()) 
				ModUtils.disableMagnet(baubleMagnet);
		}
	}
}
