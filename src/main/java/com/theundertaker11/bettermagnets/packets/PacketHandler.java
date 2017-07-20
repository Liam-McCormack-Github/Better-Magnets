package com.theundertaker11.bettermagnets.packets;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("bettermagnets");
	
	public static void init(){
		INSTANCE.registerMessage(SendToggleMagnet.Handler.class, SendToggleMagnet.class, 0, Side.SERVER);
	}
}
