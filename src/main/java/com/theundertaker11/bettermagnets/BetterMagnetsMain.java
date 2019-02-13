package com.theundertaker11.bettermagnets;

import com.theundertaker11.bettermagnets.init.BlockRegistry;
import com.theundertaker11.bettermagnets.init.ConfigMain;
import com.theundertaker11.bettermagnets.init.ItemRegistry;
import com.theundertaker11.bettermagnets.init.Recipes;
import com.theundertaker11.bettermagnets.packets.PacketHandler;
import com.theundertaker11.bettermagnets.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class BetterMagnetsMain
{
	public static final CreativeTabs BMtab = new BMCreativeTab(CreativeTabs.getNextID(), "BMTab");
	
	@SidedProxy(clientSide = Reference.CLIENTPROXY, serverSide = Reference.SERVERPROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance
    public static BetterMagnetsMain instance;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigMain.init(config);
		
		ItemRegistry.init();
		BlockRegistry.init();
		PacketHandler.init();
		if(event.getSide()==Side.CLIENT)
			KeybindHandler.init();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	Recipes.init();
    }
}
