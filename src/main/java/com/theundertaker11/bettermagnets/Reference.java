package com.theundertaker11.bettermagnets;

public class Reference {

	public static final String MODID = "bettermagnets";
	public static final String VERSION = "0.1";
	public static final String NAME = "Better Magnets";
	public static final String CLIENTPROXY = "com.theundertaker11.bettermagnets.proxy.ClientProxy";
	public static final String SERVERPROXY = "com.theundertaker11.bettermagnets.proxy.CommonProxy";

	/**NBTTag key used to tell if the magnet is on or not. */
	public static final String KEY = "active";
	/** String used to tell quickly if an item should be picked up */
	public static final String NO_PICKUP = "dontpickmeup";
	
	public static final String BaublesModID = "Baubles";//TODO change in 1.11
	
	
	private Reference() {
	    throw new IllegalAccessError("Ref class");
	  }
}
