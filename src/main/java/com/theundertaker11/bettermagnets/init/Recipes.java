package com.theundertaker11.bettermagnets.init;

import com.theundertaker11.bettermagnets.Reference;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

	public static void init() {
		//T1
		GameRegistry.addShapedRecipe(ItemRegistry.MAGNET.getRegistryName(), new ResourceLocation(Reference.MODID + "recipe1"), new ItemStack(ItemRegistry.MAGNET, 1, 0), new Object[]{
				"x x",
				"yzy",
				"yyy", 'y', "dustRedstone", 'x', "ingotIron", 'z', "materialEnderPearl"});
		//T2
		GameRegistry.addShapedRecipe(ItemRegistry.MAGNET.getRegistryName(), new ResourceLocation(Reference.MODID + "recipe2"), new ItemStack(ItemRegistry.MAGNET, 1, 1), new Object[]{
				"xyx",
				"yzy",
				"xyx", 'x', new ItemStack(ItemRegistry.MAGNET, 1, 0), 'y', "ingotIron", 'z', Items.ENDER_EYE});
		//T3
		GameRegistry.addShapedRecipe(ItemRegistry.MAGNET.getRegistryName(), new ResourceLocation(Reference.MODID + "recipe3"), new ItemStack(ItemRegistry.MAGNET, 1, 2), new Object[]{
				"xyx",
				"yzy",
				"xyx", 'x', new ItemStack(ItemRegistry.MAGNET, 1, 1), 'y', "ingotGold", 'z', Items.PRISMARINE_SHARD});
		//T4
		GameRegistry.addShapedRecipe(ItemRegistry.MAGNET.getRegistryName(), new ResourceLocation(Reference.MODID + "recipe4"), new ItemStack(ItemRegistry.MAGNET, 1, 3), new Object[]{
				"xyx",
				"yzy",
				"xyx", 'x', new ItemStack(ItemRegistry.MAGNET, 1, 2), 'y', "gemDiamond", 'z', Items.NETHER_WART});
		//T5 aka ultimate
		GameRegistry.addShapedRecipe(ItemRegistry.MAGNET.getRegistryName(), null, new ItemStack(ItemRegistry.MAGNET, 1, 4), new Object[]{
				"xyx",
				"yzy",
				"xyx", 'x', new ItemStack(ItemRegistry.MAGNET, 1, 3), 'y', "gemEmerald", 'z', Items.NETHER_STAR});
		
		//Anti magnet block
		//T2
		GameRegistry.addShapedRecipe(BlockRegistry.anti_magnet_block.getRegistryName(), null, new ItemStack(BlockRegistry.anti_magnet_block), new Object[]{
				"   ",
				"yzy",
				"   ", 'z', "cobblestone", 'y', Items.FERMENTED_SPIDER_EYE});
	}
}
