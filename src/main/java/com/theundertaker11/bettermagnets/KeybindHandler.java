package com.theundertaker11.bettermagnets;

import org.lwjgl.input.Keyboard;

import com.theundertaker11.bettermagnets.packets.ExtraPacket;
import com.theundertaker11.bettermagnets.packets.PacketHandler;
import com.theundertaker11.bettermagnets.packets.SendToggleMagnet;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber
public class KeybindHandler {

    public static KeyBinding keybindToggleMagnet;
    public static KeyBinding keybindIgnore;
    
    public static void init()
    {
    	keybindToggleMagnet = new KeyBinding("Toggle Magnet", Keyboard.KEY_M, "Better Magnets");
        ClientRegistry.registerKeyBinding(keybindToggleMagnet);
        keybindIgnore = new KeyBinding("Misc..", Keyboard.KEY_L, "");
        ClientRegistry.registerKeyBinding(keybindIgnore);
    }
    
    @SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void clientPlayerTick(TickEvent.PlayerTickEvent event)
	{
		if(KeybindHandler.keybindToggleMagnet.isPressed())
		{
			PacketHandler.INSTANCE.sendToServer(new SendToggleMagnet());
		}
		if(keybindIgnore.isPressed()) {
			PacketHandler.INSTANCE.sendToServer(new ExtraPacket());
		}
	}
}