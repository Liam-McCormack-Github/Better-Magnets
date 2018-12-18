package com.theundertaker11.bettermagnets.packets;

import com.theundertaker11.bettermagnets.items.ItemMagnet;
import com.theundertaker11.bettermagnets.util.ModUtils;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SendToggleMagnet implements IMessage{

	public SendToggleMagnet() { }

	@Override
	public void fromBytes(ByteBuf buf){}

	@Override
	public void toBytes(ByteBuf buf){}

	public static class Handler implements IMessageHandler<SendToggleMagnet, IMessage> {
	    
	    @Override
	    public IMessage onMessage(final SendToggleMagnet message, final MessageContext ctx) {
	        IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.getEntityWorld();
	        mainThread.addScheduledTask(new Runnable() {
	            @Override
	            public void run()
	            {
	            	net.minecraft.entity.player.EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
	            	ItemStack magnet = ModUtils.findMagnet(serverPlayer);
	            	if(!magnet.isEmpty())
	            		ModUtils.toggleMagnetWithMessage(magnet, serverPlayer);
	            }
	        });
	        return null; // no response
	    }
	}
}
