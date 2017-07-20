package com.theundertaker11.bettermagnets.proxy;

import com.theundertaker11.bettermagnets.Reference;
import com.theundertaker11.bettermagnets.init.ItemRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		 ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Reference.MODID + ":" + id, "inventory"));
	}
	@Override
	public void registerRenders()
	{	/*
		regWithMetaAndName(ItemRegistry.MAGNET, 4, "magnet4");
		
		ResourceLocation UltMagnet = new ResourceLocation(Reference.MODID + ":" + "magnet4");
		
		ModelBakery.registerItemVariants(ItemRegistry.MAGNET, UltMagnet);
		*/
	}
	
	public static void regWithMetaAndName(Item item, int meta, String name) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(item, meta, new ModelResourceLocation(Reference.MODID + ":" + name, "inventory"));
	}
}
