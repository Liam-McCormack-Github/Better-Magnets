package com.theundertaker11.bettermagnets.blocks;

import com.theundertaker11.bettermagnets.BetterMagnetsMain;
import com.theundertaker11.bettermagnets.util.IItemModelProvider;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IItemModelProvider{

	protected String Name;
	
	public BlockBase(String name, Material material, float hardness, float resistance) {
		super(material);
		this.Name = name;
		setRegistryName(name);
		setTranslationKey(name);
		setCreativeTab(BetterMagnetsMain.BMtab);
		setHardness(hardness);
        setResistance(resistance);
	}

	public BlockBase(String name) {
        this(name, Material.ROCK, 0.5f, 0.5f);
    }
	
	@Override
	public void registerItemModel(Item item) {
		BetterMagnetsMain.proxy.registerItemRenderer(item, 0, Name);
	}

}
