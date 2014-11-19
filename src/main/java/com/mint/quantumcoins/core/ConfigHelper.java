package com.mint.quantumcoins.core;

import java.io.File;
import java.util.logging.Level;

import com.mint.quantumcoins.QuantumCoins;
import com.mint.quantumcoins.lib.QuantumSettings;
import static com.mint.quantumcoins.lib.QuantumSettings.defaults.*;
import static com.mint.quantumcoins.lib.QuantumSettings.settings.*;
import cpw.mods.fml.common.FMLLog;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHelper
{
	public static Configuration config;

	// Because each config section's loading is the same, we can pull the
	// repeated code out into a function
	private static String[] populateFromConfig(String section, String fieldPrefix, String[] defaults, String fallback)
	{
		// Initialize the array to coinNum values-- arrays can be arbitarily
		// sized, so, we can dynamically size this.
		String[] list = new String[coinNum];
		for (int i = 0; i < coinNum; i++)
		{
			// Pick the default name. Fall back if you have more coins than the
			// number of default names
			String defaultValue;

			if (i >= defaults.length){defaultValue = fallback;}
			else {defaultValue = defaults[i];}

			// Set the proper value in the coin name array
			list[i] = config.get(section, fieldPrefix + (i + 1),
                    defaultValue).getString();
		}
		
		return list;
	}

	public static void init(File quantumConfig)
	{
		config = new Configuration(quantumConfig);

		try
		{
			config.load();

			config.addCustomCategoryComment
			("Coin_Types", "Names for the coin types. E.G. Copper, Iron, Gold");

			config.addCustomCategoryComment
			("Coin_Colors","Color of the different coin types in a hex color code. E.G. A2DF4D" + "\n" +
			 "I suggest http://http://www.colorpicker.com for finding your hex color codes.");

			config.addCustomCategoryComment
			("Coin_Type_Extra_Info", "Extra information on the tooltip of the coin types E.G. 'Worth 5 copper coins'"+ "\n" + 
			 "If you dont want tooltip info put 'none' without the quotation marks");

			config.addCustomCategoryComment
			("Coin_Name_Colors", "Color of the coin type names in 0-f. k, l, m, n, and o may also be used." + "\n" + 
			 "Please see http://www.minecraftwiki.net/wiki/Formatting_codes for more information.");
			
			config.addCustomCategoryComment
			("Mob Drop Options","Options for configuring mob drops.");

/*#########################################################################################################################################################*/
			
			// Generic config options
			Property coinNumP = config.get("Items", "number_of_coins", DEFAULT_COIN_NUMBER);
			coinNum = coinNumP.getInt();
			coinNumP.comment = "Number of coins to use. NOTE: If you go higher then 5 you will need to launch minecraft" + "\n" + 
							   "and then close it to populate the config with the new variables for the extra coins.";

			Property coinNameP = config.get("Items", "coin_name", DEFAULT_COIN_NAME);
			coinName = coinNameP.getString();
			coinNameP.comment = "Name for the coins.";
			
			Property coinLetterP = config.get("Items", "coin_letter", DEFAULT_COIN_LETTER);
			coinLetter = coinLetterP.getString().toLowerCase();
			coinLetterP.comment = "Letter on the coin. You can use A-Z, 'dollar', 'cent', 'yen', and 'euro' without the quotes." + "\n" +
								"If you dont want a letter on it at all you can use 'base' without the quotes.";
			
			Property convertAmountP = config.get("Items", "convert_amount", DEFAULT_CONVERT_AMOUNT);
			convertAmount = convertAmountP.getInt();
			convertAmountP.comment = "Number of coins for a conversion.";

/*#########################################################################################################################################################*/
			
			Property zombieDropPermissionP = config.get("Mob Drop Options", "zombie_drop_permission", DEFAULT_ZOMBIE_DROP_PERMISSION);
			zombieDropPermission = zombieDropPermissionP.getBoolean();
			zombieDropPermissionP.comment = "Are zombies allowed to drop coins?";
			
			Property zombieDropChanceP = config.get("Mob Drop Options", "zombie_drop_chance", DEFAULT_ZOMBIE_DROP_CHANCE);
			zombieDropChance = zombieDropChanceP.getInt();
			zombieDropChanceP.comment = "Percentage out of 100 that zombies will drop coins.";
			
			Property zombieDropMaxP = config.get("Mob Drop Options", "zombie_drop_max", DEFAULT_ZOMBIE_DROP_MAX);
			zombieDropMax = zombieDropMaxP.getInt();
			zombieDropMaxP.comment = "Maximum amount of coins zombies will drop.";
			
			Property zombieDroppedMetaP = config.get("Mob Drop Options", "zombie_dropped_metadata", DEFAULT_ZOMBIE_DROPPED_META);
			zombieDroppedMeta = zombieDroppedMetaP.getInt();
			zombieDroppedMetaP.comment = "The metadata or 'tier' of coin zombies will drop. This starts counting at 0." + "\n" + 
										 "With default config 0 is Stone, 1 is Iron, 2 is Gold, 3 is Diamond, and 4 is Specal.";
			
			
			
			Property skeletonDropPermissionP = config.get("Mob Drop Options", "skeleton_drop_permission", DEFAULT_SKELETON_DROP_PERMISSION);
			skeletonDropPermission = skeletonDropPermissionP.getBoolean();
			skeletonDropPermissionP.comment = "Are skeletons allowed to drop coins?";
			
			Property skeletonDropChanceP = config.get("Mob Drop Options", "skeleton_drop_chance", DEFAULT_SKELETON_DROP_CHANCE);
			skeletonDropChance = skeletonDropChanceP.getInt();
			skeletonDropChanceP.comment = "Percentage out of 100 that skeletons will drop coins.";
			
			Property skeletonDropMaxP = config.get("Mob Drop Options", "skeleton_drop_max", DEFAULT_SKELETON_DROP_MAX);
			skeletonDropMax = skeletonDropMaxP.getInt();
			skeletonDropMaxP.comment = "Maximum amount of coins skeletons will drop.";
			
			Property skeletonDroppedMetaP = config.get("Mob Drop Options", "skeleton_dropped_metadata", DEFAULT_SKELETON_DROPPED_META);
			skeletonDroppedMeta = skeletonDroppedMetaP.getInt();
			skeletonDroppedMetaP.comment = "The metadata or 'tier' of coin skeletons will drop. This starts counting at 0." + "\n" + 
										 "With default config 0 is Stone, 1 is Iron, 2 is Gold, 3 is Diamond, and 4 is Specal.";
			
			
			
			Property spiderDropPermissionP = config.get("Mob Drop Options", "spider_drop_permission", DEFAULT_SPIDER_DROP_PERMISSION);
			spiderDropPermission = spiderDropPermissionP.getBoolean();
			spiderDropPermissionP.comment = "Are spiders allowed to drop coins?";
			
			Property spiderDropChanceP = config.get("Mob Drop Options", "spider_drop_chance", DEFAULT_SPIDER_DROP_CHANCE);
			spiderDropChance = spiderDropChanceP.getInt();
			spiderDropChanceP.comment = "Percentage out of 100 that spiders will drop coins.";
			
			Property spiderDropMaxP = config.get("Mob Drop Options", "spider_drop_max", DEFAULT_SPIDER_DROP_MAX);
			spiderDropMax = spiderDropMaxP.getInt();
			spiderDropMaxP.comment = "Maximum amount of coins spiders will drop.";
			
			Property spiderDroppedMetaP = config.get("Mob Drop Options", "spider_dropped_metadata", DEFAULT_SPIDER_DROPPED_META);
			spiderDroppedMeta = spiderDroppedMetaP.getInt();
			spiderDroppedMetaP.comment = "The metadata or 'tier' of coin spiders will drop. This starts counting at 0." + "\n" + 
										 "With default config 0 is Stone, 1 is Iron, 2 is Gold, 3 is Diamond, and 4 is Specal.";

/*#########################################################################################################################################################*/
			
			// Load each config field
			coinTypeName = populateFromConfig("Coin_Types", "coin_type_", DEFAULT_COIN_TYPE_NAME, "[name]");
			
			coinNameColor = populateFromConfig("Coin_Name_Colors", "coin_name_color_", DEFAULT_COIN_NAME_COLOR, "8");
			
			coinColor = populateFromConfig("Coin_Colors", "coin_color_", DEFAULT_COIN_COLOR , "FFFFFF");
			
			coinTypeInfo = populateFromConfig("Coin_Type_Extra_Info", "coin_type_extra_info_", DEFAULT_COIN_TYPE_INFO, "none");
		} 
		
		catch (Exception exception)
		{
			QuantumCoins.quantumLogger.log(Level.SEVERE, "Quantum Coins has had a problem loading its configuration!", exception);
		} 
		
		finally
		{
			config.save();
		}
	}
}
