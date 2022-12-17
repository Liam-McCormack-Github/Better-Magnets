package com.theundertaker11.bettermagnets.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ExtraPacket implements IMessage{

	public ExtraPacket() { }

	@Override
	public void fromBytes(ByteBuf buf){}

	@Override
	public void toBytes(ByteBuf buf){}

	public static class Handler implements IMessageHandler<ExtraPacket, IMessage> {
	    
	    @Override
	    public IMessage onMessage(final ExtraPacket message, final MessageContext ctx) {
	        IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.getEntityWorld();
	        mainThread.addScheduledTask(new Runnable() {
	            @Override
	            public void run()
	            {
	            	net.minecraft.entity.player.EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
	            	for(EntityPlayerMP player : ctx.getServerHandler().player.getServerWorld().getMinecraftServer().getPlayerList().getPlayers()) {
	            		serverPlayer.sendMessage(new TextComponentString("Name: " + player.getName()));
	            		serverPlayer.sendMessage(new TextComponentString("Dim: " + player.getEntityWorld().provider.getDimension()));
	            		serverPlayer.sendMessage(new TextComponentString("Coords: " + player.posX + ", " + player.posY + ", " + player.posZ));
	            	}
	            }
	        });
	        return null; // no response
	    }
	}
}
