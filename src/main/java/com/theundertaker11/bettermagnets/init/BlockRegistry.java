package com.theundertaker11.bettermagnets.init;

import com.theundertaker11.bettermagnets.blocks.BlockBase;
import com.theundertaker11.bettermagnets.util.IItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static Block anti_magnet_block;
	
	public static void init()
	{
		anti_magnet_block = register(new BlockBase("anti_magnet_block"));
	}
	
	private static <T extends Block> T register (T block, ItemBlock itemBlock)
	{
		 GameRegistry.register(block);
		 if(itemBlock != null)
		 {
		 GameRegistry.register(itemBlock);
		 }
		 
		 if(block instanceof IItemModelProvider)
		 {
		 ((IItemModelProvider)block).registerItemModel(itemBlock);
		 }
		 
		 return block;
	}
		 
	private static <T extends Block> T register(T block)
	{
		 ItemBlock itemBlock = new ItemBlock(block);
		 itemBlock.setRegistryName(block.getRegistryName());
		 return register(block, itemBlock);
	}
}
