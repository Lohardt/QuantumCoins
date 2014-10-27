package quantumcoins;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import quantumcoins.core.ConfigHelper;
import quantumcoins.core.QuantumTab;
import quantumcoins.core.proxy.IProxy;
import quantumcoins.items.ItemHelper;
import quantumcoins.lib.QuantumRef;
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
		
		//proxy.registerSoundHandler();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		ItemHelper.init();
	}

	@Mod.EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		FMLLog.info("Quantum Coins: Looks like everything ran correctly!");
	}
	
}