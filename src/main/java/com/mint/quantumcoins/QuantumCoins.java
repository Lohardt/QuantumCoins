package com.mint.quantumcoins;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.mint.quantumcoins.core.ConfigHelper;
<<<<<<< HEAD
import com.mint.quantumcoins.core.DropHelper;
=======
>>>>>>> origin/master
import com.mint.quantumcoins.core.QuantumEvents;
import com.mint.quantumcoins.core.QuantumTab;
import com.mint.quantumcoins.core.proxy.IProxy;
import com.mint.quantumcoins.items.ItemHelper;
import com.mint.quantumcoins.lib.QuantumRef;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;



@Mod(modid = QuantumRef.MOD_ID, name = QuantumRef.MOD_NAME, version = QuantumRef.VERSION)


public class QuantumCoins
{	
	
	@Mod.Instance(QuantumRef.MOD_ID)
	public static QuantumCoins instance;
	
	@SidedProxy(clientSide = QuantumRef.CLIENT_PROXY, serverSide = QuantumRef.SERVER_PROXY)
	public static IProxy proxy;
	
	public static Logger quantumLogger;
	
	private static CreativeTabs quantumTab = new QuantumTab(CreativeTabs.getNextID(), QuantumRef.MOD_ID);

	public static CreativeTabs getCreativeTab()
	{
		return quantumTab;
	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		quantumLogger = Logger.getLogger(QuantumRef.MOD_ID);
		
		ConfigHelper.init(event.getSuggestedConfigurationFile());
		
		MinecraftForge.EVENT_BUS.register(new QuantumEvents());
<<<<<<< HEAD
=======
		
>>>>>>> origin/master
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		ItemHelper.init();
		
		DropHelper.populateDropPermissions();
		DropHelper.populateDropChance();
		DropHelper.populateDropMax();
		DropHelper.populateDroppedMeta();
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.info("Quantum Coins: Looks like everything ran correctly!");
	}
	
}