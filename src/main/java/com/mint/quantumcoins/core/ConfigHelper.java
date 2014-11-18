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
